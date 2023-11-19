package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.TestUtil;

import static util.TestUtil.explicitWait;


public class CartPage extends BaseClass {
    WebDriver driver;
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
    @FindBy(xpath = "//button[text()='Place Order']")
    WebElement orderBtn;
    @FindBy(xpath = "//h3[@id='totalp']")
    WebElement totalPrice;
    public CartPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void pressOrderBtn()
    {
        try{
            explicitWait(driver,orderBtn);
            orderBtn.click();
        }catch (Exception e)
        {
            System.out.println("Couldn't find Place Order Button");
        }
    }
    public void sendData(String username)
    {
        TestUtil.sendKeys(driver,nameField,username);
        TestUtil.sendKeys(driver,countryField,"Egypt");
        TestUtil.sendKeys(driver,cityField,"Alex");
        TestUtil.sendKeys(driver,cardField,"123");
        TestUtil.sendKeys(driver,monthField,"10");
        TestUtil.sendKeys(driver,yearField,"2023");
        explicitWait(driver,purchaseBtn);
        purchaseBtn.click();
    }
    public int getTotalPrice()
    {
        explicitWait(driver,totalPrice);
        return Integer.parseInt(totalPrice.getText());
    }
    public String alertMsg()
    {
        return alert.getText().trim();
    }
}
