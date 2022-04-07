package com.stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;

public class TestExample {
	
	@Before
	public void beforeScenario()
	{
		System.out.println("This is run before a scenario");
	}
	
	
	
	@After
	public void afterScenario()
	{
		System.out.println("This is run after a scenario");
	}
}
