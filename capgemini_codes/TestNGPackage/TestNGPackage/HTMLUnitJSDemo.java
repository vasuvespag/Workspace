package TestNGPackage;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;

public class HTMLUnitJSDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HtmlUnitDriver unitDriver = new HtmlUnitDriver(BrowserVersion.CHROME);
		//HtmlUnitDriver unitDriver = new HtmlUnitDriver(true);
		unitDriver.setJavascriptEnabled(true);
		unitDriver.get("http://demo.opencart.com/");
		String domainName = (String) unitDriver.executeScript("return document.domain");
		System.out.println("Domain name is " + domainName);
	}
}