package shoppingSite;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.Test;
import pageobjectstoreapp.LoginPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LoginTest extends AppCapabilities {
    @Test
    public void doLoginTest() throws IOException, InterruptedException {
        service=startServer(); //start the appium server
        AndroidDriver<AndroidElement> driver =Capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        LoginPage loginPage = new LoginPage(driver); //initializing page object model
        loginPage.loginUser();
        service.stop();//stops appium server
    }
}
