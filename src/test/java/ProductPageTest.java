
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

public class ProductPageTest extends BaseClassTest {
    @BeforeMethod
    public void set()
    {
        initialization();
    }

    @Test(priority = 1)
    public void add_phone() throws InterruptedException {
        Thread.sleep(2000);
        Phone = homePage.getPhone();
        Phone.clickAddToCartBtn();
        Thread.sleep(2000);
        Assert.assertEquals(Phone.alertMsg(),"Product added.");
        Phone.acceptAlert();
        Phone.returnHome();
    }
    @Test(priority = 2)
    public void add_Laptop() throws InterruptedException {
        Thread.sleep(2000);
        Laptop = homePage.getLaptop();
        Laptop.clickAddToCartBtn();
        Thread.sleep(2000);
        Assert.assertEquals(Laptop.alertMsg(),"Product added.");
        Laptop.acceptAlert();
        Laptop.returnHome();
    }
    @Test(priority = 3)
    public void add_Monitor() throws InterruptedException {
        Thread.sleep(2000);
        Monitor = homePage.getMonitor();
        Monitor.clickAddToCartBtn();
        Thread.sleep(2000);
        Assert.assertEquals(Monitor.alertMsg(),"Product added.");
        Monitor.acceptAlert();
        Monitor.returnHome();
    }
}
