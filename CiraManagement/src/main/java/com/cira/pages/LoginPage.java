	package com.cira.pages;

	import java.io.IOException;
	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.testng.Assert;


	public class LoginPage {
	public boolean isLoggedin;
		
		String LoginURL = "https://sandbox.ciranet.com/v2/managementportal/user/login";		
			
			@SuppressWarnings("deprecation")
			public void LoginTest(WebDriver driver) throws InterruptedException, IOException
			{
				
//				System.setProperty("webdriver.chrome.driver","D:\\ChromeDriver\\chromedriver.exe");
//				driver = new ChromeDriver();
				System.out.println(" Chrome Driver Started");				
			driver.navigate().to("https://sandbox.ciranet.com/v2/managementportal/user/login"); 
			driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS); // pageload timeout  
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
			driver.manage().window().maximize(); 
				
				String username = "abhay.ranade";
				String password = "YellowFrame62#";
				
				driver.findElement(By.xpath("//body/app-root[1]/dx-box[1]/div[1]/dxi-item[1]/div[1]/app-common-user-authentication-layout[1]/div[1]/div[1]/div[1]/div[1]/app-login[1]/dx-validation-group[1]/dx-responsive-box[1]/div[1]/div[1]/div[1]/div[1]/dxi-item[1]/div[1]/div[1]/dx-text-box[1]/div[1]/div[1]/input[1]")).clear();
				driver.findElement(By.xpath("//body/app-root[1]/dx-box[1]/div[1]/dxi-item[1]/div[1]/app-common-user-authentication-layout[1]/div[1]/div[1]/div[1]/div[1]/app-login[1]/dx-validation-group[1]/dx-responsive-box[1]/div[1]/div[1]/div[1]/div[1]/dxi-item[1]/div[1]/div[1]/dx-text-box[1]/div[1]/div[1]/input[1]")).sendKeys(username);
				
				driver.findElement(By.xpath("//body/app-root[1]/dx-box[1]/div[1]/dxi-item[1]/div[1]/app-common-user-authentication-layout[1]/div[1]/div[1]/div[1]/div[1]/app-login[1]/dx-validation-group[1]/dx-responsive-box[1]/div[1]/div[1]/div[1]/div[2]/dxi-item[1]/div[1]/div[1]/dx-text-box[1]/div[1]/div[1]/input[1]")).clear();
				driver.findElement(By.xpath("//body/app-root[1]/dx-box[1]/div[1]/dxi-item[1]/div[1]/app-common-user-authentication-layout[1]/div[1]/div[1]/div[1]/div[1]/app-login[1]/dx-validation-group[1]/dx-responsive-box[1]/div[1]/div[1]/div[1]/div[2]/dxi-item[1]/div[1]/div[1]/dx-text-box[1]/div[1]/div[1]/input[1]")).sendKeys(password);
				
				driver.findElement(By.xpath("//body/app-root[1]/dx-box[1]/div[1]/dxi-item[1]/div[1]/app-common-user-authentication-layout[1]/div[1]/div[1]/div[1]/div[1]/app-login[1]/dx-validation-group[1]/dx-responsive-box[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/dx-button[1]/div[1]")).click();
				Thread.sleep(10000);
				driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS); // pageload timeout  
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
				
				
				String expectedurl = "https://sandbox.ciranet.com/v2/managementportal/home";
				String actualurl = driver.getCurrentUrl();
			//	System.out.println("Valid Input Test");
				
				Assert.assertEquals(actualurl, expectedurl);
					isLoggedin = true;
					System.out.println("Login Successful");
					System.out.println("Login Status : "+isLoggedin);
					//return(isLoggedin);
				//System.out.println("Login Status : "+isLoggedin);
			}
			

}
