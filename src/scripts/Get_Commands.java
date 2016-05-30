package scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Get_Commands {
	public FirefoxDriver driver;
	@Test
	public void testGetTitle_Assert() throws InterruptedException {
		//to launch application
		driver.get("http://www.rightstart.com/");
		driver.findElement(By.partialLinkText("Email")).click();
		String url=driver.getCurrentUrl();
		System.out.println("URL is : "+url);

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
