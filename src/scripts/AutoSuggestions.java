package scripts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AutoSuggestions {
	public FirefoxDriver driver;
	@Test
	public void testAutoSuggestions() throws InterruptedException {
		//to launch application
		driver.get("http://www.bing.com/");
		driver.findElement(By.id("sb_form_q")).sendKeys("selenium");
		List<WebElement> sug=driver.findElements(By.xpath("//ul[@id='sa_ul']/li"));
		System.out.println("Number of suggestions are : "+sug.size());
		for (int i = 0; i < sug.size(); i++) {
			
			System.out.println("Suggestions are : "+sug.get(i).getText());
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
