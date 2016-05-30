package scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetAttribute_Assert {
	public FirefoxDriver driver;
	@Test
	public void testGetAttribute_Assert() throws InterruptedException {
		//to launch application
		driver.get("http://www.rightstart.com/");
		driver.findElement(By.partialLinkText("Email")).click();
		driver.findElement(By.cssSelector("input[name='signup[eMail]']")).sendKeys("nagaraju dasam");
		String typedvalue=driver.findElement(By.cssSelector("input[name='signup[eMail]']")).getAttribute("value");
		System.out.println("Value in text box is : "+typedvalue);
		
		String txtsize=driver.findElement(By.cssSelector("input[name='signup[eMail]']")).getAttribute("size");
		System.out.println("Textbox size : "+txtsize);
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
