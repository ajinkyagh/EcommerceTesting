package apiDemos;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class Uiautomatortest extends Basic{
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        AndroidDriver<AndroidElement> driver= Capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElementByAndroidUIAutomator("text(\"OK\")").click();


//        findElementByAndroidUIAutomator used to find ids from app
//    Syntax    driver.findElementByAndroidUIAutomator("attribute("value")");
        driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
        Thread.sleep(3000);
        driver.findElementByAndroidUIAutomator("text(\"Animation\")").click();

//        Validate clickable feature for all options
//        driver.findElementsByAndroidUIAutomator("new UiSelector().property(value)");
        System.out.println(driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size());//Gives total for clickable=true
    }
}
