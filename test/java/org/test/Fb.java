package org.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Fb {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driverv = new ChromeDriver();
		driverv.get("https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager/5.1.1");
	} 

}
