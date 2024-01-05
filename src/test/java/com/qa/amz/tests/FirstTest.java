package com.qa.amz.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
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
		
		driver = new EdgeDriver();	//top casting
		
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
