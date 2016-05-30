package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Basic {
	public FirefoxDriver driver;
  @Test
  public void testBasic() {
	  //to launch application
	  driver.get("http://www.rightstart.com");
	  //click a link
	  driver.findElement(By.linkText("Email Signup")).click();
	  	  //type in text box
	  driver.findElement(By.name("signup[eMail]")).sendKeys("nagaraju");
	  //uncheck checkbox
	  driver.findElement(By.id("signup:PrefOnlinePromo")).click();
	  //click on subscribe button
	  driver.findElement(By.xpath("//input[@value='Subscribe to the Right Start Insider!']")).click();
	  
	  
	  
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
