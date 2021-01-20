package org.cts.testngexamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GroupsandMethods {
	WebDriver driver;
	@Test
	public void initialization() {
	System.setProperty("webdriver.chrome.driver","../TestngTraining/Browsers/chromedriver.exe");
     driver=new ChromeDriver();
     driver.get("http://training.openspan.com/login");
     driver.findElement(By.id("user_name")).sendKeys("1234");
	 driver.findElement(By.id("user_pass")).sendKeys("1234");
	 driver.findElement(By.id("login_button")).click();
		WebElement product=driver.findElement(By.linkText("Products"));
		Actions action=new Actions(driver);
		action.moveToElement(product).build().perform();
		driver.findElement(By.linkText("Beverages")).click();
		}
	@Test
	public void users() {
		WebElement setting=driver.findElement(By.xpath("//img[@alt='Settings']"));
		Actions action=new Actions(driver);
		action.moveToElement(setting).build().perform();
		driver.findElement(By.linkText("Users")).click();
		driver.findElement(By.id("fname")).sendKeys("Anil");
		driver.findElement(By.id("lname")).sendKeys("Reddy");
		driver.findElement(By.id("email")).sendKeys("anil2523@gmail.com");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//input[@value='Add User']")).click();
	}
	@Test
	public void logout() {
		WebElement setting=driver.findElement(By.xpath("//img[@alt='Settings']"));
		Actions action=new Actions(driver);
		action.moveToElement(setting).build().perform();
		driver.findElement(By.linkText("Sign Out")).click();
	}
	

}
