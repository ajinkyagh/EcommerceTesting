package pageobjectstoreapp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
//Used for avoiding duplication of code
public class Utilities {
    AndroidDriver <AndroidElement> driver;
    public Utilities(AndroidDriver <AndroidElement> driver){
        this.driver=driver;
    }

    public void scrollToText(String text){
        driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));");
    }

    public void clickByXpath(String text){
        driver.findElementByXPath(text).click();
    } //not working neatly

}
