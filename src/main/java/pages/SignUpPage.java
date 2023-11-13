package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
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

        usernameField.sendKeys(username);
    }
    public void setPassword(String password){

        passwordField.sendKeys(password);

    }

    public void clickSignUp(){

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
        return driver.switchTo().alert().getText();
    }
    public void acceptAlert()
    {
        driver.switchTo().alert().accept();
    }
}
