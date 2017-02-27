package com.org.booking.booking_com;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

	private Driver(){
		
	}
	
	public static WebDriver driver;
	private static final Map<String, Class<?>> driverMap = new HashMap<String, Class<?>>() {
		{
			put("chrome", ChromeDriver.class);
			put("firefox", FirefoxDriver.class);
		}
	};
	
	public static void add(String browser) throws Exception{
		Class<?> driverClass = driverMap.get(browser);
		//driver = (WebDriver) driverClass.cast(driver);
		//driver = (WebDriver) driverClass.getConstructor(driverClass).newInstance();
		
		if(browser.contains("chrome")){
			driver = new ChromeDriver();
			System.out.println(driver);
		}
	}
	
	public static WebDriver current(){
		return driver;
	}
	
}
