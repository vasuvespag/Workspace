package HotelAppBDD.HotelAppBDD;

import java.util.regex.Pattern;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HotelAppBDDTest {
	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  
	  @Given("I am on HotelApp login page")
	  public void goToHotelApp()
	  {
		  System.setProperty("webdriver.gecko.driver","C:\\Vasu\\geckodriver.exe");
		    driver = new FirefoxDriver();
		    driver.navigate().to("http://adactin.com/HotelApp");
		    System.out.println("Inside Given Block");
	  }
	  
		@When("^user enters \"(.*?)\" in username field$")
		public void user_enters_in_username_field(String arg1) {

			System.out.println(arg1);
			driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(arg1);
			
		}
		
		@When("^user enters \"(.*?)\" in password field$")
		public void user_enters_in_password_field(String arg1) {

			System.out.println(arg1);
			driver.findElement(By.id("password")).sendKeys(arg1);
			
		}
	  
	 /* @When("^I enter Username as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
	  public void I_enter_Username_as_and_Password_as(String arg1, String arg2)
	  {
		  System.out.println("Insdide When Block");
		  System.out.println(arg1);
	      driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(arg1);
	      driver.findElement(By.id("password")).sendKeys(arg2);
	      driver.findElement(By.id("login")).click();
	  }*/
		
	/*@When("User Clicks on Login")
		public void clickLogin()
		{
			driver.findElement(By.id("login")).click();
		}*/
		
		@When("^user clicks Sign in button$")
		public void user_clicks_Sign_in_button(){
		    // Write code here that turns the phrase above into concrete actions
			driver.findElement(By.id("login")).click();
		}
		
		@Then("^user gets login successful message$")
		public void user_gets_login_successful_message() {
		    // Write code here that turns the phrase above into concrete actions
			driver.quit();
		}
	  
	  
	  
}