package pages;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static util.TestUtil.explicitWait;
import static util.TestUtil.handleAlert;

public class ProductPage {
    WebDriver driver;
    @FindBy(partialLinkText = "Add to cart")
    WebElement addToCart;
    @FindBy(partialLinkText = "Home")
    WebElement Home;
    @FindBy(xpath = "//h3[@class='price-container']")
    WebElement priceElement;
    public ProductPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public int getPrice()
    {
        String priceText = priceElement.getText().split("\\*")[0].trim();
        String price = priceText.replace("$","");
        return Integer.parseInt(price);
    }
    public void clickAddToCartBtn()
    {
        try{
            explicitWait(driver,addToCart);
            addToCart.click();
        }catch (Exception e){
            System.out.println("Couldn't find Add to Cart Button");
        }

    }
    public void returnHome()
    {
        Home.click();
    }
    public String alertMsg()
    {
        return handleAlert(driver);
    }
}
