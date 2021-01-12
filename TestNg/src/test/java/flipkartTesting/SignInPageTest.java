package flipkartTesting;

import flipkartPageObjModel.AccountDetailsFetchable;
import flipkartPageObjModel.SignInPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class SignInPageTest extends FlipkartCapabilities {
    @Test
    public void signin() throws IOException, InterruptedException {
        AndroidDriver<AndroidElement> driver = Capabilities();

        SignInPage signInPage = new SignInPage(driver);
        AccountDetailsFetchable resultPage = signInPage.signIn();
        Assert.assertEquals(resultPage.name(),"FlipkartHomePage");
        Assert.assertEquals( resultPage.getAccountName(), "ajiinkya ghorpade");
    }
}
