package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.TestUtil;

import static util.TestUtil.explicitWait;

public class LoginPage {
    WebDriver driver;
    @FindBy(id = "loginusername") WebElement usernameField;
    @FindBy(id= "loginpassword") WebElement passwordField;
    @FindBy(xpath = "//button[text()='Log in']") WebElement loginBtn;
    @FindBy(id = "nameofuser") WebElement user;
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void setUserName(String username){
        TestUtil.sendKeys(driver,usernameField,username);
    }
    public void setPassword(String password){
        TestUtil.sendKeys(driver,passwordField,password);
    }

    public void clickLogIn(){
        try{
            explicitWait(driver,loginBtn);
            loginBtn.click();
        }catch (Exception e)
        {
            System.out.println("Couldn't find login Button");
        }

    }
    public void logInSteps(String username, String password)
    {
        setUserName(username);
        setPassword(password);
        clickLogIn();
    }
    public String validateLogin()
    {
        explicitWait(driver,user);
        return user.getText();
    }
}
