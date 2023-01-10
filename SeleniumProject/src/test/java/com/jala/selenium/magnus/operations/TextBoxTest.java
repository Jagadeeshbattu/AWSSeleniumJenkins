/*
 * This class covers the operations done on text boxes
 * Write in text box
 * value of text box
 * Value of placeholder
 * getAttribute method
 * isEnabled
 * using clear()
 */
package com.jala.selenium.magnus.operations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TextBoxTest {
WebDriver driver;
	
	/*
	 *TO launch Browser and redirect to the magnus application
	 */
    @Test(priority=0)
	public void testlaunchBrowser() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://magnus.jalatechnologies.com/");
		Thread.sleep(1000);
	}
	
	/*
	 *This method is for textbox element 
	 */
    @Test(priority=1)
	public void testtextBoxFunction() throws InterruptedException {
		
    	//How to Type in text box using Selenium Web Driver
		driver.findElement(By.xpath("//*[@id=\"UserName\"]")).sendKeys("training@jalaacademy.com");
		Thread.sleep(1000);
	    
		//How to Type in text box using Selenium Web Driver
		driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys("jobprogram");
		Thread.sleep(1000);
		
		//How to get a Text Box value using Selenium Web Driver
		System.out.println("The entered text in textbox: "+ driver.findElement(By.xpath("//*[@id=\"UserName\"]")).getAttribute("value"));
		
		//How to read the placeholder value of a Text Box using getAttribute() method
		System.out.println("The entered placeholder in the textbox is: "+ driver.findElement(By.xpath("//*[@id=\"Password\"]")).getAttribute("placeholder"));
		
		//Deleting/clear text from the Text Box
		driver.findElement(By.xpath("//*[@id=\"UserName\"]")).clear();
		Thread.sleep(1000);
		
		//Deleting/clear text from the Text Box
		driver.findElement(By.xpath("//*[@id=\"Password\"]")).clear();
		
		//Check if Text Box is enabled/disabled
		System.out.println("If true, the webelement is enabled; else false means disabled: "+driver.findElement(By.xpath("//*[@id=\"UserName\"]")).isEnabled());
	}
	
	/*
	 *It closes the browser
	 */
    @Test(priority=2)
	public void testcloseBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

	

}
