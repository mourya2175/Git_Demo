package scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AssertTrue_ElementPresent_Test {
	public FirefoxDriver driver;
	@Test
	public void testElementPresent_Test() throws InterruptedException {
		//to launch application
	
		driver.get("http://www.rightstart.com/");
		driver.findElement(By.partialLinkText("Email")).click();
		Assert.assertTrue(elePresent(By.name("signup[eMail]")));
		driver.findElement(By.name("signup[eMail]")).sendKeys("Element is present");
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
//this method will return true if the element is available other wise false
	public boolean elePresent(By locator)
	{
		try {
			driver.findElement(locator);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Element is not present");
			return false;
		}
	}

}
