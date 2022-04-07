package com.cg.MunchPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MunchPage {
	WebDriver driver;
	// Step 1: identifing all web elements on page
	@FindBy(name="custname")
	@CacheLookup
	WebElement custname;
	
	@FindBy(name="address")
	@CacheLookup
	WebElement address;
	
	@FindBy(how=How.ID, using="no")
	@CacheLookup
	WebElement contactno;
	
	@FindBy(how=How.ID, using="porder")
	@CacheLookup
	WebElement porder;
	
	@FindBy(how=How.LINK_TEXT, using="Help")
	@CacheLookup
	WebElement help;
	
	//step 2: implementing methods to perform action on web elements
	
	public void CustName(String Cname)
	{
		custname.sendKeys(Cname);
	}
	
	
	public void Address(String add)
	{
		address.sendKeys(add);
	}
	public void ContactNo(String cno)
	{
		contactno.clear();
		contactno.sendKeys(cno);
	}
	public void PlaceOrderbtn()
	{
		porder.click();
	}
	
	public void Helplink()
	{
		help.click();
	}
	
// step 3 : initilize the element by using page factory and initelement method 
	//creating parameterized constructor
	
	public MunchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}
