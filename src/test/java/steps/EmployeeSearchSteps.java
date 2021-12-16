package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashBoardPage;
import pages.EmployeeListPage;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

public class EmployeeSearchSteps extends CommonMethods {

   /* @Given("user is navigated to HRMS")
    public void user_is_navigated_to_hrms() {
       openBrowser();
    } */

    @Given("user is logged in with valid admin credentials")
    public void user_is_logged_in_with_valid_admin_credentials() {
        LoginPage loginPage = new LoginPage();
        sendText(loginPage.usernameBox, ConfigReader.getPropertyValue("username"));
        sendText(loginPage.passwordBox, ConfigReader.getPropertyValue("password"));
        click(loginPage.loginButton);
    }

    @Given("user navigates to employee list page")
    public void user_navigates_to_employee_page() {
        DashBoardPage dashBoardPage = new DashBoardPage();
        click(dashBoardPage.pimOption);
        click(dashBoardPage.employeeListOption);
    }

    @When("user enters valid employee id")
    public void user_enters_valid_employee_id() {
        EmployeeListPage employeeListPage = new EmployeeListPage();
        sendText(employeeListPage.idEmployee, "22819000");
    }

    @When("click on search button")
    public void click_on_search_button() {
        EmployeeListPage employeeListPage = new EmployeeListPage();
        click(employeeListPage.searchButton);
    }

    /* @When("user enters valid employee name")
    public void user_enters_valid_employee_name() {
        EmployeeListPage employeeListPage = new EmployeeListPage();
        sendText(employeeListPage.employeeNameField, "Sohail");
    } */

   /* @Then("user see employee information is displayed")
    public void user_see_employee_information_is_displayed() {
        System.out.println("Info is displayed");
        tearDown();
    } */

    @Given("user see employee information is displayed and click on the employee name")
    public void user_see_employee_information_is_displayed_and_click_on_the_employee_name() {
        EmployeeListPage employeeListPage = new EmployeeListPage();
        click(employeeListPage.employeeName);
    }

    @Then("user clicks on desired employee name on the result table")
    public void user_clicks_on_desired_employee_name_on_the_result_table() {
        EmployeeListPage employeeListPage = new EmployeeListPage();
        click(employeeListPage.searchResultTable);
    }

}
