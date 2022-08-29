package com.junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Junit {
static WebDriver driver;


@BeforeClass
public static void beforeClass() {
	WebDriverManager.chromedriver().setup();
	driver= new ChromeDriver();
	driver.get("https://adactinhotelapp.com/");
	driver.manage().window().maximize();

}
@AfterClass
public static void method() {
driver.quit();
}

@Test
public void logIn() {
	WebElement userName = driver.findElement(By.id("username"));
	userName.sendKeys("9894360418");
	
	
	WebElement pass = driver.findElement(By.id("password"));
	pass.sendKeys("Khan@1998");

}

@Before
public void beforemethod() {
	long start = System.currentTimeMillis();
	System.out.println(start);

}
@After
public void aftermethod() {
  long start = System.currentTimeMillis();
  System.out.println(start);
}


}




