package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AddEmployeePage extends CommonMethods {

    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy(id = "middleName")
    public WebElement middleName;

    @FindBy(id = "lastName")
    public WebElement lastName;

    @FindBy(id = "photofile")
    public WebElement downloadFile;

    @FindBy(id = "user_name")
    public WebElement userName;

    @FindBy(id = "chkLogin")
    public WebElement loginCheckBox;

    @FindBy(id = "user_password")
    public WebElement createPassword;

    @FindBy(id = "re_password")
    public WebElement confirmPassword;

    @FindBy(id = "btnSave")
    public WebElement saveButton;

    @FindBy(id = "employeeId")
    public WebElement employeeID;

    public AddEmployeePage(){
        PageFactory.initElements(driver, this);
    }

}
