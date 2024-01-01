package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static util.TestUtil.explicitWait;
import static util.TestUtil.handleAlert;

public class ProductPage {
    WebDriver driver;
    By addCartLocator = By.partialLinkText("Add to cart");
    By homeLocator = By.partialLinkText("Home");
    By priceLocator = By.xpath("//h3[@class='price-container']");
    public ProductPage(WebDriver driver)
    {
        this.driver = driver;
    }
    public int getPrice()
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        WebElement priceEle = wait.until(ExpectedConditions.elementToBeClickable(priceLocator));
        String priceText = priceEle.getText().split("\\*")[0].trim();
        String price = priceText.replace("$","");
        return Integer.parseInt(price);
    }
    public void clickAddToCartBtn()
    {
        try{
            WebElement add2CartBtn = explicitWait(driver,addCartLocator);
            add2CartBtn.click();
        }catch (Exception e){
            System.out.println("Couldn't find Add to Cart Button");
        }

    }
    public void returnHome()
    {
        WebElement Home = explicitWait(driver,homeLocator);
        Home.click();
    }
    public String alertMsg()
    {
        return handleAlert(driver);
    }
}