package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    WebDriver driver;
    @FindBy(partialLinkText = "Add to cart")
    WebElement addToCart;
    @FindBy(partialLinkText = "Home")
    WebElement Home;
    public ProductPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void clickAddToCartBtn()
    {
        addToCart.click();
    }
    public void returnHome()
    {
        Home.click();
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
