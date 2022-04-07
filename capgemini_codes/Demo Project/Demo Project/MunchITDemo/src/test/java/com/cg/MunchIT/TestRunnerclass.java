package com.cg.MunchIT;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},
dryRun=false
		)

public class TestRunnerclass {

}
