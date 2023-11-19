import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BaseClass;

public class HomePageTest extends BaseClass {

    @Test
    public void verifyHomePage()
    {
        Assert.assertTrue(homePage.validateHomePage());
    }
}
