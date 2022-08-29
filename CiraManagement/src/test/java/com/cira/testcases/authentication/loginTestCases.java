package com.cira.testcases.authentication;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class loginTestCases {
	WebDriver driver;

	String LoginURL = "https://sandbox.ciranet.com/v2/managementportal/user/login";
	@SuppressWarnings("deprecation")
	@Parameters("browser")
	@BeforeTest
	public void setUp(String browser)
	{
		if(browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println(" Chrome Driver Started");
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver","D:\\geckodriver.exe" );  
			driver= new FirefoxDriver();  
			System.out.println(" Firefox Driver Started");
		}
		else
			System.out.println("Cannot launch specified driver... ");

		driver.navigate().to("https://sandbox.ciranet.com/v2/managementportal/user/login"); 
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS); // pageload timeout  
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
		driver.manage().window().maximize(); 

		//System.out.println("Set Up Method ");
	}

	@SuppressWarnings("deprecation")
	@Test(priority=0)
	public void ValidInputLoginTest() throws InterruptedException, IOException
	{
		String username = "abhay.ranade";
		String password = "YellowFrame62#";

		driver.findElement(By.xpath("//input[contains(@type,'text')]")).clear();
		driver.findElement(By.xpath("//input[contains(@type,'text')]")).sendKeys(username);

		driver.findElement(By.xpath("//input[@type='password']")).clear();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);

		driver.findElement(By.xpath("//span[contains(.,'Log in')]")).click();
		Thread.sleep(7000);
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);

		String expectedurl = "https://sandbox.ciranet.com/v2/managementportal/home";
		String actualurl = driver.getCurrentUrl();
		//	System.out.println("Valid Input Test");
		Assert.assertEquals(expectedurl, actualurl);
		System.out.println("Login Successful with Valid Credentials");
		
		Thread.sleep(7000);
		userlogout();
		

	}
	
	@SuppressWarnings("deprecation")
	@Test(priority=1)
	public void ValidInputLoginTestWithEnterKey() throws InterruptedException, IOException
	{
		String username = "abhay.ranade";
		String password = "YellowFrame62#";

		driver.findElement(By.xpath("//input[contains(@type,'text')]")).clear();
		driver.findElement(By.xpath("//input[contains(@type,'text')]")).sendKeys(username);

		driver.findElement(By.xpath("//input[@type='password']")).clear();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(Keys.ENTER);

		//driver.findElement(By.xpath("//span[contains(.,'Log in')]")).click();
		Thread.sleep(7000);
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);

		String expectedurl = "https://sandbox.ciranet.com/v2/managementportal/home";
		String actualurl = driver.getCurrentUrl();
		//	System.out.println("Valid Input Test");
		Assert.assertEquals(expectedurl, actualurl);
		System.out.println("Login Successful after hitting ENTER key with Valid Credentials");
		Thread.sleep(7000);
		userlogout();
	}

	

	@SuppressWarnings("deprecation")
	@Test(priority=2)
	public void clickBrowserBackTest() throws InterruptedException, IOException
	{
		String username = "abhay.ranade";
		String password = "YellowFrame62#";

		driver.findElement(By.xpath("//input[contains(@type,'text')]")).clear();
		driver.findElement(By.xpath("//input[contains(@type,'text')]")).sendKeys(username);

		driver.findElement(By.xpath("//input[@type='password']")).clear();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		
		
		driver.findElement(By.xpath("//span[contains(.,'Log in')]")).click();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);

		//String expectedurl = "https://sandbox.ciranet.com/v2/managementportal/home";
		//String actualurl = driver.getCurrentUrl();
		////	System.out.println("Valid Input Test");
		//Assert.assertEquals(expectedurl, actualurl);
		driver.navigate().back();
		Thread.sleep(7000);
		String expectedurl = "https://sandbox.ciranet.com/v2/managementportal/home";
		String actualurl = driver.getCurrentUrl();
		Assert.assertEquals(expectedurl, actualurl);
		System.out.println("Login Successful after Browser Back");
		Thread.sleep(7000);
		userlogout();
	}
	
	// this locator is for invalid login message
	//div[@class='dx-overlay-content dx-toast-error dx-toast-content dx-resizable']
	
	@Test(priority=3)
	public void InvalidUserValidPassword() throws InterruptedException, IOException
	{

		
		// Sleep for 2 seconds
		Thread.sleep(1000);
		
		// find username field and clear to the input field
		driver.findElement(By.xpath("//input[contains(@type,'text')]")).clear();
		
		// find username field and send the username itself to the input field
		driver.findElement(By.xpath("//input[contains(@type,'text')]")).sendKeys("Test");
		
		// find username field and clear to the input field
		driver.findElement(By.xpath("//input[@type='password']")).clear();
		
		// find password field and send the username itself to the input field
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Blaze@123");
		
		// click login button
		driver.findElement(By.xpath("//span[contains(.,'Log in')]")).click();
		
		// Sleep for 2 seconds
		Thread.sleep(2000);
		//driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		
		// Variable contains a collection of characters surrounded by double quotes
		String expectedurl1 = "https://sandbox.ciranet.com/v2/managementportal/home";
		
		//getCurrentUrl(): It fetches the URL of the opened application.
		String actualurl1 = driver.getCurrentUrl();
				
		// Compare between two variable whether both are equal or not
		Assert.assertNotEquals(expectedurl1, actualurl1);
		
		// Method prints text on a new row in the console
		System.out.println("Invalid Credentials");
		
		// Sleep for 2 seconds
		Thread.sleep(2000);
	}

	
	@Test(priority=4)
	public void validUserInvalidPassword() throws InterruptedException, IOException
	{
		// find username field and clear to the input field
		driver.findElement(By.xpath("//input[contains(@type,'text')]")).clear();
		
		// find username field and send the username itself to the input field			
		driver.findElement(By.xpath("//input[contains(@type,'text')]")).sendKeys("abh.ranade");
		
		// find username field and clear to the input field
		driver.findElement(By.xpath("//input[@type='password']")).clear();
		
		// find password field and send the username itself to the input field
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("******");

		// click login button
		driver.findElement(By.xpath("//span[contains(.,'Log in')]")).click();
		
		// Sleep for 2 seconds
		Thread.sleep(2000);
		//driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		
		// Variable contains a collection of characters surrounded by double quotes
		String expectedurl1 = "https://sandbox.ciranet.com/v2/managementportal/home";
		
		//getCurrentUrl(): It fetches the URL of the opened application.
		String actualurl1 = driver.getCurrentUrl();
				
		// Compare between two variable whether both are equal or not
		Assert.assertNotEquals(expectedurl1, actualurl1);
		
		// Method prints text on a new row in the console
		System.out.println("Invalid Credentials");
		
		// Sleep for 2 seconds
		Thread.sleep(2000);
	}
	
	@SuppressWarnings("deprecation")
	@Test(priority=5)
	public void InValidInputLoginTest() throws InterruptedException, IOException
	{
		String username1 = "abhay";
		String password1 = "test1234";

		driver.findElement(By.xpath("//input[contains(@type,'text')]")).clear();
		driver.findElement(By.xpath("//input[contains(@type,'text')]")).sendKeys(username1);

		driver.findElement(By.xpath("//input[@type='password']")).clear();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password1);

		driver.findElement(By.xpath("//span[contains(.,'Log in')]")).click();
		Thread.sleep(5000);
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);

		String expectedurl1 = "https://sandbox.ciranet.com/v2/managementportal/home";
		String actualurl1 = driver.getCurrentUrl();
		//System.out.println(" InValid Input Test ");

		Assert.assertNotEquals(expectedurl1, actualurl1);
		System.out.println("Login Denied with Invalid Credentials");

	}

	@Test(priority=6)
	public void ShowPasswordFunctionality() throws InterruptedException, IOException
	{
		String enteredpwd = "Qwert@1234";
		WebElement passwordText = driver.findElement(By.xpath("//input[@type='password']"));
		passwordText.clear();
		passwordText.sendKeys(enteredpwd);
		String pwd = passwordText.getAttribute("value");
		System.out.println("Password is : "+pwd);

		WebElement showIcon = driver.findElement(By.xpath("//i[contains(@class,'dx-icon fas fa-eye')]"));
		showIcon.click();
		Thread.sleep(4000);

		boolean passwordDisplayed= driver.findElement(By.xpath("(//input[@role='textbox'])[2]")).isDisplayed();
		Assert.assertTrue(passwordDisplayed);
		
		WebElement hideIcon = driver.findElement(By.xpath("//i[@class='dx-icon fas fa-eye-slash']"));
		hideIcon.click();
		System.out.println("Password Displayed : "+passwordDisplayed);
	}

	@Test(priority=7)
	public void LoginWithEmptyField() throws InterruptedException
	{	
		Thread.sleep(1000);
		/*
		 * driver.findElement(By.xpath("//input[contains(@type,'text')]")).clear();
		 * driver.findElement(By.xpath("//input[@type='password']")).clear();
		 */
		driver.findElement(By.xpath("//input[contains(@type,'text')]")).clear();
		WebElement usernameinput = driver.findElement(By.xpath("//input[contains(@type,'text')]"));
		
		driver.findElement(By.xpath("//input[@type='password']")).clear();
		WebElement passwordinput = driver.findElement(By.xpath("//input[@type='password']"));
		           //dx-text-box[@placeholder='Password']//input[@role='textbox']
		
		
		String textInsideUsername = usernameinput.getAttribute("value");
		String textInsidePassword = passwordinput.getAttribute("value");
		// Check whether input field is blank
		if(textInsideUsername.isEmpty() && textInsidePassword.isEmpty())
		{
			System.out.println("Input field is empty");
			driver.findElement(By.xpath("//span[contains(.,'Log in')]")).click();
			Thread.sleep(5000);
			//	String actualurl = driver.getCurrentUrl();

			String[] expectedURL = {
					"https://sandbox.ciranet.com/v2/managementportal/user/login",
					"https://sandbox.ciranet.com/v2/managementportal/user/login?returnUrl=%2Fhome"
			};
			Assert.assertTrue(Arrays.asList(expectedURL).contains(LoginURL),"Login Failed");
			System.out.println("Login Denied with Empty UserName and Password Fields");
			//assertThat(LoginURL, is(in(expectedURL)));
			//	Assert.assertEquals(actualurl, LoginURL);
		}
	}
	
public void userlogout() {
		
		WebElement element = driver.findElement(By.xpath("//div[@class='cc-user-panel-name']"));
		try {
			Thread.sleep(500);
			
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			
			//driver.findElement(By.xpath("//div[@class='cc-user-panel-name']")).click();

			Thread.sleep(500);

			driver.findElement(By.xpath("//span[contains(.,'Logout')]")).click();


		} 
		catch (

				InterruptedException e) {
			System.out.println("Logout");
		}

		

	}
	

	@AfterTest
	public void tearDown() throws InterruptedException
	{
		//System.out.println("Tear Down Method");
		Thread.sleep(2000);
		//driver.close();
		driver.quit();

	}



}
