package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static util.TestUtil.explicitWait;

public class HomePage {
    WebDriver driver;
    By signUpBtnLocator = By.id("signin2");
    By loginBtnLocator = By.id("login2");
    By logoLocator = By.xpath("//img[@src='Samsung1.jpg']");
    By phonesLocator = By.partialLinkText("Phones");
    By myPhoneLocator = By.partialLinkText("Samsung galaxy s6");
    By laptopsLocator = By.partialLinkText("Laptops");
    By myLaptopLocator = By.partialLinkText("Sony vaio i5");
    By monitorsLocator = By.partialLinkText("Monitors");
    By myMonitorLocator = By.partialLinkText("Apple monitor 24");
    By cartBtnLocator = By.partialLinkText("Cart");
    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }
    public boolean validateHomePage()
    {
        WebElement logo = explicitWait(driver,logoLocator);
        return logo.isDisplayed();
    }
    public SignUpPage goToSignUpPage()
    {
        WebElement signUp = explicitWait(driver,signUpBtnLocator);
        signUp.click();
        return new SignUpPage(driver);
    }
    public LoginPage goToLoginPage()
    {
        WebElement logIn = explicitWait(driver,loginBtnLocator);
        logIn.click();
        return new LoginPage(driver);
    }
    public ProductPage getPhone()
    {

        WebElement Phones = explicitWait(driver,phonesLocator);
        Phones.click();
        WebElement myPhone = explicitWait(driver,myPhoneLocator);
        myPhone.click();
        return new ProductPage(driver);
    }
    public ProductPage getLaptop()
    {
        WebElement Laptops = explicitWait(driver,laptopsLocator);
        Laptops.click();
        WebElement myLaptop = explicitWait(driver,myLaptopLocator);
        myLaptop.click();
        return new ProductPage(driver);
    }
    public ProductPage getMonitor()
    {
        WebElement Monitors = explicitWait(driver,monitorsLocator);
        Monitors.click();
        WebElement myMonitor = explicitWait(driver,myMonitorLocator);
        myMonitor.click();
        return new ProductPage(driver);
    }
    public CartPage goToCartPage()
    {
        WebElement cart = explicitWait(driver,cartBtnLocator);
        cart.click();
        return new CartPage(driver);
    }
}