package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class ContactDetailsPage extends CommonMethods {


    @FindBy (id = "btnSave")
    public WebElement contactDetailsEDITbutton;

    @FindBy(id = "contact_street1")
    public WebElement empContactStreet1;

    @FindBy (id = "contact_street2")
    public WebElement empContactStreet2;

    @FindBy (id = "contact_city")
    public WebElement empContactCity;

    @FindBy (id = "contact_province")
    public WebElement empContactState;

    @FindBy (id = "contact_emp_zipcode")
    public WebElement empContactZipcode;

    @FindBy (id = "contact_country")
    public WebElement empContactCountry;

    @FindBy (id = "contact_emp_hm_telephone")
    public WebElement empContactTel;

    @FindBy (id = "contact_emp_mobile")
    public WebElement empContactMobile;

    @FindBy (id = "contact_emp_work_telephone")
    public WebElement empContactWorkTel;

    @FindBy (id = "contact_emp_work_email")
    public WebElement empContactEmail;

    @FindBy (id = "contact_emp_oth_email")
    public WebElement empContactOtherEmail;

    @FindBy (id = "frmEmpContactDetails")
    public WebElement formEmpContactDetails;


    public ContactDetailsPage(){
        PageFactory.initElements(driver, this);
    }
}
