package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.DashBoardPage;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

import java.util.List;
import java.util.Map;

public class LoginSteps extends CommonMethods {

    DataTable dataTable;

    @When("user enters valid admin username and password")
    public void user_enters_valid_admin_username_and_password() {
        LoginPage loginPage = new LoginPage();
        sendText(loginPage.usernameBox, ConfigReader.getPropertyValue("username"));
        sendText(loginPage.passwordBox, ConfigReader.getPropertyValue("password"));
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        LoginPage loginPage = new LoginPage();
        click(loginPage.loginButton);
    }

    @Then("admin user is successfully logged in")
    public void admin_user_is_successfully_logged_in() {
        DashBoardPage dashBoardPage = new DashBoardPage();
        Assert.assertTrue(dashBoardPage.welcomeMessage.isDisplayed());
    }

    @When("user enters valid ess username and password")
    public void user_enters_valid_ess_username_and_password() {
        LoginPage loginPage = new LoginPage();
        sendText(loginPage.usernameBox, "johnny1234560000");
        sendText(loginPage.passwordBox, "Syntax1253!!!!");
    }

    @Then("ess user is successfully logged in")
    public void ess_user_is_successfully_logged_in() {
        DashBoardPage dashBoardPage = new DashBoardPage();
        Assert.assertTrue(dashBoardPage.welcomeMessage.isDisplayed());
    }

    @When("user enters valid username and invalid password")
    public void user_enters_valid_username_and_invalid_password() {
        LoginPage loginPage = new LoginPage();
        sendText(loginPage.usernameBox, "Admin");
        sendText(loginPage.passwordBox, "Syntax1253!!!!");
    }

    @Then("user see invalid credentials message on login page")
    public void user_see_invalid_credentials_message_on_login_page() {
       LoginPage loginPage = new LoginPage();
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
    }

    @When("user enters invalid credentials and clicks on login button and verify the error")
    public void user_enters_invalid_credentials_and_clicks_on_login_button_and_verify_the_error(DataTable errorValidation) {
        List<Map<String, String>> errorData = errorValidation.asMaps();
        for (Map<String, String> validation : errorData){
            String usernameValue = validation.get("username");
            String passwordValue = validation.get("password");
            String errorMessageValue = validation.get("errorMessage");

            LoginPage loginPage = new LoginPage();
            sendText(loginPage.usernameBox, usernameValue);
            sendText(loginPage.passwordBox, passwordValue);
            click(loginPage.loginButton);

            String errorMessageActual = loginPage.errorMessage.getText();
            Assert.assertEquals("Values do not match", errorMessageActual, errorMessageValue);

        }
    }

    @When("user enters invalid {string} and {string} and clicks on login button and verify the {string}")
    public void user_enters_invalid_and_and_clicks_on_login_button_and_verify_the(String username, String password, String errorMessage) {
        LoginPage loginPage = new LoginPage();
        sendText(loginPage.usernameBox, username);
        sendText(loginPage.passwordBox, password);
        click(loginPage.loginButton);

        String errorMessageActual = loginPage.errorMessage.getText();
        Assert.assertEquals("Values do not match", errorMessageActual, errorMessage);
    }

    }
