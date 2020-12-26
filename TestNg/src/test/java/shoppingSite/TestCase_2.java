package shoppingSite;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.io.IOException;

public class TestCase_2 extends main {
    public static void main(String[] args) throws IOException {
        AndroidDriver<AndroidElement>driver=Capabilities();

        //Case for returning toast if name is not written test
       // driver.findElementByXPath("//android.widget.EditText[@text='Enter name here']").sendKeys("Rashi");
        //driver.hideKeyboard();

        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();

//            finds toast message id copies the toast message and then prints
        String toastMessage=driver.findElementByXPath("//android.widget.Toast[1]").getAttribute("name");
        System.out.println(toastMessage);




    }
}
