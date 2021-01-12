package flipkartPageObjModel;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pageobjectstoreapp.Utilities;

import java.io.IOException;

public class AddToCart {
    private final Utilities utilities;
    private final AppiumDriver driver;
    private String MobileName;

    public AddToCart(AppiumDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
        this.utilities = new Utilities((AndroidDriver<AndroidElement>) driver);
        this.driver = driver;
    }

    @AndroidFindBy(id = "com.flipkart.android:id/custom_back_icon")
    public WebElement Cancel;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Search on flipkart\"]/android.widget.TextView")
    public WebElement SearchBox;

    @AndroidFindBy(accessibility = "Search grocery products in Supermart")
    public WebElement SearchBox2;

    @AndroidFindBy(xpath ="//android.widget.TextView[@text='samsung mobiles']" )
    public WebElement SamsungMobiles;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Samsung Galaxy F41 (Fusion Green, 128 GB)']")
    public WebElement GalaxyF41;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='ADD TO CART']")
    public WebElement AddToCart;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='SKIP & GO TO CART']")
    public WebElement Skip;

    @AndroidFindBy(accessibility = "Back Button")
    public WebElement BackButton;

    @AndroidFindBy(id = "com.flipkart.android:id/cart_bg_icon")
    public WebElement CartButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[1]")
    public WebElement MobileInCart;






    public String AddToCartExecution() throws InterruptedException, IOException {

        welcomePageWithoutSignin();
        searchForAProduct();
        ProductAddToCart();
        String price=null;
        price = myCart();
        return price;

    }

    public void setScroll(){
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"1\").instance(0))"));
    }

    public void welcomePageWithoutSignin() throws InterruptedException {
        SignInPage signInPage = new SignInPage(driver);
        signInPage.EnglishButton.click();
        signInPage.SelectButton.click();
        Thread.sleep(5000);
        Cancel.click();
    }

    public void searchForAProduct() throws InterruptedException {
        SearchBox.click();
        SearchBox2.sendKeys("Samsung mobiles");
        SamsungMobiles.click();
        Thread.sleep(5000);

    }

    public void ProductAddToCart() throws InterruptedException {
        GalaxyF41.click();
        AddToCart.click();
        Thread.sleep(5000);
        Skip.click();
    }

    public String myCart(){
       String price= MobileInCart.getText().toString();
        return price;
    }






}
