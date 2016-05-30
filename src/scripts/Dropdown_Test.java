package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Dropdown_Test {
	public FirefoxDriver driver;
	@Test
	public void testDropdown_Test() throws InterruptedException {
		//to launch application
		driver.get("http://www.tizag.com/htmlT/htmlselect.php");
		WebElement dd=driver.findElement(By.name("selectionField"));
		Select s = new Select(dd);
		//select by visible text
		s.selectByVisibleText("Colorado -- CO");
		Thread.sleep(2000);
		//select by Index
		s.selectByIndex(0);
		Thread.sleep(2000);
		//select by value
		s.selectByValue("CN");
		Thread.sleep(5000);

	}
	@BeforeClass
	public void beforeClass() {
		//to instantiate browser
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}

	@AfterClass
	public void afterClass() {
		//closing browser
		driver.quit();
	}

}
