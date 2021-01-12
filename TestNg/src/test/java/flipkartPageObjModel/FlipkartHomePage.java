package flipkartPageObjModel;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FlipkartHomePage implements AccountDetailsFetchable {
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='My Account']")
    public WebElement AccountButton;

    @AndroidFindBy(accessibility = "Drawer")
    public  WebElement Drawer;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='ajiinkya ghorpade']")
    public WebElement Authenticate;
    private AppiumDriver driver;

    public FlipkartHomePage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
        this.driver = driver;
    }

    @Override
    public String name() {
        return "FlipkartHomePage";
    }

    public String getAccountName(){
        Drawer.click();
        AccountButton.click();
        String name = Authenticate.getText().toString();
        return name;
    }
}
