package com.qa.runners;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.utility.setUp;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.Pickle;
import io.cucumber.testng.TestNGCucumberRunner;

@CucumberOptions( features = "src/main/resources/com/features",

glue = { "com.qa.stepDefinitions" },

tags = { "@Test" },
plugin = {

		"pretty",
		"io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm",
		})
public class testRunner 
{
	public TestNGCucumberRunner testNGCucumberRunner;
	setUp set=new setUp();
	
	
	@BeforeSuite
	public void before()
	{
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        set.envSetUp();
	}
	@Test(dataProvider = "scenarios")
	public void scenario(Pickle pickle) throws Throwable 
	{
		testNGCucumberRunner.runScenario(pickle);
	}
	
	@DataProvider()
	public Object[][] scenarios() 
	{
		return testNGCucumberRunner.provideScenarios();
	}
	@AfterSuite
	public void after()
	{
		testNGCucumberRunner.finish();
	}
	


}
