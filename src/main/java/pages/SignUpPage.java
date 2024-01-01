package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.TestUtil;

import static util.TestUtil.explicitWait;
import static util.TestUtil.handleAlert;

public class SignUpPage extends BaseClass {
    WebDriver driver;
    By usernameLocator = By.id("sign-username");
    By passwordLocator = By.id("sign-password");
    By signUpBtnLocator = By.xpath("//button[text()='Sign up']");

    public SignUpPage(WebDriver driver)
    {
        this.driver = driver;
    }
    public void setUserName(String username){
        TestUtil.sendKeys(driver,usernameLocator,username);
    }
    public void setPassword(String password){
        TestUtil.sendKeys(driver,passwordLocator,password);
    }

    public void clickSignUp(){
            WebElement signUpBtn = explicitWait(driver,signUpBtnLocator);
            signUpBtn.click();
    }
    public void signUpSteps(String username, String password)
    {
        setUserName(username);
        setPassword(password);
        clickSignUp();
    }
    public String alertMsg()
    {
        return handleAlert(driver);
    }
}