package shoppingSite;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Assert;
import pageobjectstoreapp.LoginPage;
import org.testng.annotations.Test;
import pageobjectstoreapp.ProductsPage;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AddToCartTest extends AppCapabilities {

    AndroidDriver<AndroidElement> setup() throws IOException {
        service = startServer(); //start the appium server
        AndroidDriver<AndroidElement> driver = Capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    @Test
    void test() throws IOException, InterruptedException {
        //server setup
        AndroidDriver<AndroidElement> driver = setup();

        // Given (setup) User has signed in and is on the products page
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser();

        // When (trigger) user adds product to cart
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.ProductAdd();

        // Then (expectation) the product gets added to the card
        int numberOfProductsInCart= productsPage.getNumberOfProductsInCart();
        Assert.assertEquals(1, numberOfProductsInCart);

        //productsPage.ViewCart();

        //server cleanup
        service.stop();
    }
}
