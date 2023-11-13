import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import pages.*;
import util.TestUtil;

import java.io.IOException;
import java.time.Duration;

public class BaseClassTest {
    protected static WebDriver driver;
    protected HomePage homePage;
    protected SignUpPage signUpPage;
    protected LoginPage loginPage;
    protected ProductPage Phone;
    protected ProductPage Laptop;
    protected ProductPage Monitor;
    protected CartPage cartPage;
    @Parameters({"URL"})
    @BeforeSuite
    public void setUp(String url)
    {
        //Create a New Object of WebDriver
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        // Navigate to website, maximize window
        driver.get(url);
        driver.manage().window().maximize();

    }
    @BeforeMethod
    public void initialization()
    {
        homePage = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @DataProvider(name = "LoginData")
    public String[][] getData() throws IOException
    {
        return TestUtil.getDataFromExcel();
    }
    @AfterSuite
    public void tearDown()
    {
        driver.quit();
    }
}
