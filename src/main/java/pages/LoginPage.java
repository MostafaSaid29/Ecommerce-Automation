package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

        usernameField.sendKeys(username);
    }
    public void setPassword(String password){

        passwordField.sendKeys(password);

    }

    public void clickLogIn(){

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
        return user.getText();
    }
}
