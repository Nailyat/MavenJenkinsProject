package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AddEmployeePage;
import pages.DashBoardPage;
import utils.CommonMethods;
import utils.Constants;
import utils.ExcelReading;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {

    DataTable dataTable;

    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        DashBoardPage dashBoardPage = new DashBoardPage();
        click(dashBoardPage.pimOption);
    }

    @When("user clicks on Add Employee button")
    public void user_clicks_on_add_employee_button() {
        DashBoardPage dashBoardPage = new DashBoardPage();
        click(dashBoardPage.addEmployeeButton);
    }

    @When("user enters firstname middlename and lastname")
    public void user_enters_firstname_middlename_and_lastname() {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        sendText(addEmployeePage.firstName, "Wednesday");
        sendText(addEmployeePage.middleName, "October");
        sendText(addEmployeePage.lastName, "Fall");
    }

    @When("user deletes employee id")
    public void user_deletes_employee_id() {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        addEmployeePage.employeeID.clear();
    }

    @When("user selects checkbox")
    public void user_selects_checkbox() {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        click(addEmployeePage.loginCheckBox);
    }

    @When("user enters username password and confirm password")
    public void user_enters_username_password_and_confirm_password() {
       AddEmployeePage addEmployeePage = new AddEmployeePage();
       sendText(addEmployeePage.userName, "GoldenFall");
       sendText(addEmployeePage.createPassword, "Hum@nhrm123");
       sendText(addEmployeePage.confirmPassword, "Hum@nhrm123");
    }

    /*@When("user clicks on save button")
    public void user_clicks_on_save_button() {
       AddEmployeePage addEmployeePage = new AddEmployeePage();
       click(addEmployeePage.saveButton);
    } */

    @Then("employee added successfully")
    public void employee_added_successfully() {
        System.out.println("Employee added successfully");
    }

    @When("user enters {string} {string} {string}")
    public void user_enters(String firstName, String middleName, String lastName) {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        sendText(addEmployeePage.firstName, firstName);
        sendText(addEmployeePage.middleName, middleName);
        sendText(addEmployeePage.lastName, lastName);
    }

    @When("user enters {string} {string} {string} for an employee")
    public void user_enters_for_employee(String firstName, String middleName, String lastName) {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        sendText(addEmployeePage.firstName, firstName);
        sendText(addEmployeePage.middleName, middleName);
        sendText(addEmployeePage.lastName, lastName);
    }

    @When("user add multiple employees and verify that user has been added successfully")
    public void user_add_multiple_employees_and_verify_that_user_has_been_added_successfully(DataTable employees) throws InterruptedException {
        List<Map<String, String>> employeeNames = employees.asMaps();
        for (Map<String, String> employeeName: employeeNames){
            String valueFirstName = employeeName.get("firstName");
            String valueMiddleName = employeeName.get("middleName");
            String valueLastName = employeeName.get("lastName");

            AddEmployeePage addEmployeePage = new AddEmployeePage();
            sendText(addEmployeePage.firstName, valueFirstName);
            sendText(addEmployeePage.middleName, valueMiddleName);
            sendText(addEmployeePage.lastName, valueLastName);

            click(addEmployeePage.saveButton);

            //Assertion in homework
            //verify the employee has been added

            DashBoardPage dashBoardPage = new DashBoardPage();
            click(dashBoardPage.addEmployeeButton);
            Thread.sleep(2000);
        }

    }

    @When("user adds multiple employees from excel file using {string} sheet and verify the added employee")
    public void user_adds_multiple_employees_from_excel_file_using_data(String sheetName) {
        List<Map<String, String>> newEmployees = ExcelReading.excelIntoListMap(Constants.TESTDATA_FILEPATH, sheetName);

        DashBoardPage dashBoardPage = new DashBoardPage();
        AddEmployeePage addEmployeePage = new AddEmployeePage();

        Iterator<Map<String, String>> iterator = newEmployees.iterator();
        while (iterator.hasNext()){
            Map<String, String> mapNewEmp = iterator.next();
            sendText(addEmployeePage.firstName, mapNewEmp.get("FirstName"));
            sendText(addEmployeePage.middleName, mapNewEmp.get("MiddleName"));
            sendText(addEmployeePage.lastName, mapNewEmp.get("LastName"));
            click(addEmployeePage.saveButton);
           // Assert.
            click(dashBoardPage.addEmployeeButton);
        }

    }
}
