package com.GmailBDDTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 
import org.openqa.selenium.interactions.Actions;
 
import cucumber.api.DataTable;
import cucumber.api.Transpose;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.Examples;
import cucumber.runtime.CucumberException;
import cucumber.runtime.ParameterInfo;
import cucumber.runtime.xstream.LocalizedXStreams;


public class GMailTestDef {
	
	 
	
	    static public WebDriver driver;
	    @Given("^I am on Gmail login page$")
	    public void i_am_on_Gmail_login_page() throws InterruptedException{
	        System.setProperty("webdriver.chrome.driver","Executables/chromedriver.exe");
	        driver= new ChromeDriver();
	        Actions act = new Actions(driver);
	        driver.manage().window().maximize();
	        driver.navigate().to("https://www.google.com/gmail/about");
	        driver.findElement(By.xpath("//div[4]/ul/li[2]/a")).click();
	        Thread.sleep(3000);
	    }
	    @When("^I specify Username and Password$")
	    public void i_specify_Username_and_Password() throws InterruptedException{
	        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("xxxxxx@xxx.com");
	        driver.findElement(By.xpath("//*[@id='identifierNext']/content/span")).click();
	        Thread.sleep(3000);
	        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("xxxxxxxxxxx");
	    }
	 
	    @When("^Click on SignIn button$")
	    public void click_on_SignIn_button() throws InterruptedException{
	 
	        driver.findElement(By.xpath("//*[@id='passwordNext']/content/span")).click();
	       Thread.sleep(5000);
	    }
	    @When("^I am on New Email Page$")
	    public void i_am_on_New_Email_Page(){
	    }
	    @When("^I specify following details$")
	    public void i_specify_following_details(DataTable tables)throws Throwable{
	            for (Map<String, String> row : tables.asMaps(String.class,String.class))
	            {
	                driver.findElement(By.xpath("//*[@id=':x4']/div/div")).click();
	                //driver.switchTo().
	                System.out.println(row.get("To1"));
	                System.out.println(row.get("Subject"));
	                String whandle = driver.getWindowHandle();
	                driver.switchTo().window(whandle);
	 
	                driver.findElement(By.xpath("//td[@class='eV']/div[1]/div/textarea")).sendKeys(row.get("To1"));                   
	                driver.findElement(By.xpath("//table[@class='aoP aoCbvf']/tbody/tr/td/form/div[3]/input")).sendKeys(row.get("Subject"));   
	     
	                driver.findElement(By.xpath("//table[@class='IZ']/tbody/tr/td/div")).click();
	           Thread.sleep(3000);
	            }
	         }
	    
	    
	        @When("^then click on Send button$")
	        public void then_click_on_Send_button(){
	            // Write code here that turns the phrase above into concrete actions
	        }
	        @Then("^I should be able to send the email successfully$")
	        public void i_should_be_able_to_send_the_email_successfully() {
	            // Write code here that turns the phrase above into concrete actions
	        }
}
