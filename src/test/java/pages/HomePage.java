package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }



    @FindBy(xpath = "//span[text()='My Account']")
    public WebElement myAccountMenu;

    @FindBy(xpath = "//a[text()='Register']")
    public WebElement registerButton;

    @FindBy(xpath = "//a[text()='Login']")
    public WebElement loginButton;

    @FindBy(xpath = "//span[text()='Wish List (0)']")
    public WebElement wishList;

    @FindBy(xpath = "//span[text()='Checkout']")
    public WebElement checkoutButton;


    public void navigateToRegisterPage(){
        myAccountMenu.click();
        BasePage.waitForElement(2000);
        registerButton.click();
    }

    public void navigateToLoginPage(){
        myAccountMenu.click();
        BasePage.waitForElement(2000);
        loginButton.click();
    }
}
