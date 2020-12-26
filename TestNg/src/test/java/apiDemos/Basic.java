package apiDemos;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
//Testing using api demos
public class Basic {
    public static AndroidDriver<AndroidElement> driver;
    public static AndroidDriver<AndroidElement>  Capabilities() throws MalformedURLException{
        // TODO Auto-generated method stub
        File f=new File("src");
        File fs=new File("ApiDemos-debug.apk");
        DesiredCapabilities cap=new DesiredCapabilities(); //Basic info like device name on which the test will run ,connection to server ,
        //defining name of app along with its location in jason format
        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"40827379 ");
        //cap.setCapability(MobileCapabilityType.APP,"D:\\study\\appiumlearning\\androidapp\\test2.apk");
        cap.setCapability(MobileCapabilityType.APP,"D:\\study\\appiumlearning\\androidapp\\ApiDemos-debug.apk");//Best way to get path for app
        //capabilities.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");//To access uiautomator framework
        AndroidDriver<AndroidElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);//To automate test using android
        return driver;
    }

//    Taking screenshots and sending to listeners.java
    public  static void getScreenshot(String s) throws IOException {
      File scrfile= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrfile,new File(System.getProperty("D:\\defectscreen.png")));
    }
}
