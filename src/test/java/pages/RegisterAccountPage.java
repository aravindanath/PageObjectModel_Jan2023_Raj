package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterAccountPage extends BasePage{

    public RegisterAccountPage(WebDriver driver) {
        super(driver);
    }



    @FindBy(id = "input-firstname")
    public WebElement firstNameTextField;

    @FindBy(id = "input-lastname")
    public WebElement lastNameTextField;

    @FindBy(id = "input-telephone")
    public WebElement telephoneTextField;

    @FindBy(id = "input-email")
    public WebElement emailTextField;

    @FindBy(id = "input-password")
    public WebElement inputPasswordText;

    @FindBy(id = "input-confirm")
    public WebElement inputConfirmPasswordText;

    @FindBy(xpath = "//input[@name='agree']")
    public WebElement agreeCheckBox;

    @FindBy(xpath = "//*[@value='Continue' or text()='Continue']")
    public WebElement continueButton;

    @FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
    public WebElement verifyAccountCreation;




    public void enterMandatoryFields(String fn, String ln  , String email, String telephone, String password, String confirmPassword){
        firstNameTextField.sendKeys(fn);
        lastNameTextField.sendKeys(ln);
        emailTextField.sendKeys(email);
        telephoneTextField.sendKeys(telephone);
        inputPasswordText.sendKeys(password);
        inputConfirmPasswordText.sendKeys(confirmPassword);
        agreeCheckBox.click();
        continueButton.click();
    }

    public void verifyAccountCreationSuccessMsg(){
        BasePage.verifyTitle(verifyAccountCreation,"Your Account Has Been Created!");
    }

    public void verifyContinueButton(){
        BasePage.verifyElement(continueButton);
    }
}
