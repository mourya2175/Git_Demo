package scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Excel_Reading_Test {
	public FirefoxDriver driver;
	 Xls_Reader reader = new Xls_Reader("TestData/data.xlsx");
	@Test
	public void testExcel_Reading_Test() throws InterruptedException {
		//to launch application
		driver.get("http://www.rightstart.com/");
		driver.findElement(By.linkText("Sign In")).click();
		String title=driver.getTitle();
		System.out.println("Title of the page is : "+title);
		Assert.assertEquals(title, "Customer Login - Rightstart.com");
		driver.findElement(By.id("email")).sendKeys(reader.getCellData("Sheet1", "UserName", 2));
		driver.findElement(By.id("pass")).sendKeys(reader.getCellData("Sheet1", "Password", 2));

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
