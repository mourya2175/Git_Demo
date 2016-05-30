package scripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Dropdown_Count_Test {
	public FirefoxDriver driver;
	@Test
	public void testDropdown_Test() throws InterruptedException {
		//to launch application
		driver.get("http://www.tizag.com/htmlT/htmlselect.php");
		WebElement dd=driver.findElement(By.name("selectionField"));
		List<WebElement> count=dd.findElements(By.tagName("option"));
		System.out.println("Number of values in Dropdown : "+count.size());
		for (int i = 0; i < count.size(); i++) {
			System.out.println("Elements are : "+count.get(i).getText());
			
		}

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
