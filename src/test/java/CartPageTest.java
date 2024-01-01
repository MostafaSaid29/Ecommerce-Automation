import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BaseClass;

public class CartPageTest extends BaseClass {
   @Test
   public void validProducts()
   {
       cartPage = homePage.goToCartPage();
       Assert.assertEquals(cartPage.getProducts(),NumberOfProducts);
   }
    @Test(priority = 2)
    public void validTotalPrice(){

        Assert.assertEquals(cartPage.getTotalPrice(),totalPrice);
    }
    @Test(priority = 3)
    public void purchase()  {
        cartPage.pressOrderBtn();
        cartPage.sendData("Test");
        Assert.assertEquals(cartPage.alertMsg(),"Thank you for your purchase!");
    }
}
