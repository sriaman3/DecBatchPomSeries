package com.qa.amz.tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class FirstTest {
	
	/**
	 * https://stackoverflow.com/questions/73137473/how-do-i-run-githhub-actions-yaml-files-in-certain-order
	 * 
	 * https://medium.com/@saurabhdube/running-selenium-web-tests-maven-java-with-github-actions-a20cba622af4 (Example)
	 * 
	 * https://docs.github.com/en/actions/quickstart
	 * 
	 * how to run - https://stackoverflow.com/questions/63003669/how-can-i-see-my-git-secrets-unencrypted
	 * 
	 * mvn command - mvn clean test -Dusername="aman@opencart.com" -Dsurefire.suiteXmlFiles=src/test/resources/testrunners/testng_sanity.xml
	 * 
	 */
	
	WebDriver driver;

	/*
	 * public static void main(String[] args) throws InterruptedException {
	 * 
	 * FirstTest ft = new FirstTest(); ft.doClickOnRegisterButton(); }
	 */
	
	@Test
	public void doClickOnRegisterButton() throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--headless");
		driver = new ChromeDriver(options);
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		String user = System.getProperty("username");
		
		WebElement ele = driver.findElement(By.id("input-email"));
		ele.sendKeys(user);
		
		String password = System.getProperty("password");
		
		driver.findElement(By.name("password")).sendKeys(password);
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		String title = driver.getTitle();
		
		if(title.contains("My Account")) {
			System.out.println("We are on account page");
		}
		
		String url = driver.getCurrentUrl();
		
		if(url.contains("account/account")) {
			System.out.println("We are on account page");
		}
		
	}
	

}
