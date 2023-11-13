import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseClassTest {

    @Test
    public void verifyHomePage()
    {
        Assert.assertTrue(homePage.validateHomePage());
    }
}
