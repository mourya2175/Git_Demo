package scripts;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class Window_Test {
	public FirefoxDriver driver;
	@Test
	public void testWindow_Test() throws InterruptedException {
		//to launch application
		driver.get("http://www.rightstart.com/");
		//handle is unique number assigned to browser windows by webdriver
		String pwin=driver.getWindowHandle();
		System.out.println(pwin);
		driver.findElement(By.linkText("Email Signup")).click();
		//click on our blog to open new window/tab/popup
		driver.findElement(By.linkText("Our Blog")).click();
		//gets the handles of windows opened by webdriver
		Set<String> wins=driver.getWindowHandles();	
		//remove parent window from SET
		wins.remove(pwin);
		//switch to child window
		driver.switchTo().window(wins.iterator().next());
		//assertion
		String titlofChild=driver.getTitle();
		System.out.println(titlofChild);
		Assert.assertEquals(titlofChild, "Right Start Blog - Starting Your Baby Off Right");
		driver.findElement(By.linkText("About")).click();
		//close child window
		driver.close();
		//switch to parent window
		driver.switchTo().window(pwin);
		driver.findElement(By.name("signup[eMail]")).sendKeys("Parent window");
		Thread.sleep(4000);

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
