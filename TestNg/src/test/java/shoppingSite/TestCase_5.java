package shoppingSite;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import org.openqa.selenium.WebElement;
import pageobjectstoreapp.CartPage;
import pageobjectstoreapp.Formpage;
import pageobjectstoreapp.ProductsPage;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.offset.ElementOption.element;

public class TestCase_5 extends main{
    @Test
   public void val() throws IOException, InterruptedException {
        service=startServer();
        AndroidDriver<AndroidElement> driver=Capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String text;


        CartPage pg = new CartPage(driver);
        Formpage f = new Formpage(driver);
        ProductsPage p = new ProductsPage(driver);

        f.fillForm();
        pg.ProductValidation();
        pg.FinalTest();



        service.stop();







    }
}
