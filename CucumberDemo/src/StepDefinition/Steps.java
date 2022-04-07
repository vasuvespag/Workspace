package StepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {
	
	@Given("^I am on HotelApp login page$")
	public void i_am_on_HotelApp_login_page() throws Throwable {
		System.out.println("Inside Given Block");
	}

	@When("^user enters username field$")
	public void user_enters_username_field() throws Throwable {
		System.out.println("Inside Given Block");
	}

	@When("^user enters in password field$")
	public void user_enters_in_password_field() throws Throwable {
		System.out.println("Inside Given Block");
	}

	@When("^user clicks Login button$")
	public void user_clicks_Login_button() throws Throwable {
		System.out.println("Inside Given Block");
	}

	@Then("^user gets login successful message$")
	public void user_gets_login_successful_message() throws Throwable {
		System.out.println("Inside Given Block");
	}



}
