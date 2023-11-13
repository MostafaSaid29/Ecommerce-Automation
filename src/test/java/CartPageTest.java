import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartPageTest extends BaseClassTest {
    @Test
    public void purchase() throws InterruptedException {
        cartPage = homePage.goToCartPage();
        Thread.sleep(2000);
        cartPage.pressOrderBtn();
        Thread.sleep(2000);
        cartPage.sendData("Test");
        Thread.sleep(2000);
        Assert.assertEquals(cartPage.alertMsg(),"Thank you for your purchase!");
    }
}
