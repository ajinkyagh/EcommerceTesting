package pageobjectstoreapp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class Formpage {
    private final Utilities utilities;
    private final AppiumDriver driver;

    public Formpage(AppiumDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
        this.utilities = new Utilities((AndroidDriver<AndroidElement>) driver);
        this.driver = driver;
    }


    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter name here']")
    public WebElement editext;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[2]")
    public WebElement radiobutton;

    @AndroidFindBy(id="android:id/text1")
    public WebElement clickcountry;

    @AndroidFindBy(xpath ="//*[@text='Barbados']" )
    public WebElement selcountry;

    @AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop" )
    public WebElement button;


    public void fillForm() throws InterruptedException {
//      Filling form details test
//      Name Test
        //driver.findElementByXPath("//android.widget.EditText[@text='Enter name here']").sendKeys("Rashi");
//        Using page object model
        editext.sendKeys("ajinkya");

        driver.hideKeyboard();

//      Male-Female Test
        //driver.findElementByXPath("//android.widget.RadioButton[2]").click();
//        using pageobject model
        radiobutton.click();
        Thread.sleep(5000);
        //Select Country
        // driver.findElementById("android:id/text1").click();
        //using page object model
        clickcountry.click();

        //driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Barbados\"));");
        utilities.scrollToText("Barbados");

        // driver.findElementByXPath("//*[@text='Barbados']").click();
        //f.selcountry.click();
        utilities.clickByXpath("//*[@text='Barbados']");

        //Button Click Lets Shop
        // driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
        button.click();
        Thread.sleep(5000);
    }
}

