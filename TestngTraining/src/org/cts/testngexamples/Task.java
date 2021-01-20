package org.cts.testngexamples;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task {
	static WebDriver driver;

	@BeforeTest
	public void initialization() {
		System.setProperty("webdriver.chrome.driver", "../TestngTraining/Browsers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");

	}

	@Test(priority = 1)
	public void enterAppleandPrintList() {
		WebElement ele = driver.findElement(By.xpath("//input[@title='Search']"));
		ele.sendKeys("apple");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> websites = driver.findElements(By.xpath("//li[@role='presentation']"));
		System.out.println(websites.size());
		for (WebElement options : websites) {
			System.out.println(options.getText());
		}
	}

	@Test(priority = 2)
	public static void enterAppleAndPrintLinks() {
		WebElement ele = driver.findElement(By.xpath("//input[@title='Search']"));
		ele.clear();
		ele.sendKeys("apple");
		ele.submit();
		List<WebElement> links = driver.findElements(By.xpath("//div[@class='sld usJj9c']"));
		System.out.println(links.size());
		for (WebElement totalLinks : links) {
			System.out.println(totalLinks.getText());
		}

	}

	@Test(priority = 3)
	public static void verifyText() {
		WebElement ele2 = driver.findElement(By.xpath("//span[text()='Apple (India)']"));
		ele2.click();
		WebElement ele3 = driver.findElement(By.linkText("Find a retailer"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ele3);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ele3.click();
		String actTitle = driver.findElement(By.xpath("//nav[@id='locatorHeader']//h1")).getText();
		System.out.println(actTitle);
		Assert.assertEquals(actTitle, "Find Locations");
	}

	@AfterTest
	public void teardown() {
		driver.close();
		driver.quit();
	}

}
