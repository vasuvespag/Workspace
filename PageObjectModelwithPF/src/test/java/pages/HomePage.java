package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
 
public class HomePage {
 
WebDriver driver;
// Constructor
// Gets called when object of this page is created in MainClass.java
public HomePage(WebDriver driver)
{
    // "this" keyword is used here to distinguish global and local variable "driver"
    //gets driver as parameter from MainClass.java and assigns to the driver instance in this class 

    this.driver=driver;

    PageFactory.initElements(driver,this); 
//Initialises WebElements declared in this class using driver instance.
         
}
         
    // Locator for Email Address
//@FindBy(how=How.XPATH,using=".//*[@id='username']")
 //private WebElement Username;
 
    // Locator for Password field
//@FindBy(how=How.ID,using="password ")
// private WebElement Password;
 
    // Locator for SignIn Button
//@FindBy(how=How.ID,using="login")
 //private WebElement SignInButton;

@FindBy(how=How.XPATH, using=".//*[@id='username']") WebElement Username;
@FindBy(how=How.ID, using="password") WebElement Password;
@FindBy(how=How.ID, using="login") WebElement SignInButton;
 
    // Method to type EmailId
    public void typeEmailId(String username){
        Username.sendKeys(username);
    }
 
    // Method to type Password
    public void typePassword(String PasswordValue){
        Password.sendKeys(PasswordValue);
    }
 
    // Method to click SignIn Button
    public void clickSignIn(){
        SignInButton.click();
    }
 


	
}