package org.cts.testngexamples;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;

public class CustomerDate {
	WebDriver driver;

	@BeforeSuite
	public void testInitialaization() {
		System.setProperty("webdriver.chrome.driver", "../TestngTraining/Browsers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void createcustomer() {
		driver.get("http://training.openspan.com/login");
		driver.findElement(By.id("user_name")).sendKeys("1234");
		driver.findElement(By.id("user_pass")).sendKeys("1234");
		driver.findElement(By.id("login_button")).click();

		WebElement ele = driver.findElement(By.xpath("//img[@alt='Settings']"));
		Actions action = new Actions(driver);
		action.moveToElement(ele).build().perform();

		driver.findElement(By.linkText("Customers")).click();
		driver.findElement(By.id("account_number")).sendKeys("251524");
		driver.findElement(By.id("customer_name")).sendKeys("Sidhu");
		driver.findElement(By.id("company_name")).sendKeys("Selenium");
		driver.findElement(By.id("login_button")).click();
		driver.findElement(By.id("account_street_address")).sendKeys("street1");
		driver.findElement(By.id("account_city")).sendKeys("city1");
		driver.findElement(By.id("account_state")).sendKeys("AP");
		driver.findElement(By.id("account_zip_code")).sendKeys("235420");
		driver.findElement(By.id("account_email")).sendKeys("sidhu@gmail.com");
		driver.findElement(By.id("account_phone")).sendKeys("123457898");

		Select sel = new Select(driver.findElement(By.name("account_level")));
		sel.selectByValue("Gold");

		driver.findElement(By.id("datepicker")).click();
		driver.findElement(By.xpath("//a[contains(@class,'ui-state-default ui-state-highlight')]")).click();
		driver.findElement(By.id("account_ssn_code")).sendKeys("1234578");
		driver.findElement(By.name("Save")).click();
		WebElement ele1 = driver.findElement(By.xpath("//img[@alt='Settings']"));
		Actions action1 = new Actions(driver);
		action1.moveToElement(ele1).build().perform();

		driver.findElement(By.linkText("Sign Out")).click();
	}

	@Test(priority = 2)
	public void selectproduct() {
		driver.findElement(By.id("user_name")).sendKeys("1234");
		driver.findElement(By.id("user_pass")).sendKeys("1234");
		driver.findElement(By.id("login_button")).click();

		WebElement ele = driver.findElement(By.linkText("Products"));
		Actions action = new Actions(driver);
		action.moveToElement(ele).build().perform();

		driver.findElement(By.linkText("Beverages")).click();

	}
}
