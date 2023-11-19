package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import util.TestUtil;

import java.io.IOException;
import java.time.Duration;

public class BaseClass {
    protected static WebDriver driver;
    protected HomePage homePage;
    protected SignUpPage signUpPage;
    protected LoginPage loginPage;
    protected ProductPage Phone;
    protected ProductPage Laptop;
    protected ProductPage Monitor;
    protected CartPage cartPage;
    public static String[][] excel;
    public static int totalPrice = 0;
    @BeforeSuite
    public void setUp()
    {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.demoblaze.com/index.html");
        driver.manage().window().maximize();

    }
    @BeforeMethod
    public void initialization(){
        homePage = new HomePage(driver);
    }
    @DataProvider(name = "SignUpData")
    public String[][] getData() throws IOException
    {
        excel = TestUtil.getDataFromExcel();
        return excel;
    }
    @AfterSuite
    public void tearDown()
    {
        driver.quit();
    }
}
