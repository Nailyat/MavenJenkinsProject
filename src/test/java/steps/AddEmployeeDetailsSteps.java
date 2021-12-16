package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.support.ui.Select;
import pages.EmployeeListPage;
import utils.CommonMethods;

public class AddEmployeeDetailsSteps extends CommonMethods {

    @Given("user click on edit button")
    public void user_click_on_edit_button() {
        EmployeeListPage employeeListPage = new EmployeeListPage();
        click(employeeListPage.saveButton);
    }

    @Given("user adding to employee file all new information")
    public void user_adding_to_employee_file_all_new_information() throws InterruptedException {
        EmployeeListPage employeeListPage = new EmployeeListPage();
        click(employeeListPage.saveButton);
        Thread.sleep(1500);

        sendText(employeeListPage.driverLicense, "123456789");
        sendText(employeeListPage.licenseExpDate, "2025-05-05");
        sendText(employeeListPage.personalDOB, "1986-06-12");
        Select select =new Select(employeeListPage.maritalStatus);
        select.selectByVisibleText("Married");
        click(employeeListPage.smokerCheckbox);
        Select select1 = new Select(employeeListPage.nationality);
        select1.selectByVisibleText("American");
        sendText(employeeListPage.militaryStatus, "NAVY");
    }
    @Then("user click on save button")
    public void user_click_on_save_button() {
        EmployeeListPage employeeListPage = new EmployeeListPage();
        click(employeeListPage.saveButton);
    }







}