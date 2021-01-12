package pageobjectstoreapp;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;
import java.time.Duration;
import java.util.List;

import static io.appium.java_client.touch.offset.ElementOption.element;

public class CartPage {
    private final Utilities utilities;
    private final AndroidDriver<AndroidElement> driver;


    public CartPage(AndroidDriver<AndroidElement> driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
        this.utilities = new Utilities(driver);
        this.driver = driver;
    }

    @AndroidFindBy(xpath="//*[@text='ADD TO CART']")
    public List<WebElement> AddToCart;

    @AndroidFindBy (id = "com.androidsample.generalstore:id/appbar_btn_cart")
    public WebElement AddToCartClk;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
    public List<WebElement> ProductPrice;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
    public WebElement AmountLabel;

    @AndroidFindBy(xpath = "//android.widget.CheckBox[@text='Send me e-mails on discounts related to selected products in future']")
    public WebElement CheckBox;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Please read our terms of conditions']")
    public WebElement TermsAndConditions;

    @AndroidFindBy(id = "android:id/button1")
    public WebElement CloseButton;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
    public WebElement ProceedButton;



    public double ProductValidation(){
        //        Amount validation test
//        Adding items to cart
       AddToCart.get(0).click();
        AddToCart.get(0).click();
        AddToCartClk.click();

        //driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
        //driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();

      /*  driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();*/


//Last page validation
        double sum=0;
        int count1=ProductPrice.size();//driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
        for (int i=0;i<count1;i++){
            String text1=ProductPrice.get(i).getText(); //driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(i).getText();
            double dtext1=Amount(text1);
            sum=sum+dtext1;
        }

        System.out.println(sum);

        String text3=AmountLabel.getText();//driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl").getText();
        text3=text3.substring(1);
        double dtext4=Double.parseDouble(text3);

        /*if (sum==dtext4){
            System.out.println("Passed");
        }
        else
        {
            System.out.println("Failed");
        }*/
        return sum;
    }

    public static double Amount(String value){
        value=value.substring(1);
        double dtext1=Double.parseDouble(value);
        return dtext1;
    }

    public void FinalTest() throws InterruptedException {
        //Final test

        TouchAction t=new TouchAction(driver);
//        Tap on check box
        WebElement expandlist2 =CheckBox;//driver.findElementByXPath("//android.widget.CheckBox[@text='Send me e-mails on discounts related to selected products in future']");
        t.tap(TapOptions.tapOptions().withElement(element(expandlist2))).perform();

        //        Long press on last page  terms and condn
        WebElement expandlist1 =TermsAndConditions;//driver.findElementByXPath("//android.widget.TextView[@text='Please read our terms of conditions']");
        t.longPress(LongPressOptions.longPressOptions().withElement(element(expandlist1)).withDuration(Duration.ofSeconds(2))).release().perform();//terms and condn
        Thread.sleep(5000);
        CloseButton.click();//driver.findElementById("android:id/button1").click();//close button
        Thread.sleep(5000);
        ProceedButton.click();//driver.findElementById("com.androidsample.generalstore:id/btnProceed").click();//Goes to webview
        Thread.sleep(5000);

    }
    }

