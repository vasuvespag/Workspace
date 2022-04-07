package com.Utilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Hooks {

	@Before
	public void beforeScenario()
	{
		System.out.println("This is run before every scenario");
	}
	
	@Before("@Second")
	public void beforeSecond()
	{
		System.out.println("This is run only before second scenario");
	}
	
	@Given("this is the precon first step")
	public void this_is_the_precon_first_step() {
	    System.out.println("Precondition first step");
	}

	@When("this is the precon second step")
	public void this_is_the_precon_second_step() {
		System.out.println("Precondition second step");
	}

	@Then("this is the precon third step")
	public void this_is_the_precon_third_step() {
		System.out.println("Precondition third step");
	}
	
	@Given("this is the first step")
	public void this_is_the_first_step() {
		System.out.println("First Step");
	}

	@When("this is the second step")
	public void this_is_the_second_step() {
		System.out.println("Second Step");
	}

	@Then("this is the third step")
	public void this_is_the_third_step() {
	    System.out.println("Third Step");
	}

	
	@After
	public void afterScenario()
	{
		System.out.println("This is run after every scenario");
	}
}
