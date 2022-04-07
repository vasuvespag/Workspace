package com.stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HotelAppExample {
	WebDriver driver;
	@Given("User is on HotelApp Login Page")
	public void user_is_on_hotel_app_login_page() {
		System.setProperty("webdriver.chrome.driver","E:\\drivers\\chromedriver_win32\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.navigate().to("http://adactin.com/HotelApp");
	    System.out.println("Inside Given");
	}

	@When("User enters Username")
	public void user_enters_username() {
		driver.findElement(By.id("username")).sendKeys("vasuvespag");
		
		System.out.println("Inside When1");
	}

	@When("User enters Password")
	public void user_enters_password() {
		driver.findElement(By.id("password")).sendKeys("Vasu1234");
		System.out.println("Inside When2");
	}
	
	@When("User enters Username as <{string}>")
	public void user_enters_username_as(String username) {
		driver.findElement(By.id("username")).sendKeys(username);
		System.out.println("Inside param When1");
	}

	@When("User enters Password as <{string}>")
	public void user_enters_password_as(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
		System.out.println("Inside Param When2");
	}

	@When("User Clicks on Login button")
	public void user_clicks_on_login_button() {
		driver.findElement(By.id("login")).click();
		System.out.println("Inside When3");
	}

	@Then("Login is successful")
	public void login_is_successful() {
		driver.quit();
		System.out.println("Inside Then	");
	}

}
