package org.cts.dataproviderpackage;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class Data {
	WebDriver driver;
	@BeforeTest
	public void initialization() {
		System.setProperty("webdriver.chrome.driver","../TestngTraining/Browsers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://training.openspan.com/login");
		}
	@DataProvider
	public Object[][] testdata(){
		Object[][] data=new Object[1][2];
		data[0][0]="anil";
		data[0][1]="reddy";
		return data;
	}
	@DataProvider
	  public static Object[][] getdata(Method name){ 
	  System.out.println("testcase method name: "+name.getName());
	  Object[][] data=new Object[2][3]; 
	  data[0][0]="452374723685"; 
	  data[0][1]="Anil";
	  data[0][2]="cognizant";
	  
		data[1][0]="anil";
		data[1][1]="reddy";
		data[1][2]="anil2421@gmail.com";
		
		
	
	  return data; 
	  } 
	

}
