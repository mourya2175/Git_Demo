package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Chrome_Program {
	public WebDriver driver;
  @Test
  public void testChromeLaunch() {
	  //to launch application
	  driver.get("http://www.google.com");
	  
  }
  @BeforeClass
  public void beforeClass() {
	  //to instantiate browser
	  System.setProperty("webdriver.chrome.driver", "C:\\Jars\\chromedriver.exe");
	  driver = new ChromeDriver();
  }

  @AfterClass
  public void afterClass() {
	  //closing browser
	  driver.quit();
  }

}
