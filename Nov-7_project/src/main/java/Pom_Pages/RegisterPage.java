package Pom_Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Pom_TestBase.testbase;

public class RegisterPage extends testbase {
	
	@FindBy(xpath = "//input[@placeholder='First Name']")
	WebElement  firstname;
	
	public RegisterPage() throws IOException {
		
		PageFactory.initElements(driver, this);
	
	}
	
	public void doregister(String fname) {
		
		firstname.click();
		firstname.sendKeys(fname);
		
	}
	
	public String validatepagetitle() {
		
		return driver.getTitle();
		
	}	
		
}
