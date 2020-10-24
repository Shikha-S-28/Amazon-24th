package com.ta.Amazon;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtility_Amazon extends LoginTestBase {
	public WebDriver LaunchBrowser(String sBrowser)
	{
		switch(sBrowser)
		{
		case "ch" :
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
			
		case "FF" :
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
			
		default : 
				break;
		}
		return driver;
	}
	public void explicitwaitFunc(WebElement ele, int iTime) {
		WebDriverWait wait1 = new WebDriverWait(driver, iTime);
		wait1.until(ExpectedConditions.visibilityOf(ele));

	}
	public void LogintoWebsite() throws Exception
	{
		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		WebElement eleLink = driver.findElement(By.xpath("//span[contains(text(),'Hello, Sign in')]"));
		explicitwaitFunc(eleLink, 20);
		eleLink.click();

		WebElement eleEmail = driver.findElement(By.xpath("//input[@id='ap_email']"));
		explicitwaitFunc(eleEmail, 20);
		eleEmail.sendKeys("gagan8@gmail.com");

		WebElement eleContinue = driver.findElement(By.xpath("//input[@id='continue']"));
		explicitwaitFunc(eleContinue, 20);
		eleContinue.click();	
		
		Thread.sleep(3000);

		WebElement elePassword = driver.findElement(By.xpath("//input[@id='ap_password']"));
		explicitwaitFunc(elePassword, 20);
		elePassword.sendKeys("anPDW@2003");

		WebElement eleButtonSignin = driver.findElement(By.xpath("//input[@id='signInSubmit']"));
		explicitwaitFunc(eleButtonSignin, 30);
		eleButtonSignin.click();
	}
public void tearDownBrowser()
{
	driver.quit();
}
}