package scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Keys_Test {
	public FirefoxDriver driver;
	@Test
	public void testKeys_Test() throws InterruptedException {
		//to launch application
		driver.get("http://www.rightstart.com/");
		driver.findElement(By.id("search")).sendKeys("toys");
		Actions a = new Actions(driver);
		a.sendKeys(Keys.ENTER).perform();
		Thread.sleep(6000);
		a.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(2000);
		a.sendKeys(Keys.PAGE_UP).perform();
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
