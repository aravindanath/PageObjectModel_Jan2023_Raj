package testScripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.BasePage;

import java.util.concurrent.TimeUnit;

public class BaseTest {


    protected WebDriver driver;

    @BeforeClass
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(BasePage.getValue("url"));
        driver.manage().window().maximize();
    }


    @AfterClass
    public void tearDown() {
        BasePage.waitForElement(6000);
        driver.quit();
    }
}
