package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.DashBoardPage;
import utils.CommonMethods;

import java.util.ArrayList;
import java.util.List;

public class DashboardSteps extends CommonMethods {

    @Then("user verify the dashboard options available on the page")
    public void user_verify_the_dashboard_options_available_on_the_page(DataTable dataTable) {
        List<String> expectedTabs = dataTable.asList();

        DashBoardPage dashBoardPage = new DashBoardPage();
        List<String> actualTabs = new ArrayList<>();

        for (WebElement element: dashBoardPage.dashboardTabs) { // loop takes each element from the dashboard list of tabs
            actualTabs.add(element.getText());
        }
        System.out.println(actualTabs);
        System.out.println(expectedTabs);

        Assert.assertTrue(expectedTabs.equals(actualTabs));
    }

}
