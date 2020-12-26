package apiDemos;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjectsapidemos.HomePage;
import pageobjectsapidemos.PreferencePage;

import java.net.MalformedURLException;

public class BasicsOne extends Basic{
    @Test(dataProvider = "InputData",dataProviderClass = TestData.class)//takes data from testdata class
    public void validation(String input) throws MalformedURLException , InterruptedException {

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
        driver.findElementByClassName("android.widget.EditText").sendKeys(input);//input coming from testdata class
        Thread.sleep(3000);
        //driver.findElementById("android:id/button1").click();
        Thread.sleep(3000);
        driver.findElementsByClassName("android.widget.Button").get(1).click();




    }






}
