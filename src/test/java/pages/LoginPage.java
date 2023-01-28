package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "input-email")
    public WebElement emailTextField;

    @FindBy(id = "input-password")
    public WebElement inputPasswordText;

    @FindBy(xpath = "//input[@value='Login']")
    public WebElement loginButton;

    @FindBy(xpath = "//h2[text()='My Account']")
    public WebElement myAccountTitle;


    public void enterCredentials(String email, String password) {
        emailTextField.sendKeys(email);
        inputPasswordText.sendKeys(password);
        loginButton.click();
        BasePage.verifyTitle(myAccountTitle,"My Account");
    }






}
