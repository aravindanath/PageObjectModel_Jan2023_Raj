package testScripts.login;

import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import testScripts.BaseTest;

public class TC_LF_001  extends BaseTest {

    @Test
    public void TC_LF_001(){
        String email = BasePage.getValue("TC_LF_001","email"),
                password = BasePage.getValue("TC_LF_001","password");

        HomePage hp = new HomePage(driver);
        hp.navigateToLoginPage();
        LoginPage lp =  new LoginPage(driver);
        lp.enterCredentials(email, password);

    }

}
