package shoppingSite;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestCase_4 extends main{
    @Test // Ussing testng
    public void totalValidation() throws IOException, InterruptedException {
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

//        Amount validation test
//        Adding items to cart
      driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
      driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
      driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();


//Last page validation
        double sum=0;
        int count1=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
        for (int i=0;i<count1;i++){
            String text1= driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(i).getText();
            double dtext1=Amount(text1);
            sum=sum+dtext1;

        }

      System.out.println(sum);

      String text3=driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl").getText();
      text3=text3.substring(1);
      double dtext4=Double.parseDouble(text3);

      if (sum==dtext4){
          System.out.println("Passed");
      }
      else
      {
          System.out.println("Failed");
      }
    }
    public static double Amount(String value){
        value=value.substring(1);
        double dtext1=Double.parseDouble(value);
        return dtext1;
    }
}
