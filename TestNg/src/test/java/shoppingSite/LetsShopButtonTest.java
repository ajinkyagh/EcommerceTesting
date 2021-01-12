package shoppingSite;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.Test;
import pageobjectstoreapp.LoginPage;

import java.io.IOException;

public class LetsShopButtonTest extends AppCapabilities {
    @Test
   public void clickButtonLetsShop () throws IOException {
        service=startServer();
        AndroidDriver<AndroidElement>driver=Capabilities();

        LoginPage loginPage=new LoginPage(driver);


        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
        //loginPage.letsShopClick();

//            finds toast message id copies the toast message and then prints
        String toastMessage=driver.findElementByXPath("//android.widget.Toast[1]").getAttribute("name");
        //System.out.println(toastMessage);
        service.stop();

    }
}
