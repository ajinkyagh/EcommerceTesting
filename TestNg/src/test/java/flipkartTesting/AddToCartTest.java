package flipkartTesting;

import flipkartPageObjModel.AddToCart;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddToCartTest extends FlipkartCapabilities {
    @Test
    public void addToCart() throws IOException, InterruptedException {
        AndroidDriver<AndroidElement> driver =Capabilities();
        AddToCart addToCart=new AddToCart(driver);
        String name=null;
        name=addToCart.AddToCartExecution();
        Assert.assertEquals("Deliver to ",name);
    }

}
