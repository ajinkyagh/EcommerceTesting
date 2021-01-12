package flipkartPageObjModel;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.io.IOException;

import static java.lang.Runtime.getRuntime;

public class FlipkartUtilities {
    AndroidDriver<AndroidElement> driver;
    public FlipkartUtilities(AndroidDriver <AndroidElement> driver){
        this.driver=driver;
    }
    public static void EnterPhoneNumber(String number, String DeviceName) throws IOException, InterruptedException {
        getRuntime().exec("adb -s "+DeviceName+" shell input text "+ number).waitFor();

    }
}
