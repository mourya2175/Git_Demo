package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IE_Program {
	public WebDriver driver;
  @Test
  public void testIELaunch() {
	  //to launch application
	  driver.get("http://www.google.com");
	  
  }
  @BeforeClass
  public void beforeClass() {
	  //to instantiate browser
	  System.setProperty("webdriver.ie.driver", "C:\\Jars\\IEDriverServer.exe");
	  driver = new InternetExplorerDriver();
  }

  @AfterClass
  public void afterClass() {
	  //closing browser
	  driver.quit();
  }

}
