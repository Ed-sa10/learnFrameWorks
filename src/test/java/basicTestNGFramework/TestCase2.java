package basicTestNGFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestCase2 extends GenericWrappers {
	@Test
	public void testCase2() throws InterruptedException {
		invokeApp("Chrome", "https://demoqa.com/login");
		enterById("userName", "test");
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,300)");
		enterById("password", "Dheeshi3101*");
		clickById("login");
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Book Store')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(2000);
		clickByXpath("//span[contains(text(),'Book Store')]");
		enterByXpath("//input[@id='searchBox']", "Learning JavaScript Design Patterns");
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,300)");
		clickByXpath("//a[contains(text(),'Learning JavaScript Design Patterns')]");
		String bookTitle = getTextByXpath("//div[@id='title-wrapper']//div[2]//label");
		System.out.println("Book title is " + bookTitle);
		clickByXpath("//button[@id='submit']");
		closeBrowser();
		closeAllBrowsers();
		System.out.println("END OF testcase1 FROM TestCase2");
	}
}
