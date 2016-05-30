package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Firefox_Program {
	public WebDriver driver;
  @Test
  public void testFirefoxLaunch() {
	  //to launch application
	  driver.get("http://www.google.com");
	  
  }
  @BeforeClass
  public void beforeClass() {
	  //to instantiate browser
	  driver = new FirefoxDriver();
  }

  @AfterClass
  public void afterClass() {
	  //closing browser
	  driver.quit();
  }

}
