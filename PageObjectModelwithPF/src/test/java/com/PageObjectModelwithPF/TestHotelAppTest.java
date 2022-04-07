package com.PageObjectModelwithPF;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.HomePage;

public class TestHotelAppTest extends HotelAppTest {
	
	@Test
	public void init() throws Exception{
 
			
			
			HomePage homepage = PageFactory.initElements(driver, HomePage.class);
			homepage.typeEmailId("adactin123");
			homepage.typePassword("adactin123");
			homepage.clickSignIn();	
		}

}
