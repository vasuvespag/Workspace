package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ParametrizationTest {
	private WebDriver driver;
	  private String baseUrl;
	  private String Username;
	  private String Password;
	  

	@Before
	public void setUp() throws Exception {
		Properties prop = new Properties();
		prop.load(new FileInputStream(".\\Configuration\\LoginDetails.txt"));
		baseUrl=prop.getProperty("sAppURL");
		Username = prop.getProperty("Username");
		Password = prop.getProperty("Password");
		System.setProperty("webdriver.chrome.driver", "D:\\Vasu\\Vasu\\Vasu\\drivers\\ChromeDriver\\chromedriver.exe");
	      driver = new ChromeDriver();
	      //baseUrl = "http://adactinhotelapp.com";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws Exception {
		
		//driver.close();
	}

	@Test
	public void test() throws IOException {
		driver.get(baseUrl);
		driver.findElement(By.xpath(".//*[@id='username']")).clear();
	    driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(Username);
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys(Password);
	    driver.findElement(By.id("login")).click();
	    String ModuleName = "Login";
	    String Result = "Login Successful";
	    String Comment = "User Logged in Successfully";
	    
	    writeText(ModuleName, Result, Comment);
	    appendText(ModuleName, Result, Comment);
		String strFile = "./DataPool/HA_HotelSearch.xls";
	 	String Location[] =  HA_GF_readXL(1,"Location",strFile);
	 	for(int iter = 1; iter<Location.length;iter++)
	 	{
	 	String strLocation=Location[iter];
	 	new Select(driver.findElement(By.id("location"))).selectByVisibleText(strLocation);
	 	}
	}
	
	public static String[] HA_GF_readXL (int row, String column, String strFilePath) 
	{
			Cell c= null;
			int reqCol=0;
			int reqRow=0;
			WorkbookSettings ws = null;
			Workbook workbook = null;
			Sheet sheet = null;
			FileInputStream fs = null;
	try{
		fs = new FileInputStream(new File(strFilePath));
		ws = new WorkbookSettings();
		ws.setLocale(new Locale("en", "EN"));
		String[] data = null;
				
		// opening the work book and sheet for reading data
		workbook = Workbook.getWorkbook(fs, ws);
		sheet = workbook.getSheet(0);
		data = new String[sheet.getRows()];
		
		// Sanitise given data
		String col = column.trim();
		
		
		//loop for going through the given row
		for(int j=0; j<sheet.getColumns(); j++)
		{
			Cell cell = sheet.getCell(j,0);
			if((cell.getContents().trim()).equalsIgnoreCase(col))
			{	
				reqCol= cell.getColumn();
				//System.out.println("column No:"+reqCol);  
			 for (int i = 0; i < sheet.getRows(); i++)
             {
				c = sheet.getCell(reqCol, reqRow);
				data[i] = c.getContents();
				System.out.println(data[i]);
				fs.close();
				reqRow=reqRow+1;
			}
			 return data;
			}
			
		}
		
	}
	catch(BiffException be)
	{
		
		System.out.println("The given file should have .xls extension.");
	}
	catch(Exception e)
	{
		e.printStackTrace();
		
	}
	System.out.println("NO MATCH FOUND IN GIVEN FILE: PROBLEM IS COMING FROM DATA FILE");
	
	return null;
	}
	
	public static void writeText(String ModuleName, String Result, String Comment) throws IOException
	{
		//File file = new File("log.txt");
		FileWriter fw = new FileWriter("log.txt", true);
		
		fw.write(ModuleName +  Result + Comment);
		
		fw.close();
		
		
		
	}
	
	public static void appendText(String ModuleName, String Result, String Comment) throws IOException
	{
		//File file = new File("log.txt");
		FileWriter fw = new FileWriter("log.txt", true);
		
		fw.append(ModuleName +  Result + Comment);
		
		fw.close();
		
		
		
	}

}
