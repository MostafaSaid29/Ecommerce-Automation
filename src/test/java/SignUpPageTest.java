import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BaseClass;

public class SignUpPageTest extends BaseClass {

    @Test(dataProvider = "SignUpData")
    public void Signup(String username,String password){
        signUpPage = homePage.goToSignUpPage();
        signUpPage.signUpSteps(username,password);
        Assert.assertEquals(signUpPage.alertMsg(),"Sign up successful.");
    }
}
