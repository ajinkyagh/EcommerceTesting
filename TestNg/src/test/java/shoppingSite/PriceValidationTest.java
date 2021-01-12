package shoppingSite;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjectstoreapp.CartPage;
import pageobjectstoreapp.LoginPage;
import pageobjectstoreapp.ProductsPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class PriceValidationTest extends AppCapabilities {
    @Test // Ussing testng
    public void totalValidation() throws IOException, InterruptedException {
        service=startServer();
        AndroidDriver<AndroidElement> driver = Capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String text;

//        Given
        LoginPage loginPage= new LoginPage(driver);
        loginPage.loginUser();

//        When
        CartPage cartPage = new CartPage(driver);
        double total=cartPage.ProductValidation();

//        Then

        Assert.assertEquals(280.97,total);


        service.stop();


    }
}
