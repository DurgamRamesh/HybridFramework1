package commonFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import config.AppUtil;

public class FunctionLibrary extends AppUtil {
	// method for login
	public static boolean verifyLogin(String username,String password) throws Throwable
	{
		driver.findElement(By.xpath(config.getProperty("ObjUser"))).sendKeys(username);
		driver.findElement(By.xpath(config.getProperty("ObjPass"))).sendKeys(password);
		driver.findElement(By.xpath(config.getProperty("ObjLogin"))).click();
		Thread.sleep(3000);
		String expected="adminflow";
		String actual=driver.getCurrentUrl();
		if(actual.toLowerCase().contains(expected.toLowerCase()))
		{
			Reporter.log("Login Success:::"+expected+"           "+actual,true);
			return true;
		}
		else 
		{
			Reporter.log("Login Fail:::"+expected+"           "+actual,true);
			return false;
		}
	}
	// method click branches
	public static void clickBranches() throws Throwable
	{
		driver.findElement(By.xpath(config.getProperty("ObjBranches"))).click();
		Thread.sleep(3000);
	}
	// method for branch creation
	public static boolean verifyBranchcreation(String branchname,String Address1,String Address2,String Address3,String Area,String zipcode,
			String country,String state,String city) throws Throwable
	{
		driver.findElement(By.xpath(config.getProperty("ObjNewBranch"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(config.getProperty("ObjBranchName"))).sendKeys(branchname);
		driver.findElement(By.xpath(config.getProperty("ObjAddress1"))).sendKeys(Address1);
		driver.findElement(By.xpath(config.getProperty("ObjAddress2"))).sendKeys(Address2);
		driver.findElement(By.xpath(config.getProperty("ObjAddress3"))).sendKeys(Address3);
		driver.findElement(By.xpath(config.getProperty("ObjArea"))).sendKeys(Area);
		driver.findElement(By.xpath(config.getProperty("ObjZipcode"))).sendKeys(zipcode);
		new Select(driver.findElement(By.xpath(config.getProperty("ObjCountry")))).selectByVisibleText(country);
		Thread.sleep(3000);
		new Select(driver.findElement(By.xpath(config.getProperty("ObjState")))).selectByVisibleText(state);
		Thread.sleep(3000);
		new Select(driver.findElement(By.xpath(config.getProperty("Objcity")))).selectByVisibleText(city);
		Thread.sleep(3000);
		driver.findElement(By.xpath(config.getProperty("Objsubmit"))).click();
		// caputure alert text
		String expectedbranchalert=driver.switchTo().alert().getText();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		String actualbranchalert="New Branch with";
		if(expectedbranchalert.toLowerCase().contains(actualbranchalert.toLowerCase()))
		{
			Reporter.log(expectedbranchalert,true);
			return true;
		}
		else 
		{
			Reporter.log("Branch Creation Fail",true);
	 	return false;
	}
	}
	// method for branch updation
	public static boolean verifyBranchUpdation(String branch,String Adders,String area,String zipcode) throws Throwable
	{
		driver.findElement(By.xpath(config.getProperty("ObjEdit"))).click();
		Thread.sleep(3000);
		WebElement element=driver.findElement(By.xpath(config.getProperty("ObjBranch")));
		element.clear();
		element.sendKeys(branch);
		Thread.sleep(3000);
		WebElement element1=driver.findElement(By.xpath(config.getProperty("ObjAddress")));
		element1.clear();
		element1.sendKeys(Adders);
		Thread.sleep(3000);
		WebElement element2=driver.findElement(By.xpath(config.getProperty("ObjAreaName")));
		element2.click();
		element2.sendKeys(area);
		Thread.sleep(3000);
		WebElement element3=driver.findElement(By.xpath(config.getProperty("Objzip")));
		element3.clear();
		element3.sendKeys(zipcode);
		Thread.sleep(3000);
		driver.findElement(By.xpath(config.getProperty("ObjUpdate"))).click();
		Thread.sleep(3000);
		String expectedbranchupdatealert=driver.switchTo().alert().getText();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		String actualupdatealert="Branch updated";
		if(expectedbranchupdatealert.toLowerCase().contains(actualupdatealert.toLowerCase()))
		{
			Reporter.log("expectedbranchupdatealert",true);
			return true;
	}
		else
		{
			Reporter.log("Branch update Fail",true);
	}
		return false;
	}
	
	// logout method
	public static boolean verifyLogout() throws Throwable
	{
		driver.findElement(By.xpath(config.getProperty("ObjLogout"))).click();
		Thread.sleep(4000);
		if(driver.findElement(By.xpath(config.getProperty("ObjLogin"))).isDisplayed())
		{
			Reporter.log("Logout Success",true);
			return true;
		}
		else 
		{
			Reporter.log("Logout Fail",true);
			return false;
		}

	}
	
}
