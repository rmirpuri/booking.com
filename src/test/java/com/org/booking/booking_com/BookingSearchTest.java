package com.org.booking.booking_com;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(Parameterized.class)
public class BookingSearchTest {

	private WebDriver driver;
	private String destination;
	private boolean isLeisure;
	private int numberOfAdults;

	public BookingSearchTest(String destination, boolean isLeisure,
			int numberOfAdults) {
		super();
		this.destination = destination;
		this.isLeisure = isLeisure;
		this.numberOfAdults = numberOfAdults;
	}

	@Parameters
	public static Collection<Object[]> getParameters() {
		return Arrays.asList(new Object[][] { { "London", true, 2 },
				{ "Manchester", false, 1 } });
	}

	@Before
	public void setUp() throws Exception {
		Configuration.load();
		Configuration.print();
		String baseUrl = Configuration.get("url");

		DesiredCapabilities cap = new DesiredCapabilities();
		Driver.add(Configuration.get("browser"), cap);
		driver = Driver.current();
		driver.get(baseUrl);
	}

	@After
	public void tearDown() {
		driver.quit();

	}

	@Test
	public void testValidSearch() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ss")));

		driver.findElement(By.xpath("(//input[@id='ss' ])[1]")).click();
		driver.findElement(By.xpath("(//input[@id='ss' ])[1]")).clear();
		driver.findElement(By.xpath("(//input[@id='ss' ])[1]")).sendKeys(
				this.destination);
		Thread.sleep(5000);

	}

}
