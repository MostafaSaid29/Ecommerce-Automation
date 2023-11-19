package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.TestUtil;

import static util.TestUtil.explicitWait;

public class SignUpPage extends BaseClass {
    WebDriver driver;
    @FindBy(id="sign-username")
    WebElement usernameField;
    @FindBy(id = "sign-password")
    WebElement passwordField;
    @FindBy(xpath = "//button[text()='Sign up']")
    WebElement signUpBtn;

    public SignUpPage(WebDriver driver)
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

    public void clickSignUp(){
        try{
            explicitWait(driver,signUpBtn);
            signUpBtn.click();
        }catch (Exception e)
        {
            System.out.println("Couldn't find SignUpButton");
        }
    }
    public void signUpSteps(String username, String password)
    {
        setUserName(username);
        setPassword(password);
        clickSignUp();
    }
    public String alertMsg()
    {
        return TestUtil.handleAlert(driver);
    }
}
