package org.test;

import java.awt.AWTException;
import java.io.IOException;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;

public class BaseaAdactin {
	public static void main(String[] args) throws Exception, IOException {
		BaseClass baseclass=new BaseClass();
		baseclass.launchChrome();
		baseclass.passUrl("https://adactinhotelapp.com/");
		baseclass.maxi();
		
	 WebElement id = baseclass.id("username");
	 String getdata = baseclass.getdata("sheet1", 1, 0);
	 baseclass.sendkeys(id, getdata);

    String getdata2 = baseclass.getdata("sheet1", 1, 1);
WebElement id2 = baseclass.id("password");
		baseclass.sendkeys(id2, getdata2);
		WebElement id3 = baseclass.id("login");
		baseclass.click(id3);
		
		
		WebElement webElement = baseclass.id("location");
		String getdata3 = baseclass.getdata("sheet1", 1, 2);
		baseclass.sendkeys(webElement, getdata3);
		
		
		WebElement webelemen = baseclass.id("hotels");
		String getdata4 = baseclass.getdata("sheet1", 1, 3);
		baseclass.sendkeys(webelemen, getdata4);
		
		
		
		WebElement webeleme = baseclass.id("room_type");
		String getdata5 = baseclass.getdata("sheet1", 1, 4);
		baseclass.sendkeys(webeleme, getdata5);
		
		
baseclass.close();
		
		
		
		
	}

}
