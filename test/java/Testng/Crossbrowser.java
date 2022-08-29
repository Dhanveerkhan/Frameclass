package Testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Crossbrowser<expection> {
	public static WebDriver driver;
	@Parameters("browsername")
    @Test
    private void test2(String b) {
		if	(b.equalsIgnoreCase("chrome"))
		{
    System.out.println("chrome");
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
		}
		else if
    (b.equalsIgnoreCase("firefox")) {
			 WebDriverManager.firefoxdriver().setup();
	    driver=new FirefoxDriver();
		}
	    else 
	   // (b.equalsIgnoreCase("ie"))
	    	{
	    	 WebDriverManager.iedriver().setup();
 	    driver=new InternetExplorerDriver();
 	    driver.get("https://www.google.com/search?q=github&rlz=1C1CHBF_enIN998IN998&oq=&aqs=chrome.0.35i39i362l8.40860055j0j15&sourceid=chrome&ie=UTF-8");
	    }    
	    driver.quit();
	}}