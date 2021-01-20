package org.cts.testngexamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestngParameter {
	WebDriver driver;
	@Parameters({"browser","url","username","password"})
	@Test(priority=1)
	public void invokeBrowser(String browser,String url,String username, String password) {
		/*
		 * if(browser.equalsIgnoreCase("Chrome")){
		 * System.out.println("Running Browser: "+browser);
		 * System.out.println("Running URL: "+url);
		 */
		System.setProperty("webdriver.chrome.driver","../TestngTraining/Browsers/chromedriver.exe");
	    driver=new ChromeDriver();
		
		/*}else if(browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver","../TestngTraining/Browsers/IEDriverServer.exe");
		    driver=new InternetExplorerDriver();
		}*/
	    driver.manage().window().maximize();
		
		driver.get(url);

		driver.findElement(By.id("user_name")).sendKeys(username);
	     System.out.println("enter username:"+username);
	    driver.findElement(By.id("user_pass")).sendKeys(password);
		System.out.println("enter password: "+password);
	    driver.findElement(By.id("login_button")).click();
		System.out.println("click on sign In button");
}
	@Parameters({"fname","lname","email"})
	@Test(priority=2)
	public void addUsers(String fname,String lname,String email) {
		WebElement menu=driver.findElement(By.xpath("(//a[@class='menu_option'])[1]"));
		Actions action=new Actions(driver);
		action.moveToElement(menu).build().perform();
		driver.findElement(By.linkText("Users")).click();
		driver.findElement(By.id("fname")).sendKeys(fname);
		driver.findElement(By.id("lname")).sendKeys(lname);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.xpath("//input[@value='Add User']")).click();
		}

	
	}




