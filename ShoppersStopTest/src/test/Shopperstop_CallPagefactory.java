package test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class shopperstopPagefactory {
     WebDriver driver;
    @FindBy(id="firstVisit")
     
    WebElement extrapopup;
     
    @FindBy(xpath="//img[@src='https://sslimages.shoppersstop.com
/sys-master/root/haf/h3a/9519787376670/brandMedia_HauteCurry_logo.png']")
     
    WebElement HCLink;
     
    @FindBy(xpath="/html/body/main/footer/div[1]/p")
     
    WebElement Startnew;
     
    public  shopperstopPagefactory(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
         
    }
     
    public  void closeExtraPopup() {
        extrapopup.click();
    }
     
    public  void clickOnHauteCurryLink() {
        JavascriptExecutor js = (JavascriptExecutor) driver;  
        js.executeScript("arguments[0].click();",HCLink);
        js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 10000);");
        if(driver.getCurrentUrl().equals("https://www.shoppersstop.com/haute-curry")) {
            System.out.println("We are on the Haute Curry page");
        }
        else {
            System.out.println("We are NOT on the Haute Curry page");   
    }
}
public  void verifyStartNewSomething() {
    if (Startnew.getText().equalsIgnoreCase("Start Something New")) {
        System.out.println("Start new something text exists");
    } else
        System.out.println("Start new something text DOESNOT exists");
}
}