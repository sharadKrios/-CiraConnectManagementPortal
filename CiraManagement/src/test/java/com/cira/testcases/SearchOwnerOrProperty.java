package com.cira.testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SearchOwnerOrProperty extends Login{
	
	
	public WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@SuppressWarnings("deprecation")
	@Test
	public void searchOwnerOrProperty() throws InterruptedException, IOException {

		Login l1 = new Login();
		// l1.LoginTest(driver);
		l1.LoginTest(driver);
		String input = "romich";

		if (isLoggedin = true) {
			System.out.println("Navigating to Property or Owner >>romich\n");
			// To click on Owner search icon
			driver.findElement(By.xpath("//i[@class='dx-icon fas fa-house-user']")).click();
			// To click on Text box for Owner or Property search
			driver.findElement(By.xpath("(//input[@role='textbox'])[1]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//input[@role='textbox'])[1]")).clear();
			driver.findElement(By.xpath("(//input[@role='textbox'])[1]")).sendKeys(input);
			// Get xpath for Search icon click
			driver.findElement(By.xpath("//div[@class='dx-button-content']//i[@class='dx-icon fas fa-search']")).click();
			Thread.sleep(4000);
			String ownerOrPropertyPopUp = driver.getWindowHandle();
			driver.switchTo().window(ownerOrPropertyPopUp);
			Thread.sleep(2000);
			// This is for Pop up shown 
			List<WebElement> allLinks = driver.findElements(By.xpath("//body/div[1]/div[1]/div[1]"));

			Iterator<WebElement> itr = allLinks.iterator();
			
			System.out.println("Printing all WebElements in the Pop-Up :\n");
			while (itr.hasNext()) {
				System.out.println(itr.next().getText());
			}
			
//			 List<WebElement> clickableLinks = driver.findElements(By.tagName("a"));
//			 //Traversing through the list and printing its text along with link address
//			 for(WebElement link:clickableLinks){
//			 System.out.println(link.getText() + " - " + link.getAttribute("href"));
//			 }
			// Code for clicking the Address link
			driver.findElement(By.linkText("10604 Beard Ave")).click();
			Thread.sleep(5000);
			
			
			@SuppressWarnings({ "unchecked", "rawtypes" })
			ArrayList tabs = new ArrayList (driver.getWindowHandles());
			System.out.println("Tabs Open : "+tabs.size());
//			String amberwoodTab = driver.getWindowHandle();
//		driver.switchTo().window(amberwoodTab);
			driver.switchTo().window((String) tabs.get(1));
			driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS); // pageload timeout  
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
			Thread.sleep(10000);
		System.out.println("driver switched to : "+driver.getTitle());
		String actualURL = driver.getCurrentUrl();
		String expectedURL = "https://sandbox.ciranet.com/v2/managementportal/property/405/R0337337L0002552/home";	
		System.out.println("Current URL : "+actualURL);
		
		Assert.assertEquals(actualURL, expectedURL);
					

		} else {
			System.out.println("Failed to Login");
		}
	}
	
	@AfterTest
	public void tearDown() throws InterruptedException
	{
		//System.out.println("Tear Down Method");
		Thread.sleep(5000);
		//driver.close();
		driver.quit();
		
	}

}
