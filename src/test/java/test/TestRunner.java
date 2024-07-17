package test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.Test;

@RunWith(Cucumber.class)

@CucumberOptions(
		features = "src/test/java/aFeatures",
		plugin = "pretty",
		snippets = CucumberOptions.SnippetType.CAMELCASE,
		glue = {""}, 
		monochrome = true, 
		dryRun = false, 
		//strict = true,
		tags = "@acessaSistemaPCA"
		)

@Test(priority = 11)
public class TestRunner{

}
