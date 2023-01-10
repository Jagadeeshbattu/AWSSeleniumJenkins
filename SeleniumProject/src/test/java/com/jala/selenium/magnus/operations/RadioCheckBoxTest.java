/*
 * This class coves all the operations on radio buttons and check boxes
 * Selecting the radio button
 * number of elements
 * radio button values
 * isSelected
 * isEnabled
 * This class also deals with drop down operations
 */
package com.jala.selenium.magnus.operations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioCheckBoxTest {
WebDriver driver;
	
	/*
	 * This method launches the browser and open the magnus application
	 */
    @Test(priority=0)
	public void testlaunchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();//This maximizes the window
		driver.get("http://magnus.jalatechnologies.com/");
	}
	
	/*
	 *This method logins into magnus application by using xpath method
	 */
    @Test(priority=1)
	public void testloginMagnus() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"UserName\"]")).sendKeys("training@jalaacademy.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys("jobprogram");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
		Thread.sleep(1000);
	}
	
	/*
	 *This method is creating an employee 
	 */
    @Test(priority=2)
	public void testcreateEmployee() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"MenusDashboard\"]/li[2]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"MenusDashboard\"]/li[2]/ul/li[1]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"FirstName\"]")).sendKeys("Rishabh");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"LastName\"]")).sendKeys("Patel");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"EmailId\"]")).sendKeys("rishabhpatel@jala.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"MobileNo\"]")).sendKeys("9876543210");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"frmEmployee\"]/div[1]/div/div[2]/div[2]/div/div")).click();
		driver.findElement(By.xpath("//*[@id=\"frmEmployee\"]/div[1]/div/div[2]/div[2]/div/div")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/table/thead/tr[2]/th[2]")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div[2]/table/thead/tr[2]/th[2]")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div[3]/table/thead/tr[2]/th[1]")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div[3]/table/thead/tr[2]/th[1]")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div[3]/table/tbody/tr/td/span[1]")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div[2]/table/tbody/tr/td/span[5]")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/table/tbody/tr[6]/td[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"rdbMale\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"Address\"]")).sendKeys("Patna");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"CountryId\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"CountryId\"]/option[6]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"CityId\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"CityId\"]/option[5]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"chkSkill_5\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"chkSkill_3\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"chkSkill_2\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"chkSkill_4\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"chkSkill_1\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"chkSkill_6\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"frmEmployee\"]/div[2]/button")).click();
		Thread.sleep(1000);
	}
	
	/*
	 *THis method deals with radio buttons by going in the create employee section
	 */
    @Test(priority=3)
	public void testradioButton() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"MenusDashboard\"]/li[2]/ul/li[1]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"MenusDashboard\"]/li[2]/ul/li[1]/a")).click();
		Thread.sleep(1000);
		 
		//Creating a web element to store the radio button by using By.name method
         List<WebElement> radio = driver.findElements(By.name("rdbGender")); 
        
         //This will print the no of elements of radio button with same name 
         System.out.println("The number of elements in a radiogroup which have common name: "+radio.size());
         
         //To find out the value of the radio button using its name
         System.out.println(driver.findElement(By.name("rdbGender")).getAttribute("value"));
         
         // This also finds the value attribute of the radio button and print it's value
         System.out.println(driver.findElement(By.id("rdbFemale")).getAttribute("value"));
         
         //By creating a boolean variable to store its selected value whether it's true or not
         boolean value= driver.findElement(By.id("rdbMale")).isSelected();
         
         //Creating condition if the radio button value will be true then only it will enter the condition
         if(value==true) {
        	//It will print the value of the isSelected radio button
        	 System.out.println("The selected radiobutton value : "+driver.findElement(By.id("rdbMale")).getAttribute("value"));
         }
         
         //It returns the value true when the check box element is enabled and vice versa
         System.out.println("Returns True if Enabled : "+ driver.findElement(By.xpath("//*[@id=\"chkSkill_2\"]")).isEnabled()); 
	}
	
	/*
	 *This method is for drop down operations to be done on the create employee select options
	 */
    @Test(priority=4)
	public void testdropdown() {
		//Select class is called and its object is created and the drop down element is found via xpath
		Select s = new Select(driver.findElement(By.xpath("//*[@id=\"CountryId\"]")));
		
		//List web element is created and "Select" object s is used to capture the options from the drop down and store it in the List Web element
		List<WebElement> options = s.getOptions();
		int i=1;
		System.out.println("The dropdown values are: ");
		
		//for each loop is used to print the values and another web element is created to print the values
		for(WebElement e : options) {
			//It prints all the text values 
			System.out.println(i+". "+e.getText());
			i++;
		}
	}
	
	/*
	 *This method is for printing the first selected value by default
	 */
    @Test(priority=5)
	public void testdropdownselected() {
		Select s = new Select(driver.findElement(By.xpath("//*[@id=\"CountryId\"]")));
		List<WebElement> options = s.getOptions();
		int i=1;
		System.out.println("The selected dropdown value is : ");
		for(WebElement e : options) {
			// condition is put so that it prints only the selected value 
			if(e.isSelected()==true) {
			System.out.println(i+". "+e.getText());
			i++;
			}
		}
		}
	
	/*
	 *This method will logout and closes the browser
	 */
    @Test(priority=6)
	public void testcloseBrowser() {
		driver.findElement(By.xpath("/html/body/div[3]/header/nav/div/ul/li/a")).click();
		driver.close();
		driver.quit();
	}
}
