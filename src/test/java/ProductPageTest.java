
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BaseClass;

public class ProductPageTest extends BaseClass {
    @Test(priority = 1)
    public void add_phone(){
        Phone = homePage.getPhone();
        Phone.clickAddToCartBtn();
        Assert.assertEquals(Phone.alertMsg(),"Product added.");
        totalPrice += Phone.getPrice();
        NumberOfProducts++;
        Phone.returnHome();
    }
    @Test(priority = 2)
    public void add_Laptop(){
        Laptop = homePage.getLaptop();
        Laptop.clickAddToCartBtn();
        Assert.assertEquals(Laptop.alertMsg(),"Product added.");
        totalPrice += Laptop.getPrice();
        NumberOfProducts++;
        Laptop.returnHome();
    }
    @Test(priority = 3)
    public void add_Monitor(){
        Monitor = homePage.getMonitor();
        Monitor.clickAddToCartBtn();
        Assert.assertEquals(Monitor.alertMsg(),"Product added.");
        totalPrice += Monitor.getPrice();
        NumberOfProducts++;
        Monitor.returnHome();
    }
}
