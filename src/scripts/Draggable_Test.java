package scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Draggable_Test {
	public FirefoxDriver driver;
	@Test
	public void testDraggable_Test() throws InterruptedException {
		//to launch application
		driver.get("http://jqueryui.com/");
		driver.findElement(By.linkText("Draggable")).click();
		//switch to frame
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		WebElement drag=driver.findElement(By.id("draggable"));
		Actions a = new Actions(driver);
		a.dragAndDropBy(drag, 150, 150).perform();
		Thread.sleep(4000);
		
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
