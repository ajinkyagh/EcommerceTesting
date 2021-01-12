package pageobjectstoreapp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsPage {
    private final Utilities utilities;
    private final AndroidDriver<AndroidElement> driver;
    String text;

    public ProductsPage(AndroidDriver<AndroidElement> driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
        this.utilities = new Utilities(driver);
        this.driver = driver;
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productName")
    public List<WebElement> ProductName;


    @AndroidFindBy(id="com.androidsample.generalstore:id/productAddCart")
    public List<WebElement> AddToCartClk;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
    public WebElement FinalCart;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productName")
    public WebElement LastText;



    public void ProductAdd() throws InterruptedException {
      //        Actual Test Case
//        Scrolling to a specific item more precisely uses different syntax
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))"));
        Thread.sleep(5000);

//        Click Add To cart button test

        int count =ProductName.size();
        //driver.findElementsById("com.androidsample.generalstore:id/productName").size();//Returns size based on total products on the screen not all
       // System.out.println(count);

        for(int i=0;i<count;i++){
            text=ProductName.get(i).getText();
            //driver.findElementsById("com.androidsample.generalstore:id/productName").get(i).getText() ;

            if (text.equalsIgnoreCase("Jordan 6 Rings")){
                AddToCartClk.get(i).click();
                //driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(i).click();
                break;
            }
        }


    }

    public int getNumberOfProductsInCart() {
        String txtcounter= driver.findElementById("com.androidsample.generalstore:id/counterText").getText();
        System.out.println(txtcounter);
        return Integer.parseInt(txtcounter);
    }

    public  void ViewCart() throws InterruptedException {
         FinalCart.click();
        //driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
        /*Thread.sleep(5000);

//       Validation of the items selected on page2 with page3
        String lastpagetext=LastText.getText();
        //driver.findElementById("com.androidsample.generalstore:id/productName").getText();

        if (lastpagetext.equals("Jordan 6 Rings")) {
            //System.out.println("Case Passed");
        }*/
    }
}
