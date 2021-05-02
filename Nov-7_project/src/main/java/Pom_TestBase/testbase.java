package Pom_TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import Pom_Util.Testutility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class testbase {

	public static WebDriver driver;
	
	public static File file;
	
	public static FileInputStream fis;
	
	public static Properties prop;
	
	public testbase() throws IOException {
		
		file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\Pom_Properties\\config.properties");
		
		fis = new FileInputStream(file);
		
		prop = new Properties();
		
		prop.load(fis);
		
	}
	
	public static void inilization() {
		
		String browsername = prop.getProperty("browser");
		
		if (browsername.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			
			driver = new ChromeDriver();
			
		}
		
		else if (browsername.equalsIgnoreCase("firefox")) {
		
		WebDriverManager.firefoxdriver().setup();
		
		driver = new FirefoxDriver();
		
		}
		
		else if (browsername.equalsIgnoreCase("ie")) {
			
			WebDriverManager.iedriver().setup();
			
			driver = new InternetExplorerDriver();
			
		}
		
		else {
			
			System.out.println("selenium doesn't support this browser = "+browsername);
			
		}
		
		driver.get(prop.getProperty("url"));
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(Testutility.IMPLICTWAITTIMEOUT, TimeUnit.SECONDS);
		
		driver.manage().timeouts().pageLoadTimeout(Testutility.PAGELOADTIMEOUT, TimeUnit.SECONDS);
		
	} 
		
		}
