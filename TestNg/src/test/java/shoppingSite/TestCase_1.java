package shoppingSite;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjectsapidemos.PreferencePage;
import pageobjectstoreapp.Formpage;
import pageobjectstoreapp.Utilities;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestCase_1 extends main{
    @Test
    public void validation() throws IOException, InterruptedException {
        service=startServer(); //start the appium server
        AndroidDriver<AndroidElement> driver =Capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Formpage f=new Formpage(driver); //initializing page object model
        f.fillForm();
        service.stop();//stops appium server


    }



}
