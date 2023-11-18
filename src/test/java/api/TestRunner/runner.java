package api.TestRunner;
import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)


@CucumberOptions(features ={"src/test/resources/Features/"}, 
glue = {"api.StepDefinitions"}, 

monochrome = true, 
plugin = {"pretty",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm",
		"html:target/cucmberreport.html",
		"html:target/JUNITHtmlReports/report.html",
		"junit:target/JUNITReports/reports.xml"})

public class runner {

}
