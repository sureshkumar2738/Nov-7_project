package Pom_TestCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pom_Pages.RegisterPage;
import Pom_TestBase.testbase;

public class Pom_RegisterPage_TestCases extends testbase {
	
	RegisterPage registerpage;

	public Pom_RegisterPage_TestCases() throws IOException {
		super();
		
	}
	
	@BeforeMethod
	public void setup() throws IOException {
		
		inilization();
		
		registerpage = new RegisterPage();
		
	}
	
	@Test(priority = 1)
	public void doregister() {
		
		registerpage.doregister(prop.getProperty("firstname"));
		
	}
	

	@Test(priority = 2)
	public void registerpagevalidatepagetitletest() {
		
		String actualpagetitle = registerpage.validatepagetitle();
		
		Assert.assertEquals(actualpagetitle, "suresh");
		
	}
	
	@AfterMethod
	public void teardown(ITestResult result) throws IOException {
		
		if(ITestResult.FAILURE == result.getStatus()) {
			
			System.out.println("Testcase is failed");
			
			File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				
		    FileUtils.copyFile(source, new File("C:\\Users\\SURESH\\eclipse-workspace\\Nov-7_project\\src\\test\\resources\\screenshot\\failedtestcases.jpg"));
				
		}else {
			
			System.out.println("Testcase is passed");
			
		}
		
		driver.quit();
		
	}

}
