package com.inetbanking.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DGmail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		//WebDriver driver =new ChromeDriver();
		
		//System.setProperty("Webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//geckodriver.exe");
		System.setProperty("Webdriver.gecko.driver","C:\\Users\\Admin\\eclipse-workspace\\inetbankingV1\\Drivers\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	      driver.get("http://180.87.52.136/Focus9");
		driver.findElement(By.name("txtUsername")).sendKeys("su");
		driver.findElement(By.name("txtPassword")).sendKeys("focus@123");
		//driver.findElement(By.cssSelector("input[type='txtPassword']")).sendKeys("su");

	}

}