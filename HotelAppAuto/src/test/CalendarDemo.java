package test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarDemo {

 public static void main(String[] args) throws InterruptedException {
  // TODO Auto-generated method stub
  
  System.setProperty("webdriver.chrome.driver", "D:\\Vasu\\Vasu\\Vasu\\drivers\\ChromeDriver\\chromedriver.exe");
  WebDriver driver = new ChromeDriver();
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  driver.get("https://www.makemytrip.com/");
  String actualTitle=" ";
  actualTitle=driver.getTitle();
  String url=driver.getCurrentUrl();
  System.out.println(url);
  String expectedTitle=actualTitle;
  if(actualTitle.contentEquals(expectedTitle)){
      System.out.println("Test pass");
  }
  else{
      System.out.println("Test fail");
  }
  
  driver.findElement(By.xpath("//*[@id=\'SW\']/div[1]/div[1]/ul/li[3]/div[3]/p")).click();
  WebElement roundtrip=driver.findElement(By.xpath(".//label[@class='label_text flight-trip-type']"));
  roundtrip.click();
  System.out.println("Select one way option");
  WebElement we = driver.findElement(By.xpath(".//div/section/div/div/input[@id='hp-widget__sfrom']"));
  we.clear();
  Thread.sleep(3000);
  we.sendKeys("hyde");
  Thread.sleep(3000);
  we.sendKeys(Keys.RETURN);

  }
    
 }


