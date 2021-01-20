package org.cts.testngexamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataproviderExample {
	WebDriver driver;
	@BeforeTest
	public void initialization() {
		System.setProperty("webdriver.chrome.driver","../TestngTraining/Browsers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://training.openspan.com/login");
		
		/*
		 * driver.findElement(By.id("user_name")).sendKeys("anil");
		 * driver.findElement(By.id("user_pass")).sendKeys("1234");
		 * driver.findElement(By.id("login_button")).click();
		 */
		 
		 	}
	
	
	  @DataProvider(name="getdata") 
	  public Object[][] getdata(){ 
		  Object[][] data=new Object[1][2]; 
		  data[0][0]="1234"; 
		  data[0][1]="1234";
	      return data; }
	  
	  @Test(dataProvider = "getdata") 
	  public void userLogin(String username,String password){ 
	  driver.findElement(By.id("user_name")).sendKeys(username);
	  driver.findElement(By.id("user_pass")).sendKeys(password);
	  driver.findElement(By.id("login_button")).click(); }
	 
	  @DataProvider(name="getdata1")
		public Object[][] getdata1(){
			Object[][] data=new Object[2][3];
			data[0][0]="anil";
			data[0][1]="reddy";
			data[0][2]="anil2421@gmail.com";
			
			data[1][0]="sunil";
			data[1][1]="reddy";
			data[1][2]="sunil2321@gmail.com";
			return data;
		}
	@Test(dataProvider = "getdata1")
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
	
	
	
	  @AfterTest public void teardown() { 
		  driver.close(); }
	 
	

}
