package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    WebDriver driver;
    @FindBy(xpath = "//button[text()='Place Order']")
    WebElement orderBtn;
    @FindBy(id = "name")
    WebElement nameField;
    @FindBy(id = "country")
    WebElement countryField;
    @FindBy(id = "city")
    WebElement cityField;
    @FindBy(id = "card")
    WebElement cardField;
    @FindBy(id = "month")
    WebElement monthField;
    @FindBy(id = "year")
    WebElement yearField;
    @FindBy(xpath = "//button[text()='Purchase']")
    WebElement purchaseBtn;
    @FindBy(xpath = "//h2[text()='Thank you for your purchase!']")
    WebElement alert;

    public CartPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void pressOrderBtn()
    {
        orderBtn.click();
    }
    public void sendData(String username)
    {
        nameField.sendKeys(username);
        countryField.sendKeys("Egypt");
        cityField.sendKeys("Alex");
        cardField.sendKeys("123");
        monthField.sendKeys("10");
        yearField.sendKeys("2023");
        purchaseBtn.click();
    }
    public String alertMsg()
    {
        return alert.getText();
    }
}
