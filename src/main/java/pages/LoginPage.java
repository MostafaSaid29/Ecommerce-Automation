package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.TestUtil;

import static util.TestUtil.explicitWait;

public class LoginPage {
    WebDriver driver;
    By usernameLocator = By.id("loginusername");
    By passowrdLocator = By.id("loginpassword");
    By loginBtnLocator = By.xpath("//button[text()='Log in']");
    By userLocator = By.id("nameofuser");
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }
    public void setUserName(String username){
        TestUtil.sendKeys(driver,usernameLocator,username);
    }
    public void setPassword(String password){
        TestUtil.sendKeys(driver,passowrdLocator,password);
    }

    public void clickLogIn(){
            WebElement loginBtn = explicitWait(driver,loginBtnLocator);
            loginBtn.click();
    }
    public void logInSteps(String username, String password)
    {
        setUserName(username);
        setPassword(password);
        clickLogIn();
    }
    public String validateLogin()
    {
        WebElement user = explicitWait(driver,userLocator);
        return user.getText();
    }
}