package functions;

import jxl.*;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class HotelApp_BusinessFunctions {
	
	public static Properties prop;
	public static WebDriver driver;
	
	public void HA_BF_Login (WebDriver driver, String sUserName, String sPassword ) throws InterruptedException {
		

		// Provide user name.
			              driver.findElement(By.xpath(prop.getProperty("Txt_Login_Username"))).clear();
			 driver.findElement(By.xpath(prop.getProperty("Txt_Login_Username"))).sendKeys(sUserName);

		 // Provide Password.
		driver.findElement(By.id(prop.getProperty("Txt_Login_Password"))).clear();
			  driver.findElement(By.id(prop.getProperty("Txt_Login_Password"))).sendKeys(sPassword);

		 // Click on Login button.
		driver.findElement(By.id(prop.getProperty("Btn_Login_Login"))).click();
		Thread.sleep(4000);

		// Verify for welcome message.
		try
		{

			WebElement welcomeTxt = driver.findElement(By.xpath(prop.getProperty("Lbl_SearchHotel_WelcomeMessage")));
			String text = welcomeTxt.getAttribute("value");

				if(text.contains("Hello "+ sUserName))
				{
					System.out.println("Login Test Pass for: "+ sUserName);
					return;
				}	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		   System.out.println("Login Test Fail for: "+sUserName);
		   // to show the results as fail.
		   assert false;  	
		}
 			

		}
		



 
	
	//This function is used to read data from specified cell of Excel sheet once you give Excelsheet name and path
	
	public static String HA_GF_readXL (int row, String column, String strFilePath) 
	{
			Cell c= null;
			int reqCol=0;
			WorkbookSettings ws = null;
			Workbook workbook = null;
			Sheet sheet = null;
			FileInputStream fs = null;
	try{
		fs = new FileInputStream(new File(strFilePath));
		ws = new WorkbookSettings();
		ws.setLocale(new Locale("en", "EN"));
				
		// opening the work book and sheet for reading data
		workbook = Workbook.getWorkbook(fs, ws);
		sheet = workbook.getSheet(0);
		
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
				c = sheet.getCell(reqCol, row);
				fs.close();
				return c.getContents();
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
	
	
	
	public static int HA_GF_XLRowCount (String strFilePath, String sColumn)
	{
		int k;
		for (k = 1; k < 999; k++)
		{
		
		String sParamVal = 	HA_GF_readXL(k,sColumn,strFilePath);
			if (sParamVal.equals("ENDOFROW"))
				{
					break;
				}
		
		}
		
		return k;
		
	}
	
	
	//Function to dynamically wait for element presence
	
	public void HA_GF_WaitForElementPresent(WebDriver driver , By by, int iTimeOut) throws InterruptedException
	{
		int iTotal = 0;
		int iSleepTime = 5000;
		while(iTotal < iTimeOut)
		{
			List<WebElement> oWebElements = driver.findElements(by);
			if(oWebElements.size()>0)
				return;
			else
			{
				
					Thread.sleep(iSleepTime);
					iTotal = iTotal + iSleepTime;
					System.out.println(String.format("Waited for %d milliseconds.[%s]", iTotal, by));          
				
				
			}
		}
	}

	
	
	//Function to dynamically wait for webelement to achieve its property value
	
	
	public void HA_GF_WaitForPropertyValue(WebDriver driver , By by, String ExpPropertyVal, String PropertName,  int iTimeOut) throws InterruptedException
	{
		int iTotal = 0;
		int iSleepTime = 5000;
		while(iTotal < iTimeOut)
		{
			List<WebElement> oWebElements = driver.findElements(by);
			if(oWebElements.size()>0)
					for (WebElement weOption : oWebElements)
					{
						if(weOption.getAttribute(PropertName).equalsIgnoreCase(ExpPropertyVal))
						{
							return;
						}
						else
							
						{
							Thread.sleep(iSleepTime);
							iTotal = iTotal + iSleepTime;
							System.out.println(String.format("Waited for %d milliseconds.[%s]", iTotal, by));          
						}
							
					}
			else
			{
				
					Thread.sleep(iSleepTime);
					iTotal = iTotal + iSleepTime;
					System.out.println(String.format("Waited for %d milliseconds.[%s]", iTotal, by));          
				
				
			}
		}
	}

	
}
