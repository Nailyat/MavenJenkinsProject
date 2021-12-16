package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.CommonMethods;

public class Hooks extends CommonMethods {

    @Before
    public void start(){
        openBrowser();
    }

    @After
    public void end(Scenario scenario){
        byte[] picture;
        if(scenario.isFailed()){
            picture = takeScreenshot("failed/"+scenario.getName());
        }else {
            picture = takeScreenshot("passed/"+scenario.getName());
        }
        scenario.attach(picture, "image/png", scenario.getName()); //attach the screenshot(picture) to the report
        tearDown();
    }
}
