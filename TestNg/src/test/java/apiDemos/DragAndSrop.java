package apiDemos;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import org.openqa.selenium.WebElement;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.offset.ElementOption.element;

public class DragAndSrop extends Basic {
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver=Capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElementByAndroidUIAutomator("text(\"OK\")").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();

        driver.findElementByAccessibilityId("Drag and Drop").click();

        TouchAction t=new TouchAction(driver);
        WebElement first= driver.findElementById("io.appium.android.apis:id/drag_dot_1");
        WebElement second=driver.findElementById("io.appium.android.apis:id/drag_dot_3");

        //Drag and Drop
        t.longPress(LongPressOptions.longPressOptions().withElement(element(first)).withDuration(Duration.ofSeconds(2))).moveTo(element(second)).release().perform();


    }
}
