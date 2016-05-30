package scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MouseHover_Test {
	public FirefoxDriver driver;
	@Test
	public void testMouseHover_Test() throws InterruptedException {
		//to launch application
		driver.get("http://www.emirates.com/");
		WebElement mo=driver.findElement(By.xpath("//span[text()='Book']"));
		Actions a = new Actions(driver);
		a.moveToElement(mo).perform();
		driver.findElement(By.xpath("//span[text()='Book a hotel']")).click();
		Thread.sleep(3000);
		
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
