import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BaseClass;

public class LoginPageTest extends BaseClass {
    @Test
    public void login() throws InterruptedException {
        String username,password;
        username = excel[0][0];
        password = excel[0][1];
        loginPage = homePage.goToLoginPage();
        loginPage.logInSteps(username,password);
        Assert.assertEquals(loginPage.validateLogin(),"Welcome " + username);
    }

}
