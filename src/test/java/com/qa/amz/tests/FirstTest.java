package com.qa.amz.tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class FirstTest {
	
	WebDriver driver;

	/*
	 * public static void main(String[] args) throws InterruptedException {
	 * 
	 * FirstTest ft = new FirstTest(); ft.doClickOnRegisterButton(); }
	 */
	
	@Test
	public void doClickOnRegisterButton() throws InterruptedException {
		
		EdgeOptions options = new EdgeOptions();
		//options.addArguments(Capabilities {browserName: MicrosoftEdge, ms:edgeOptions: {args: [--start-maximized], extensions: []}});
		options.addArguments("--start-maximized");
		options.setBinary("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");
		
		driver = new EdgeDriver(options);	//top casting
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//*[@id='column-right']//a)[2]")).click();
		
		Thread.sleep(2000);
		
		String title = driver.getTitle();
		
		if(title.contains("Register Account")) {
			System.out.println("We are on register page");
		}
		
	}
	

}
