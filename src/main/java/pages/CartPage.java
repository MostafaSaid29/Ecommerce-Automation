package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.TestUtil;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static util.TestUtil.*;


public class CartPage extends BaseClass {
    WebDriver driver;
    By tableLocator = By.id("tbodyid");
    By childLocator = By.xpath("//tbody[@id= \"tbodyid\"]/tr");
    By nameLocator = By.id("name");
    By countryLocator = By.id("country");
    By cityLocator = By.id("city");
    By cardLocator = By.id("card");
    By monthLocator = By.id("month");
    By yearLocator = By.id("year");
    By purchaseBtnLocator = By.xpath("//button[text()='Purchase']");
    By alertLocator = By.xpath("//h2[text()='Thank you for your purchase!']");
    By orderBtnLocator = By.xpath("//button[text()='Place Order']");
    By totalPriceLocator = By.xpath("//h3[@id='totalp']");
    public CartPage(WebDriver driver)
    {
        this.driver = driver;
    }
    public void pressOrderBtn()
    {
        try{
            WebElement orderBtn = explicitWait(driver,orderBtnLocator);
            orderBtn.click();
        }catch (Exception e)
        {
            System.out.println("Couldn't find Place Order Button");
        }
    }
    public void sendData(String username)
    {
        sendKeys(driver,nameLocator,username);
        sendKeys(driver,countryLocator,"Egypt");
        sendKeys(driver,cityLocator,"Alex");
        sendKeys(driver,cardLocator,"123");
        sendKeys(driver,monthLocator,"10");
        sendKeys(driver,yearLocator,"2023");
        WebElement purchaseBtn = explicitWait(driver,purchaseBtnLocator);
        purchaseBtn.click();
    }
    public int getTotalPrice()
    {
        WebElement totalPrice = explicitWait(driver,totalPriceLocator);
        return Integer.parseInt(totalPrice.getText());
    }
    public int getProducts(){
        //WebElement table = explicitWait(driver,tableLocator);
        List<String> childName = new ArrayList<>();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(childLocator));
        List<WebElement> child = driver.findElements(childLocator);
        return child.size();
        /*
        System.out.println(child.size());
        for(int i = 1 ; i < child.size()+1; i++)
        {
            System.out.println(i);
            WebElement x = driver.findElement(By.xpath("(//tbody[@id= \"tbodyid\"]/tr/td[2])["+i+"]"));
            childName.add(x.getText());
        }
        System.out.println(childName);*/
    }
    public String alertMsg()
    {
        WebElement alert = explicitWait(driver,alertLocator);
        return alert.getText().trim();
    }
}