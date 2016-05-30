package scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Navigate_Commands {
	public FirefoxDriver driver;
	@Test
	public void testGetTitle_Assert() throws InterruptedException {
		//to launch application
//		driver.get("http://www.rightstart.com/");
		driver.navigate().to("http://www.rightstart.com/");
		driver.findElement(By.linkText("Sign In")).click();
		String title=driver.getTitle();
		System.out.println("Title of the page is : "+title);
		Assert.assertEquals(title, "Customer Login - Rightstart.com");
		//navigate back
		driver.navigate().back();
		Thread.sleep(2000);
		//navigate forward
		driver.navigate().forward();
		Thread.sleep(2000);
		//refresh page
		driver.navigate().refresh();
		Thread.sleep(2000);

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
