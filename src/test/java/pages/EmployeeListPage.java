package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class EmployeeListPage extends CommonMethods {

    @FindBy(id = "empsearch_id")
    public WebElement idEmployee;

    @FindBy(id = "searchBtn")
    public WebElement searchButton;

    @FindBy (xpath = "//*[@id='resultTable']/tbody/tr/td[2]")
    public WebElement searchResultTable;

    @FindBy (xpath = "//*[text()='Contact Details']")
    public WebElement empContactDetails;

    @FindBy(id = "empsearch_employee_name_empName")
    public WebElement employeeNameField;

    @FindBy(xpath = "//*[@id='resultTable']/tbody/tr/td[2]")
    public WebElement employeeName;

    @FindBy(id = "btnSave")
    public WebElement saveButton;

    @FindBy(id = "personal_txtLicenNo")
    public WebElement driverLicense;

    @FindBy(id = "personal_txtLicExpDate")
    public WebElement licenseExpDate;

    @FindBy(id = "personal_DOB")
    public WebElement personalDOB;

    @FindBy(id = "personal_cmbMarital")
    public WebElement maritalStatus;

    @FindBy(id = "personal_chkSmokeFlag")
    public WebElement smokerCheckbox;

    @FindBy(id = "personal_cmbNation")
    public WebElement nationality;

    @FindBy(id = "personal_txtMilitarySer")
    public WebElement militaryStatus;

    public EmployeeListPage(){
        PageFactory.initElements(driver,this);
    }



}
