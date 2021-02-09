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
        addToCart.AddToCartExecution();
        name=addToCart.myCartValidationGalaxy();
        Assert.assertEquals("Deliver to ",name);
        addToCart.AddAnotherProduct();
        name=addToCart.myCartValidationGuru();
        Assert.assertEquals(name,"Samsung Guru 1200 ");
        long actualprice =addToCart.ProductValidation();
        long predictedPrice=addToCart.actualPriceOfCart();
       Assert.assertEquals(actualprice,predictedPrice);
    }



}
