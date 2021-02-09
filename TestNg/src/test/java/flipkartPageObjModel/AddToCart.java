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

import static io.appium.java_client.touch.offset.ElementOption.element;

public class AddToCart {
    private final Utilities utilities;
    private final AppiumDriver driver;
    private String MobileName;
    private WebElement element;

    public AddToCart(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.utilities = new Utilities((AndroidDriver<AndroidElement>) driver);
        this.driver = driver;
    }

    @AndroidFindBy(id = "com.flipkart.android:id/custom_back_icon")
    public WebElement Cancel;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Search on flipkart\"]/android.widget.TextView")
    public WebElement SearchBox;

    @AndroidFindBy(accessibility = "Search grocery products in Supermart")
    public WebElement SearchBox2;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='samsung mobiles']")
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

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")

    public WebElement upButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Samsung Guru 1200']")
    public WebElement guru;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='SKIP']")
    public WebElement skipGuru;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='GO TO CART']")
    public WebElement goToCart;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView[1]")
    public WebElement guru2;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='SKIP & GO TO CART']")
    public WebElement skipAndgo;


    public void AddToCartExecution() throws InterruptedException, IOException {

        welcomePageWithoutSignin();
        searchForAProduct();
        ProductAddToCart();

    }


    public void setScroll(String text) {
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + text + "\"))"));

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

    public String myCartValidationGalaxy() {
        String price = MobileInCart.getText().toString();
        return price;
    }

    public void AddAnotherProduct() throws InterruptedException {
        BackButton.click();
        setScroll("All Details");
        upButton.click();
        BackButton.click();
        Thread.sleep(5000);
        guru.click();
        AddToCart.click();
        Thread.sleep(5000);

        skipGuru.click();
       //skipAndgo.click();
       goToCart.click();
    }

    public String myCartValidationGuru() {
        String name = guru2.getText().toString();
        return name;
    }

    public long ProductValidation() throws InterruptedException {
        Thread.sleep(5000);
        long Price1=ProductOne();
        long Price2=ProductTwo();
        long predictedPrice =Price1+Price2;
        return predictedPrice;

    }
    public long actualPriceOfCart(){
        String actualPriceString =driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView[1]").getText().toString();
        long actualPrice=amountConvertToLong(actualPriceString);
        return actualPrice;
    }
    public long ProductOne() throws InterruptedException {
        Thread.sleep(5000);
        String amountInString1 = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.TextView[1]").getText().toString();
        long product1Price= amountConvertToLong(amountInString1);
        return product1Price;
    }

    public long ProductTwo() throws InterruptedException {
        Thread.sleep(5000);
        String amountInString2 = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.TextView[1]").getText().toString();
        long product2Price= amountConvertToLong(amountInString2);
        return product2Price;
    }


    public long amountConvertToLong(String price) {
        char[] amt = new char[price.length()];
        char[] amt1 = new char[price.length()];
        int j=0;
        for (int i = 0; i < price.length(); i++) {
            amt[i] = price.charAt(i);

        }
        for(int i=0;i<amt.length;i++){
            if (amt[i] != '₹' && amt[i] != ',') {
                amt1[j]=amt[i];
                j++;
            }

        }
        long amounttoLong=Long.parseLong(String.valueOf(amt1).trim());
        return amounttoLong;
    }
}



