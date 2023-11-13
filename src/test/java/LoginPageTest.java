import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.TestUtil;

import java.io.IOException;

public class LoginPageTest extends BaseClassTest {

    @Test(dataProvider = "LoginData")
    public void login(String username,String password) throws InterruptedException {
        loginPage = homePage.goToLoginPage();
        loginPage.logInSteps(username,password);
        Thread.sleep(2000);
        Assert.assertEquals(loginPage.validateLogin(),"Welcome " + username);
    }

}
