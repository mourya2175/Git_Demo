package scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetText_Assert {
	public FirefoxDriver driver;
	@Test
	public void testGetTitle_Assert() throws InterruptedException {
		//to launch application
		driver.get("http://www.rightstart.com/");
		driver.findElement(By.partialLinkText("Email")).click();
//		driver.findElement(By.linkText("Email Signup")).click();
		String actText=driver.findElement(By.xpath("//div[@class='container']/h1/strong")).getText();
		Assert.assertEquals(actText, "Sign up for Right Start Deals!");

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
