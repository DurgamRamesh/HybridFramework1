package config;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class AppUtil {
	public static  WebDriver driver;
	public static Properties config;
	@BeforeSuite 
	// precondition
	public static void setup() throws Throwable
	{
		config=new Properties();
		config.load(new FileInputStream("D:\\120clockselenium\\Hybrid_FrameWork\\PropertyFiles\\Environment.properties"));
		if(config.getProperty("Browser").equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "d://chromedriver.exe"); // batch file excution 
			System.out.println("Executing on chrome brower");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(config.getProperty("Url"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		else if(config.getProperty("Browser").equalsIgnoreCase("firefox"))
		{
			System.out.println("Executing on firefox brower");
			driver = new FirefoxDriver();
			driver.get(config.getProperty("Url"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		else 
		{
			Reporter.log("Browser value is Not Matching ",true);
		}
	    }
	@AfterSuite   
	// post conditions
	public static void tearDOWN()
	{
		driver.quit();
	}
    }
