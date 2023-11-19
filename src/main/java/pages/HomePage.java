package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static util.TestUtil.explicitWait;

public class HomePage {
    WebDriver driver;
    @FindBy(id = "signin2") WebElement signUp;
    @FindBy(id = "login2") WebElement login;
    @FindBy(partialLinkText = "Home") WebElement Home;
    @FindBy(xpath = "//img[@src='Samsung1.jpg']") WebElement logo;
    @FindBy(partialLinkText = "Phones") WebElement Phones;
    @FindBy(partialLinkText = "Samsung galaxy s6") WebElement myPhone;
    @FindBy(partialLinkText = "Laptops") WebElement Laptops;
    @FindBy(partialLinkText = "Sony vaio i5") WebElement myLaptop;
    @FindBy(partialLinkText = "Monitors") WebElement Monitors;
    @FindBy(partialLinkText = "Apple monitor 24") WebElement myMonitor;
    @FindBy(partialLinkText = "Cart") WebElement cart;
    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public boolean validateHomePage()
    {
        return logo.isDisplayed();
    }
    public SignUpPage goToSignUpPage()
    {
        signUp.click();
        return new SignUpPage(driver);
    }
    public LoginPage goToLoginPage()
    {
        try{
            explicitWait(driver,login);
            login.click();
        }catch(Exception e){
            System.out.println("Couldn't find login Button");
        }
        return new LoginPage(driver);
    }
    public ProductPage getPhone()
    {
        explicitWait(driver,Phones);
        Phones.click();
        explicitWait(driver,myPhone);
        myPhone.click();
        return new ProductPage(driver);
    }
    public ProductPage getLaptop()
    {
        explicitWait(driver,Laptops);
        Laptops.click();
        explicitWait(driver,myLaptop);
        myLaptop.click();
        return new ProductPage(driver);
    }
    public ProductPage getMonitor()
    {
        explicitWait(driver,Monitors);
        Monitors.click();
        explicitWait(driver,myMonitor);
        myMonitor.click();
        return new ProductPage(driver);
    }
    public CartPage goToCartPage()
    {
        explicitWait(driver,cart);
        cart.click();
        return new CartPage(driver);
    }
}
