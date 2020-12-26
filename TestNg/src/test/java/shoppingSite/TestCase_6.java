package shoppingSite;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.offset.ElementOption.element;

public class TestCase_6 extends main {
    public static void main(String[] args) throws IOException, InterruptedException {
        AndroidDriver<AndroidElement> driver=Capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String text;

//        Add items to cart test

        driver.findElementByXPath("//android.widget.EditText[@text='Enter name here']").sendKeys("Rashi");
        driver.hideKeyboard();
//      Male-Female Test
        driver.findElementByXPath("//android.widget.RadioButton[2]").click();
        Thread.sleep(5000);
        //Select Country
        driver.findElementById("android:id/text1").click();
        driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Barbados\"));");
        driver.findElementByXPath("//*[@text='Barbados']").click();
        //Button Click Lets Shop
        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
        Thread.sleep(5000);


//        Adding items to cart
        driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
        driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
        driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();


        TouchAction t=new TouchAction(driver);
//        Tap on check box
        WebElement expandlist2 =driver.findElementByXPath("//android.widget.CheckBox[@text='Send me e-mails on discounts related to selected products in future']");
        t.tap(TapOptions.tapOptions().withElement(element(expandlist2))).perform();

        //        Long press on last page  terms and condn
        WebElement expandlist1 =driver.findElementByXPath("//android.widget.TextView[@text='Please read our terms of conditions']");
        t.longPress(LongPressOptions.longPressOptions().withElement(element(expandlist1)).withDuration(Duration.ofSeconds(2))).release().perform();
        driver.findElementById("android:id/button1").click();
        driver.findElementById("com.androidsample.generalstore:id/btnProceed").click();
        Thread.sleep(5000);


//        Nativeapp to web view test
      Set<String>contexts=driver.getContextHandles();
      for (String contextName:contexts)
           System.out.println(contextName);//Prints out something like nativeapp or webview

     driver.context("WEBVIEW_com.androidsample.generalstore");//Switch form native to webview
        //driver.findElement(By.name("q")).sendKeys("hello");
        driver.findElementsByClassName("gLFyf gsfi");






    }
}
