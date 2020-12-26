package apiDemos;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pageobjectsapidemos.HomePage;
import pageobjectsapidemos.PreferencePage;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class Basics extends Basic{
    @Test
    public void validation() throws MalformedURLException , InterruptedException {

        AndroidDriver<AndroidElement> driver = Capabilities();

        HomePage h=new HomePage(driver);//Creating object for home page (page object model)
        PreferencePage p=new PreferencePage(driver);

//        Finding ids using different functions
        driver.findElementById("android:id/button1").click();//click OK
        Thread.sleep(5000);
       // driver.findElementByAccessibilityId("Preference").click(); //Click Preference
        h.Preferences.click();//Uses page factory model insted of the above code
        // Preferences coded in homepage class.

        Thread.sleep(5000);
        //driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        //driver.findElementByXPath("//android.widget.Button[@text='NEXT PAGE']").click();

        //driver.findElementByAccessibilityId("3. Preference dependencies").click(); //Click pref depend
        p.prefdependies.click();//again using page object model

        Thread.sleep(5000);
        driver.findElementById("android:id/checkbox").click();//click checkbox
        Thread.sleep(5000);
        driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click(); //Clickwifi settings.
        Thread.sleep(5000);
        driver.findElementByClassName("android.widget.EditText").sendKeys("Hello");
        Thread.sleep(3000);
        //driver.findElementById("android:id/button1").click();
        Thread.sleep(3000);
        driver.findElementsByClassName("android.widget.Button").get(1).click();




    }



}
