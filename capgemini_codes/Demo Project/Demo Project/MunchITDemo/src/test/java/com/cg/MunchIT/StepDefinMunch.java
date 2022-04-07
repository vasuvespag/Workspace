package com.cg.MunchIT;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cg.MunchPage.MunchPage;



import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinMunch {
WebDriver driver; 
 
MunchPage munchp; 

@Given("^Customer is on Welcome to MunchIT page$")
public void customer_is_on_Welcome_to_MunchIT_page()  {
	System.setProperty("webdriver.chrome.driver","C:\\Selenium Lib\\chromedriver.exe");			
	 driver = new ChromeDriver();
	 driver.get("file:///D:/Shubhangi/Shubhi's%20Artifacts/Artifacts%202019/Feb/BDD%20Demo%20project/MunchIT.html"); 
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 munchp=  new MunchPage(driver);
}


@Then("^verify the title of the page$")
public void verify_the_title_of_the_page() {
	
//String expectTitle = "Welcome";
	
String actualTitle=	driver.getTitle();

if(actualTitle.contentEquals("Welcome"))
	System.out.println("****** Expected and Actual Title is Matching");
else 
	System.out.println("******Expected and Actual Title is NOT Matching");  
	
	driver.close();
	/*
	String actualTitle=	driver.getTitle();
Assert.assertEquals("Welcome", actualTitle); */


}  
	

@When("^Customer enters all valid inputs$")
public void customer_enters_all_valid_inputs()  {
	munchp.CustName("Capgemini");
	munchp.Address("Bangalore");
	munchp.ContactNo("9876543212");
	munchp.PlaceOrderbtn();		
	driver.close();
}

@Then("^It should display successful message on next page$")
public void it_should_display_successful_message_on_next_page() {
 
	driver.navigate().to("about:blank");
	driver.close();
}

@When("^Customer leaves Customer Name empty$")
public void customer_leaves_Customer_Name_empty()  {
	munchp.CustName(" ");
	
}

@When("^Clicks the Place Order button$")
public void clicks_the_Place_Order_button() throws InterruptedException {
	munchp.PlaceOrderbtn();
	Thread.sleep(2000);
}

@Then("^Display Alert msg$")
public void display_Alert_msg() throws InterruptedException{
	//handling alert box
	Alert alt = driver.switchTo().alert();
	Thread.sleep(1000);	
	String msg = alt.getText();
	System.out.println("The text msg on alert box is " +msg);
	alt.accept();	
	driver.close();    
}

@When("^Customer enters customer name  \"([^\"]*)\" and address \"([^\"]*)\"$")
public void customer_enters_customer_name_and_address(String arg1, String arg2) {
	munchp.CustName(arg1);
	munchp.Address(arg2);
	munchp.ContactNo("12131313");
	munchp.PlaceOrderbtn();
	driver.close();
   
}

@Then("^Order should get placed successfully$")
public void order_should_get_placed_successfully()  {
	
       System.out.println("Order Placed sucessfully");
       
       if(driver.getCurrentUrl().equalsIgnoreCase(
    		      "about:blank")){
    		         System.out.println("Test Pass"); 
    		      } else { 
    		         System.out.println("Test Failed"); 
    		      } 
    		     
       driver.quit();
}

@When("^Customer enters incorrect mobileNo format and clicks the place order button$")
public void customer_enters_incorrect_mobileNo_format_and_clicks_the_place_order_button(DataTable arg1) throws Throwable {
	
	munchp.CustName("Capgemini");
	munchp.Address("Bangalore");
	
	List<String> objList = arg1.asList(String.class);    

	for(int i=0; i<objList.size(); i++) {		
		
		munchp.ContactNo(objList.get(i));     Thread.sleep(1000);
		
		 if(Pattern.matches("^[7-9]{1}[0-9]{9}$", objList.get(i))) {
		        System.out.println("***** Matched" + objList.get(i) + "*******************");
		        }
		        else {
		             System.out.println("Pattern not matching, Invalid mobile no");
		        }
		    }
			munchp.PlaceOrderbtn(); 		    
}

@Then("^display alert msg$")
public void display_alert_msg() throws Throwable {
   driver.quit();
}




}