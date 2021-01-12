package shoppingSite;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
//Store App testing
public class AppCapabilities {
    public static AppiumDriverLocalService service;
    private static ServerSocket serverSocket;

    //starts the appium server automatically
    public static AppiumDriverLocalService startServer()
    {
        boolean flag=checkIfServerIsRunning(4723);
        if(!flag) {
            service = AppiumDriverLocalService.buildDefaultService();
            service.start();
        }
        return service;
    }
    public static boolean checkIfServerIsRunning(int port){
        boolean isServerrunning =false;
        try{
            serverSocket=new ServerSocket(port);
            serverSocket.close();
        }catch(IOException e){
            isServerrunning=true;
        }finally {
            serverSocket=null;
        }
        return isServerrunning;
    }
    public static AndroidDriver<AndroidElement> Capabilities() throws IOException {

        FileInputStream fis=new FileInputStream("C:\\Users\\ajink\\IdeaProjects\\TestNg\\src\\test\\java\\shoppingSite\\global.properties");//path for global properties
        Properties prop=new Properties();
       // prop.load(fis);
        //prop.get("GeneralStoreApp");

        DesiredCapabilities cap=new DesiredCapabilities();

        String device=(String) prop.get("40827379");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME,device); //uses global.prop


            cap.setCapability(MobileCapabilityType.APP,"F:\\study\\appiumlearning\\androidapp\\General-Store.apk");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,14);
        AndroidDriver<AndroidElement> driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
        return driver;



    }
}
