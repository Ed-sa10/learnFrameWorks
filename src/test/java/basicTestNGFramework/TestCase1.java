package basicTestNGFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCase1 extends ProjectTestingUtils {

	@Test(priority = 1)
	@Parameters({"uName","pWord"}) // Mapped in order to params
	public void testCase1(String val1, String val2) throws InterruptedException {

		invokeApp("Chrome", "https://demoqa.com/login");
		startTestCase("Framework Demo", "TestNG Framework with Extent Reports and Generic Wrappers");
	
		reportStepNoSnap("Driver Created", "INFO");		
		reportStepNoSnap( "URL Opened", "INFO");
		Thread.sleep(3000);
		
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,150)");

		WebElement userID = driver.findElement(By.id(val1));
		userID.sendKeys("TEST");
		reportStepNoSnap( "user ID entered", "PASS");

		Thread.sleep(2000);

		WebElement passWord = driver.findElement(By.id(val2));
		passWord.sendKeys("PASSWORD");
		reportStepNoSnap( "user password entered", "PASS");

		reportStep("Login is successful", "PASS");

		Thread.sleep(2000);
		driver.close();

		endTestcase();
	}
	@Test(priority = 2)
	public void testCase2() throws InterruptedException {
		invokeApp("Chrome", "https://demoqa.com/login");
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,150)");
		enterById("userName", "test");
		enterById("", "Dheeshi3101*");
		WebElement loginBtn = driver.findElement(By.id("login"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", loginBtn);
		//clickById("login");
		loginBtn.click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Book Store')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(2000);
		clickByXpath("//span[contains(text(),'Book Store')]");
		enterByXpath("//input[@id='searchBox']", "Git Pocket Guide");
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,150)");
		clickByXpath("//a[contains(text(),'Git Pocket Guide')]");
		String bookTitle = getTextByXpath("//div[@id='title-wrapper']//div[2]//label");
		System.out.println("Book title is " + bookTitle);
		clickByXpath("//button[@id='submit']");
		closeBrowser();
		closeAllBrowsers();
		System.out.println("END OF testcase2 FROM TestCase2");
	}	
}
