package locators;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import browser.Browser;

public class Locators extends Browser {
	
	//Find the Search box to enter the search keys
	public static WebElement findSearch() throws Exception{
		WebElement element = null;
		try {
			element = driver.findElement(By.id("twotabsearchtextbox"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	
	//Find the search icon to proceed the search
	public static WebElement clickSearch() throws Exception{
		WebElement click = null;
		try {
			click = driver.findElement(By.id("nav-search-submit-button"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return click;
	}
	
	//Validate the number of pages and number of items
	public static WebElement validatePage() throws Exception{
		WebElement validatePage = null;
		try {
			validatePage = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']/span[contains(text(),'over')]"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return validatePage;
	}
	
	//Validate the Page is correctly searched
	public static WebElement validateSearch() throws Exception{
		WebElement validateSearch = null;
		try {
			validateSearch = driver.findElement(By.xpath("//*[@class = 'a-section a-spacing-small a-spacing-top-small']/span[contains(text(),'smartphones under')]"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return validateSearch;
	}
	
	//Finds the Sort Option
	public static WebElement findSortList() throws Exception{
		WebElement sortList = null;
		try {
			sortList = driver.findElement(By.id("a-autoid-0-announce"));
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return sortList;
	}
		
	//Finds the Sort option
	public static WebElement findNewArrivalOption() throws Exception{
		WebElement newArrival = null;
		try {
			newArrival = driver.findElement(By.xpath("//a[contains(@id,'s-result-sort-select_4')]"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return newArrival;
	}
	
	//Validate the Newest Arrival Page
	public static WebElement validateNewArrival() throws Exception{
		WebElement validateNew = null;
		try {
			validateNew = driver.findElement(By.xpath("//span[contains(text(),'Newest Arrivals')]"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return validateNew;
	}
	
}
