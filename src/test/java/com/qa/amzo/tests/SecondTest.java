package com.qa.amzo.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;

public class SecondTest {
	
	WebDriver driver;	
	
	int i =10;

	public static void main(String[] args) throws InterruptedException {
		
		SecondTest st = new SecondTest();
		
		st.windowID();

	}
	
	/**
	 * <input type="text" name="email" value="" placeholder="E-Mail Address" id="input-email" class="form-control" fdprocessedid="gh9rhu">
	 * 
	 * input, label, div,a   is -  tagName
	 * 
	 * type, name, id, placeholder, class = Attributes
	 * 
	 * text, email, input-email = Attributes value
	 * @throws InterruptedException 
	 * 
	 */
	
	
	public void windowID() throws InterruptedException {
		
		driver = new EdgeDriver();
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		driver.manage().window().maximize();
		
		driver.manage().window().minimize();
		
		String parentID = driver.getWindowHandle();
		
		System.out.println(parentID);
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		String childID = driver.getWindowHandle();
		

		System.out.println(childID);
		
		Thread.sleep(3000);
		
		driver.switchTo().window(parentID);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public void listOfElements() {
		
		driver = new EdgeDriver();
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		driver.manage().window().maximize();
		
		List<WebElement> ele = driver.findElements(By.tagName("a"));
		
		System.out.println(ele.size());
		
		for(int i=0;i<ele.size();i++) {
			System.out.println(ele.get(i).getText());
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void getAttributes() {
		
		driver = new EdgeDriver();
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		driver.manage().window().maximize();
		
		WebElement ele = driver.findElement(By.id("input-email"));
		
		String str = ele.getAttribute("placeholder"); //value of the attributes
		
		System.out.println(str);
		
	}
	
	
	
	
	public void navigationCommand() throws InterruptedException {
		
		driver = new EdgeDriver();
		
		driver.navigate().to("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		driver.manage().window().maximize();
		
		driver.navigate().back();
		
		Thread.sleep(3000);
		driver.navigate().forward();
		Thread.sleep(3000);
		driver.navigate().refresh();
		
	}
	
	
	public void setUp() throws InterruptedException{
		
		driver = new EdgeDriver();
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		driver.manage().window().maximize();
		
		WebElement ele = driver.findElement(By.id("input-email"));
		ele.sendKeys("aman@opencart.com");
		
		Thread.sleep(3000);
		ele.clear();
		
		//driver.findElement(By.name("password")).sendKeys("1233455");
		
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
		
	}

}
