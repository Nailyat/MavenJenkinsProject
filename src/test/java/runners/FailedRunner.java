package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "@target/failed.txt",

        glue = "steps",

        /* dryRun = true // checking all steps w/o real running, it quickly scans the whole feature file, then no actual execution happens */
        //dryRun = false,

        monochrome = true,  // keeps the console output for the cucumber test easily readable by removing all the unreadable characters

        //tags = "@errorValidationNewExample", // with any tags, there is no needed to put exact feature class in the path

        plugin = {"pretty"}
        //plugin - generates report for the execution
        // pretty takes care of printing the steps in console

        /* strict = true // checks all the steps definition */

)
public class FailedRunner {
}