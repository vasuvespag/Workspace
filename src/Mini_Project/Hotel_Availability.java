 /*********************************************************************************************************
 *Script Description:
 *Step-1:-Open the application https://www.trivago.in/ in chrome or fire fox browser.
 *Step-2:-In search field, enter City �Mumbai� as destination.
 *Step-3:-Select Check-In Date for the next week (e.g. 27 July)
 *Step-4:-Select Check-Out Date for the next week (e.g.28 July)
 *Step-5:-Select Adults 1 and Select Rooms 1
 *Step-6:-Click on Apply.
 *Step-7:-Click on Search.
 *Step-8:-Select Sort By �Rating only�
 *Step-9:-Get the list of Rent of the hotels displayed.
 *Step-10:-Check that the all the ratings of the hotels is in descending order (e.g. 10.0>9.8>9.6..)
 *Step-11:-Check whether the first five hotels contains the specific city searched for. Ex: Mumbai
 *Step-12:-Close the browser 
 *************************************************************************************************************
 *Cohort Id:-INTQEA21QE001
 *Author:Prathamesh Ashok Kulkarni
 *Employee Id:904306
 *Mini-Project Name: Find_Hotel_Availability
 *Date of Creation:-30/03/2021
 *
 ***************************************************************************************************************/

package Mini_Project;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class Hotel_Availability {

	
	 static WebDriver driver;
		
/******* System setting details ***************/
		@BeforeClass
		public void data() {
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			 driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			
			 }
		/*************Method to invoke to the 'trivago' site **********/
		@Test(priority=1)
		public void invoke() throws IOException {
			
		
			FileInputStream ft = new FileInputStream("./Input_Data/Input_data.properties");
			 Properties p = new Properties();
			 p.load(ft);
			 
			   
			//step-1:-Invoke the hotel trivago site
			 
		    //By using input_data file the URL is being entered
			 String BaseURL = p.getProperty("URL");
			 driver.navigate().to(BaseURL);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            //Screen shot of invoked page
            File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    	 try {
				Files.copy(src, new File("./Screenshots/Invoked_page.png"));
			} catch (IOException e) {
			
				e.printStackTrace();
			}
            
            //To see properly the elements to be selected we scroll it down
			 ((JavascriptExecutor)driver).executeScript("scroll(0,200)");
			 //Validate whether the correct page invoked.
			 if(driver.findElement(By.linkText("Hotel Search")).isDisplayed()) {
				 System.out.println("Invoke successfully");
			 }else {
				 System.out.println("Invoke Fail");
			 }
		}
		
		/************Verify whether the city entered in placeholder****************/	 
			 @Test(priority=2)
			 public void verifycity() throws  IOException{
					FileInputStream ft = new FileInputStream("./Input_Data/Input_data.properties");
					 Properties p = new Properties();
					 p.load(ft);
				 
			// step-2:- enter the city name in text box
			//Fetch the city from input_data file 
			 driver.findElement(By.id("querytext")).sendKeys(p.getProperty("city"));
			 try {
				Thread.sleep(4000);         //wait till 4 sec to see the city entered
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			 String city=driver.findElement(By.id("querytext")).getAttribute("value");

			 //Validate were city name written correctly
			 if(city.equalsIgnoreCase(p.getProperty("city"))) {
			 System.out.println("City Name written successfully");
			 }else {
				 System.out.println("City Name not matches with input");
			 }
			 
		}
			 /***********Select the Check-in Date from date picker******************/
	     @Test(priority=3)
		public void check_in_date() throws InterruptedException, IOException {
	    		FileInputStream ft = new FileInputStream("./Input_Data/Input_data.properties");
	   		 Properties p = new Properties();
	   		 p.load(ft);
			
			 //step-3:-Select Check-in Date for the next week
	   		 
	 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[4]/div/div[1]/form/div/div[2]/button/span/span[1]")).click();
	 Thread.sleep(2000);
	 
			 //click on Next Weekend option
			 driver.findElement(By.id("i3")).click();
			 while(true) {
				String text= driver.findElement(By.xpath("//th[@id='cal-heading-month']")).getText();
				
				//Fetch the month and year from input_data file
				 if(text.equals(p.getProperty("check_in_month_year"))) {
					 break;
				 }else {
					 driver.findElement(By.xpath("//button[@class='cal-btn-next' and @type='button']")).click();
				 }
			 }
			 
			//stored all the dates for particular month in list
			 List<WebElement> lis = driver.findElements(By.xpath("/html/body/div[2]/div[2]/div[4]/div/div[1]/form/div/div[4]/div[2]/div/table[1]/tbody/tr/td"));
			 
			 for(WebElement po:lis) {
			 String p1 = po.getText();
			 //Fetch the check_in date from input_data file
			 if(p1.contains(p.getProperty("check_in_date"))) {
				 po.click();	
				 
				 System.out.println("Check in Date entered successfully");
			 }}

	 }

		 /***********Select the Check-out Date from date picker******************/

	     @Test(priority=4)
	 public void check_out_date() throws IOException {
		 FileInputStream ft = new FileInputStream("./Input_Data/Input_data.properties");
			 Properties p = new Properties();
			 p.load(ft);
			//Step-4:-Select Check-Out Date for the next week
			 //click on Next Weekend option
			 driver.findElement(By.id("i3")).click();
			 while(true) {
				String text= driver.findElement(By.xpath("//th[@id='cal-heading-month']")).getText();
				
				//Fetch the month and year from input_data file
				 if(text.equals(p.getProperty("check_out_month_year"))) {
					 break;
				 }else {
					 driver.findElement(By.xpath("//button[@class='cal-btn-next' and @type='button']")).click();
				 }
			 }
			 //stored all the dates for particular month in list
			 List<WebElement> lis1 = driver.findElements(By.xpath("/html/body/div[2]/div[2]/div[4]/div/div[1]/form/div/div[4]/div[2]/div/table[1]/tbody/tr/td"));
			 
			 for(WebElement y:lis1) {
			 String p11 = y.getText();
			 
			//Fetch the check_out date from input_data file
			 if(p11.contains(p.getProperty("check_out_date"))) {
				 y.click();
				 System.out.println("Check out date entered successfully");
				 break;
			 }}

			
	        
		}
	 
	 /****************Select the persons and room in this method**********************/
	     @Test(priority=5)
	     public void verify_persons_and_rooms()  {
	    	 //Step-5:Select the number of persons and rooms
	    	 try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    	 driver.findElement(By.xpath("//button[@class='circle-btn circle-btn--minus' and contains(@data-role,'removeAdult')]")).click();
	    	 try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    	 //Step-6:Click on apply
	    	 driver.findElement(By.xpath("//button[@data-role='applyConfigBtn' and @type='button']")).click();
	    	 //validate whether the number of persons and rooms selected
	    	 if(driver.findElement(By.xpath("//span[@class='dealform-button__head' and text()='1 Room']")).isDisplayed()) {
	    		 if(driver.findElement(By.xpath("//span[@class='dealform-button__label' and text()='1 Guest']")).isDisplayed()) {
	    			 System.out.println("persons and rooms selected successfully");
	    		 }
	    		 
	    	 }else {
	    		 System.out.println("Not selected properly");
	    	 }
	    	 
	    	 
	     }
	     
	     /*****************Click on Search button*****************/
	     @Test(priority=6)
	     public void search()  {
	           //Step-7:Click on Search button 
	    	 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[4]/div/div[1]/form/div/button[2]/span[2]")).click();
	    	 try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
			
				e1.printStackTrace();
			}
	     	 String heading=driver.getTitle();
	     	//validate whether the correct page invoke after click on search
	     	 boolean message=heading.equals("Mumbai Hotels | Find & compare great deals on trivago");
	     	 if(message) {
	     	 System.out.println("Search successfully");
	     	 }else {
	     		 System.out.println("Not getting searched to correct page");
	     	 }
	     	 //Screenshot of next page after searching
	     	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    	 try {
				Files.copy(src, new File("./Screenshots/Next_Page_to_search.png"));
			} catch (IOException e) {
			
				e.printStackTrace();
			}
	     	 
	     }

	     /*************Display Hotels list of the specific city searched for. Ex: Mumbai************/
	     @Test(priority=7)
	     public void display_hotels()  {
	    	 //Step-8:Select the 'Rating only' option
	    	 Select sort = new Select(driver.findElement(By.id("mf-select-sortby")));
	    	 try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				
				e1.printStackTrace();
			}
	    	 //select the Rating only option from drop down
	    	 sort.selectByVisibleText("Rating only");
	    	 try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				
				e1.printStackTrace();
			}
	    	 
	    	 //Screenshot of selected option
	    	 File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    	 try {
				Files.copy(src, new File("./Screenshots/Selected_option.png"));
			} catch (IOException e) {
			
				e.printStackTrace();
			}
	    	 //validate whether the rating only selected 
	    	 if(driver.findElement(By.xpath("//option[@value='4']")).isDisplayed()) {
	    		 System.out.println("Rate only option is selected successfully");
	    //Step-9:Print all hotel rents on console
	    		 //stored the value of hotel rents in list
	    	   List<WebElement> lst = driver.findElements(By.xpath("//strong[@data-qa='recommended-price']"));
	    	   //stored the hotel names in list
	    	   List<WebElement> lst1 = driver.findElements(By.xpath("//span[@class='item-link name__copytext name__copytext--small']"));
		        
		        int count = lst.size();   
		        for(int i =0;i<count;i++) {
		          
		        	for(i =0;i<count;i++) {
		        		 String val2 = lst1.get(i).getText();
		        		 String val1 = lst.get(i).getText();
		 	  
		            System.out.println("The hotel rent for "+val2+" is :Rs. "+val1.substring(1));
		        }}
		        System.out.println("List of Hotels displayed successfully");
		        }else {
		        	System.out.println("Rating only option not selected properly");
		        	
		        }
	     }
	     
	     /****************Check that the all the ratings of the hotels is in descending order************************/
	    	 @Test(priority=8)
	    	 public void sort_rating(){ 
	    		 //Step-10:check the rating of hotels is in descending order or not
	    		 
	    	   List lst1 = new ArrayList();
	    	   
	    	   //stored the actual rating  of hotels which is to be displayed in list
		 	   List<WebElement> lst11 = driver.findElements(By.xpath("//span[@itemprop='ratingValue']"));
		        
		        int count1 = lst11.size();
		      
		        
		        for(int j=0;j<count1;j++) {
		           String data=lst11.get(j).getText();
		           lst1.add(data);
		           
		        }
		        List temp = new ArrayList();
		        
		        //Add all the ratings of list11 in temp list
		        temp.addAll(lst1);
		      //sort the temp list in descending order
		        Collections.sort(temp,Collections.reverseOrder());
		      //check whether the actual list lst11 and expected list temp list is same
		        boolean poi =lst1.equals(temp);
		        if(poi) {
		        	System.out.println("The rating of hotels in descending order");
		        }else
		        	{System.out.println("The rating not in descending order");}
	     }
	    	 /**************** Check that the first 5 hotels contains the specific city searched for. Ex: Mumbai********************/
	    	 @Test(priority=9)
	    	 public void validate_city() throws InterruptedException, IOException {
	    		 //Step-11:Check that the first 5 hotels contains the specific city searched
	    		 FileInputStream ft = new FileInputStream("./Input_Data/Input_data.properties");
				 Properties p = new Properties();
				 p.load(ft);
				 
	    		 int count=0;
	      	   	    		 for(int i=1;i<=5;i++) {
	    			 
	    			 Thread.sleep(2000);
	    			 String first_string="/html/body/div[2]/main/div[1]/div[1]/div[3]/div/div[1]/div[2]/div[1]/div/section/ol/li[";
	    			 String second_string="]/div/article/div[1]/div[2]/div/div/div[2]/div/p";
	    			 String main_string=first_string+i+second_string;
	    		 driver.findElement(By.xpath(main_string)).click();
	    		 Thread.sleep(5000);
                 //Get information of first five hotel to find the specific city contain hotel
	    		 String mess = driver.findElement(By.xpath("//div[@itemprop='description']")).getText();
	    		//validate the hotels contains the specific city to be searched
	    		 if(mess.contains(p.getProperty("city"))) {
	    			 count++;
	    		 }
	    		 driver.findElement(By.xpath(main_string)).click();
	    		 Thread.sleep(2000);
	    		 }
	      	   	    		 //validate whether the first five hotels contains specific city searched
	    		 if(count==5) {
	    			 System.out.println("The first five hotels contain the "+p.getProperty("city")+" city");
	    		 }else {
	    			 System.out.println("The city not mentioned in it");
	    		 }
	    	 }
	    	 
	    	 /*******************The site will closed in this method****************/
	     @AfterClass
	     public void close() {
	    	 //Step-12:close the browser
	    	 driver.quit();
	    	 System.out.println("Close application successfully");
	     }
}
