package apiDemos;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import org.openqa.selenium.WebElement;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class Gestures extends Basic {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        AndroidDriver<AndroidElement> driver=Capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        driver.findElementByAndroidUIAutomator("text(\"OK\")").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();

        /*Gestures used for tapping just like clicking Gestures have different options like long press */
        //tap
        TouchAction t=new TouchAction(driver);//used for tapping just like click

//Simple Tap
        WebElement expandlist =driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']");//fetch address
        t.tap(TapOptions.tapOptions().withElement(element(expandlist))).perform();//perform tap operation

//        Simple Tap
        WebElement expandlist1 =driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']");
        t.tap(TapOptions.tapOptions().withElement(element(expandlist1))).perform();

//      Long Press for 2 sec and release
        WebElement expandlist2 =driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
        t.longPress(LongPressOptions.longPressOptions().withElement(element(expandlist2)).withDuration(Duration.ofSeconds(2))).release().perform();
        Thread.sleep(2000);

//        returns true if displayed
        System.out.println(driver.findElementById("android:id/title").isDisplayed());

        driver.findElementByClassName("android.widget.LinearLayout").click();









    }
}
