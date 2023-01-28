package testScripts.register;

import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.RegisterAccountPage;
import testScripts.BaseTest;

public class TC_RF_001 extends BaseTest {


    @Test
    public void TC_RF_001() {

        String fn = BasePage.firstName(), ln = BasePage.lastName(), email = BasePage.email(),
                telephone = BasePage.mobileNumber(),password = "password@123";

        HomePage hp = new HomePage(driver);
        hp.navigateToRegisterPage();

        RegisterAccountPage rap = new RegisterAccountPage(driver);
        rap.enterMandatoryFields(fn, ln, email,telephone, password, password);
        rap.verifyAccountCreationSuccessMsg();
        rap.verifyContinueButton();


    }
}
