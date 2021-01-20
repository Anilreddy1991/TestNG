package org.cts.dataproviderpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Testcases_dataprovider {
	WebDriver driver;
	@Test(dataProviderClass=Data.class,dataProvider="testdata")
	public void login(String username,String password) {
		driver.findElement(By.id("user_name")).sendKeys(username);
		driver.findElement(By.id("user_pass")).sendKeys(password);
		driver.findElement(By.id("login_button")).click();
	}
	@Test(dataProviderClass=Data.class,dataProvider = "getdata")
	 public void addUsers(String firstname,String lastname,String email) {
			WebElement settings=driver.findElement(By.xpath("//img[@alt='Settings']"));
			Actions actions=new Actions(driver);
			actions.moveToElement(settings).build().perform();
			driver.findElement(By.linkText("Users")).click();
			driver.findElement(By.id("fname")).sendKeys(firstname);
			driver.findElement(By.id("lname")).sendKeys(lastname);
			driver.findElement(By.id("email")).sendKeys(email);
			driver.findElement(By.xpath("//input[@value='Add User']")).click();
			}

@Test(dataProviderClass=Data.class,dataProvider = "getdata")
	 public void customers(String acountnumber,String customername,String companyname){
	WebElement settings=driver.findElement(By.xpath("//img[@alt='Settings']"));
	Actions actions=new Actions(driver);
	actions.moveToElement(settings).build().perform();
	driver.findElement(By.linkText("Customers")).click();
	
		  driver.findElement(By.id("account_number")).sendKeys(acountnumber);
		  driver.findElement(By.id("customer_name")).sendKeys(customername);
		  driver.findElement(By.id("company_name")).sendKeys(companyname);
		  driver.findElement(By.xpath("//input[@value='Add Customer']")).click();
		  }
	
		

}
