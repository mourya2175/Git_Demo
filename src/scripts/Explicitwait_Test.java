package scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Explicitwait_Test {
	//explicit wait is also called as webdriver wait
	public FirefoxDriver driver;
	@Test
	public void testGetTitle_Assert() throws InterruptedException {
		//to launch application
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.xpath("//div[@id='start']/button")).click();
		String textbeforeExpicitwait=driver.findElement(By.xpath("//div[@id='finish']/h4")).getText();
		System.out.println("Before explicit wait : "+textbeforeExpicitwait);
		
		//explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']/h4")));
		String textAfterExpicitwait=driver.findElement(By.xpath("//div[@id='finish']/h4")).getText();
		System.out.println("After explicit wait : "+textAfterExpicitwait);
		

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
