package pageobjectstoreapp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
    private final Utilities utilities;
    private final AndroidDriver<AndroidElement> driver;
    String text;

    public ProductsPage(AndroidDriver<AndroidElement> driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
        this.utilities = new Utilities(driver);
        this.driver = driver;
    }



    public void ProductAdd() throws InterruptedException {
      //        Actual Test Case
//        Scrolling to a specific item more precisely uses different syntax
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))"));
        Thread.sleep(5000);

//        Click Add To cart button test

        int count =driver.findElementsById("com.androidsample.generalstore:id/productName").size();//Returns size based on total products on the screen not all
        System.out.println(count);

        for(int i=0;i<count;i++){
            text=driver.findElementsById("com.androidsample.generalstore:id/productName").get(i).getText() ;
            if (text.equalsIgnoreCase("Jordan 6 Rings")){
                driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(i).click();
                break;
            }
        }
        driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
        Thread.sleep(5000);

//       Validation of the items selected on page2 with page3
        String lastpagetext=driver.findElementById("com.androidsample.generalstore:id/productName").getText();

        if (lastpagetext.equals("Jordan 6 Rings")) {
            System.out.println("Case Passed");
        }

    }
}
