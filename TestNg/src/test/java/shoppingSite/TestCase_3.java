package shoppingSite;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageobjectstoreapp.Formpage;
import org.testng.annotations.Test;
import pageobjectstoreapp.ProductsPage;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestCase_3 extends main{
    @Test
    void test()throws IOException, InterruptedException {
        service=startServer(); //start the appium server
        AndroidDriver<AndroidElement> driver=Capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String text;

//        Add items to cart test

        Formpage f=new Formpage(driver);
        f.fillForm();

        ProductsPage p=new ProductsPage(driver);
        p.ProductAdd();


        service.stop();
    }
}
