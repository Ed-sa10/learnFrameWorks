package basicTestNGFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCase1 extends GenericWrappers {

	@Test(priority = 1)
	@Parameters({"uName","pWord"}) // Mapped in order to params
	public void testCase1(String val1, String val2) throws InterruptedException {
		System.out.println("STARTING TEST WITH : "+ val1 + " " + val2);
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/login");
		Thread.sleep(3000);
		// finding the username text box
		WebElement userID = driver.findElement(By.id(val1));
		userID.sendKeys("TEST");
		Thread.sleep(2000);
		// finding the username text box
		WebElement passWord = driver.findElement(By.id(val2));
		passWord.sendKeys("PASSWORD");
		Thread.sleep(2000);
		driver.close();
		System.out.println("END OF testcase1 FROM TestCase1");
	}
	@Test(priority = 2)
	public void testCase2() throws InterruptedException {
		invokeApp("Chrome", "https://demoqa.com/login");
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,300)");
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
		clickByXpath("//a[contains(text(),'Git Pocket Guide')]");
		String bookTitle = getTextByXpath("//div[@id='title-wrapper']//div[2]//label");
		System.out.println("Book title is " + bookTitle);
		clickByXpath("//button[@id='submit']");
		closeBrowser();
		closeAllBrowsers();
		System.out.println("END OF testcase2 FROM TestCase2");
	}
}
