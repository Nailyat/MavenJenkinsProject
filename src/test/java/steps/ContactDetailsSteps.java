package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.ContactDetailsPage;
import pages.EmployeeListPage;
import utils.CommonMethods;

public class ContactDetailsSteps extends CommonMethods {

    @When("user clicks on Contact Details on sidebar")
    public void user_clicks_on_contact_details_on_sidebar() {
        EmployeeListPage employeeListPage = new EmployeeListPage();
        click(employeeListPage.empContactDetails);
    }

    @When("user clicks on edit button")
    public void user_clicks_on_edit_button() {
        ContactDetailsPage contactDetailsPage = new ContactDetailsPage();
        click(contactDetailsPage.contactDetailsEDITbutton);
    }
    @When("user adds employee contact details")
    public void user_adds_employee_contact_details() {
        ContactDetailsPage contactDetailsPage = new ContactDetailsPage();
        sendText(contactDetailsPage.empContactStreet1, "123 Washington st.");
        sendText(contactDetailsPage.empContactStreet2, "Apt 2045");
        sendText(contactDetailsPage.empContactCity, "Washington DC");
        /*Select select = new Select(contactDetailsPage.empContactState);
        select.selectByVisibleText("District of Columbia"); */
        sendText(contactDetailsPage.empContactZipcode, "20017");
       /* Select select1 = new Select(contactDetailsPage.empContactCountry);
        select1.selectByVisibleText("United States"); */
        sendText(contactDetailsPage.empContactTel, "123-456-7890");
        sendText(contactDetailsPage.empContactMobile, "123-980--7654");
        sendText(contactDetailsPage.empContactWorkTel, "123-890-7564");
        sendText(contactDetailsPage.empContactEmail, "emp@gmail.com");
        sendText(contactDetailsPage.empContactOtherEmail, "other@gmail.com");
    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        ContactDetailsPage contactDetailsPage = new ContactDetailsPage();
        click(contactDetailsPage.contactDetailsEDITbutton);
    }

    @Then("employee contact details added successfully")
    public void employee_contact_details_added_successfully() {
        ContactDetailsPage contactDetailsPage = new ContactDetailsPage();
        Assert.assertTrue(contactDetailsPage.formEmpContactDetails.isDisplayed());
    }

}
