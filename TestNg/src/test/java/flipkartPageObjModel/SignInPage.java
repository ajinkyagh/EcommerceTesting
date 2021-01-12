package flipkartPageObjModel;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pageobjectstoreapp.Utilities;

import java.io.IOException;

public class SignInPage implements AccountDetailsFetchable {
    private final Utilities utilities;
    private final AppiumDriver driver;

    public SignInPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.utilities = new Utilities((AndroidDriver<AndroidElement>) driver);
        this.driver = driver;
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='English']")
    public WebElement EnglishButton;

    @AndroidFindBy(id = "com.flipkart.android:id/select_btn")
    public WebElement SelectButton;

    @AndroidFindBy(id = "com.flipkart.android:id/bottom_bar_container")
    public WebElement OtpButton;

    public AccountDetailsFetchable signIn() throws IOException, InterruptedException {
        if (welcomePageWithLogin()) {
            return new FlipkartHomePage(driver);
        } else {
            return this;
        }
    }

    public boolean welcomePageWithLogin() throws InterruptedException, IOException {
        EnglishButton.click();
        SelectButton.click();
        Thread.sleep(5000);
        FlipkartUtilities.EnterPhoneNumber("9552864146", "40827379");
        OtpButton.click();
        //Password.sendKeys("notebook");
        //Continue.click();
        Thread.sleep(5000);
        return loginSuccessful();
    }

    private boolean loginSuccessful() {
        try {
            return driver.findElementByAccessibilityId("Drawer").isDisplayed();
        } catch (Throwable e) {
            return false;
        }
    }

    @Override
    public String name() {
        return "LoginPage";
    }

    @Override
    public String getAccountName() {
        return "";
    }
}
