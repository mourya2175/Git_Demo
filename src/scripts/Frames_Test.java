package scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Frames_Test {
	public FirefoxDriver driver;
	@Test
	public void testFrames_Test() throws InterruptedException {
		//to launch application
		driver.get("http://jqueryui.com/");
		driver.findElement(By.linkText("Autocomplete")).click();
		//switch to frame
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		driver.findElement(By.id("tags")).sendKeys("selenium");
		//come out of the frame
		driver.switchTo().defaultContent();
		driver.findElement(By.linkText("Draggable")).click();
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
