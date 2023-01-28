package pages;

import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.ini4j.Ini;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Locale;
import java.util.Properties;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public static void takeScreenshot(WebDriver driver) {
        try {
            TakesScreenshot srcShot = (TakesScreenshot) driver; // Driver typecasting
            File out = srcShot.getScreenshotAs(OutputType.FILE);
            File path = new File("./screenshot.png");
            FileUtils.copyFile(out, path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void acceptAlert(WebDriver driver) {
        Alert ref = driver.switchTo().alert();
        System.out.println(ref.getText());
        ref.accept();
    }

    public static void dissmissAlert(WebDriver driver) {
        Alert alrt = driver.switchTo().alert();
        System.out.println(alrt.getText());
        alrt.dismiss();
    }


    public static void acceptAlert(WebDriver driver, String text) {
        Alert alrt = driver.switchTo().alert();
        System.out.println(alrt.getText());
        alrt.sendKeys(text);
        alrt.accept();
    }

    public static void mouseHover(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public static void click(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.click(element).build().perform();
    }

    public static void dragAndDrop(WebDriver driver, WebElement element1, WebElement element2) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(element1, element2).build().perform();
    }

    public static void rightClick(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.contextClick(element).build().perform();
    }

    public static void scroll(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver; // Type Casting driver to javascript
        js.executeScript("arguments[0].scrollIntoView();", element); // Standard argument for scrolling
    }

    public static String email() {
        Faker faker = new Faker(new Locale("en-IND"));
        String emid = faker.name().fullName().replace(" ", "") + "@test.com";
        System.out.println("Email: " + emid);
        return emid;
    }


    public static String firstName() {
        Faker faker = new Faker(new Locale("en-IND"));
        String emid = faker.name().firstName();
        System.out.println("First: " + emid);
        return emid;
    }

    public static String lastName() {
        Faker faker = new Faker(new Locale("en-IND"));
        String emid = faker.name().lastName();
        System.out.println("LastName: " + emid);
        return emid;
    }

    public static String mobileNumber() {
        Faker faker = new Faker(new Locale("en-IND"));
        String emid = faker.number().digits(10);
        System.out.println("MobileNumber: " + emid);
        return emid;
    }

    public static void selectBYvalue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public static void selectBYIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    public static void selectBYVisibleText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public static String getValue(String key)  {
        String path = System.getProperty("user.dir")+ File.separator+"config.properties";
        String value = null;
        try{
            BufferedReader reader = new BufferedReader(new FileReader(path));
            Properties properties = new Properties();
            properties.load(reader);
            value = properties.getProperty(key);
        }catch (Exception e){
            e.printStackTrace();
        }
        return value;
    }


    public static String getValue(String title, String key)  {
        String path = System.getProperty("user.dir")+File.separator+"data.ini";
        String value = null;
        try{
            BufferedReader reader = new BufferedReader(new FileReader(path));
            Ini properties = new Ini();
            properties.load(reader);
            value = properties.get(title,key);
        }catch (Exception e){
            e.printStackTrace();
        }
        return value;
    }


    public static void waitForElement(long timeout){
        try{
            Thread.sleep(timeout);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }


    public static void verifyTitle(WebElement element,String title){
        String actual = element.getText();
        Assert.assertEquals(actual, title,"Title not matching");
    }

    public static void verifyElement(WebElement element){
        Assert.assertTrue(element.isDisplayed());
    }
}
