package scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Alert_Test {
	public FirefoxDriver driver;
	@Test
	public void testAlert_Test() throws InterruptedException {
		//to launch application
		driver.get("http://www.kesinenitravels.com/Index.aspx");
		driver.findElement(By.id("ctl00_ibtnCheckFare")).click();
		//click on search button
		driver.findElement(By.id("ctl00_cpEndUserMain_ibtnSearch")).click();
		Thread.sleep(2000);
		//get the text on alert
		String amsg=driver.switchTo().alert().getText();
		System.out.println("Alert message : "+amsg);
		//handle alert
		driver.switchTo().alert().accept();
//		driver.switchTo().alert().dismiss(); //to click on NO/Cancel button
		//click on cancellation
		driver.findElement(By.id("ctl00_ibtnCancelTicket")).click();
		System.out.println("This is a change");
	}
	@BeforeClass
	public void beforeClass() {
		//to instantiate browser
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public void afterClass() {
		//closing browser
		driver.quit();
	}

}
