package com.org.booking.booking_com;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public final class Driver {

	private Driver(){
		
	}
	
	//public static WebDriver driver;
	private static ConcurrentHashMap<String, WebDriver> driverThreadMap = new ConcurrentHashMap<String, WebDriver>();
	private static final Map<String, Class<?>> driverMap = new HashMap<String, Class<?>>() {
		{
			put("chrome", ChromeDriver.class);
			put("firefox", FirefoxDriver.class);
		}
	};
	
	private static String getThreadName(){
		return Thread.currentThread().getName() + "-" + Thread.currentThread().getId();
	}
	
	public static void add(String browser, Capabilities capabilities) throws Exception{
		Class<?> driverClass = driverMap.get(browser);
		WebDriver driver = (WebDriver) driverClass.getConstructor(Capabilities.class).newInstance(capabilities);
		String threadName = getThreadName();
		driverThreadMap.put(threadName, driver);
	}
	
	public static WebDriver current(){
		String threadName = getThreadName();
		return driverThreadMap.get(threadName);
	}
	
}
