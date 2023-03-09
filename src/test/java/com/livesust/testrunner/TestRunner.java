package com.livesust.testrunner;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
	@CucumberOptions(features = { "src//test//resources//Features" }, 
	glue = {"com.livesust.stepdefinition","com.livesust.engineController"}, 
	plugin = {"json:target/cucumber.json", "html:target/cucumber.html"},
	tags = "@signinn",
	monochrome = true, 
	dryRun = false)


	public class TestRunner {
		

	}

