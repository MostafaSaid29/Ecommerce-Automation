import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BaseClass;

public class CartPageTest extends BaseClass {
    @Test(priority = 1)
    public void validTotalPrice()
    {
        cartPage = homePage.goToCartPage();
        Assert.assertEquals(cartPage.getTotalPrice(),totalPrice);
    }
    @Test(priority = 2)
    public void purchase()  {
        cartPage.pressOrderBtn();
        cartPage.sendData("Test");
        Assert.assertEquals(cartPage.alertMsg(),"Thank you for your purchase!");
    }
}
