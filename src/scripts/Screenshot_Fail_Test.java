package scripts;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Screenshot_Fail_Test {
	public FirefoxDriver driver;
	@Test
	public void testScreenshot_Fail_Test() throws Exception {
		try {
			//to launch application
			driver.get("http://www.rightstart.com/");
			driver.findElement(By.partialLinkText("Email")).click();
			driver.findElement(By.cssSelector("input[name='signup[eMail]']")).sendKeys("nagaraju dasam");
			String typedvalue=driver.findElement(By.cssSelector("input[name='signup[eMail]']")).getAttribute("value");
			System.out.println("Value in text box is : "+typedvalue);
			String txtsize=driver.findElement(By.cssSelector("input[name='signup[eMail]']123")).getAttribute("size");
			System.out.println("Textbox size : "+txtsize);
		} catch (Exception e) {
			// TODO: handle exception
			//capture screenshot
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			// Now you can do whatever you need to do with it, for example copy somewhere
			FileUtils.copyFile(scrFile, new File("C:\\Jars\\testScreenshot_Fail_Test.jpeg"));
			throw new Exception();
		}
		
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
