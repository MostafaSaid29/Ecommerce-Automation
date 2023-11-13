import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpPageTest extends BaseClassTest {

    @Test(dataProvider = "LoginData")
    public void Signup(String username,String password) throws InterruptedException {

        signUpPage = homePage.goToSignUpPage();
        signUpPage.signUpSteps(username,password);
        Thread.sleep(2000);
        Assert.assertEquals(signUpPage.alertMsg(),"Sign up successful.");
        Thread.sleep(2000);
        signUpPage.acceptAlert();
    }
}
