package basicTestNGFramework;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestCase3 extends GenericWrappers {
	@Test
	public void testCase3() throws InterruptedException {

		invokeApp("Chrome", "https://demoqa.com/login");
		enterById("userName", "test");
		enterById("password", "Dheeshi3101*");
		clickByXpath("//button[@id='login']");
		Thread.sleep(2000);
		WebElement element = getElementByXpath("//span[contains(text(),'Book Store')]");
		scrollToElement(element);
		Thread.sleep(2000);
		clickByXpath("//span[contains(text(),'Book Store')]");
		enterByXpath("//input[@id='searchBox']", "Designing Evolvable Web APIs with ASP.NET");
		clickByXpath("//a[contains(text(),'Designing Evolvable Web APIs with ASP.NET')]");
		String title = getTextByXpath("//div[@id='title-wrapper']");
		String publisher = getTextByXpath("//div[@id='publisher-wrapper']");
		System.out.println(title);
		System.out.println(publisher);
		WebElement element1 = getElementByXpath("(//button[@id='addNewRecordButton'])[2]");
		scrollToElement(element1);
		clickByXpath("(//button[@id='addNewRecordButton'])[2]");
		driver.switchTo().alert().accept();
		WebElement element2 = getElementByXpath("//span[contains(text(),'Profile')]");
		scrollToElement(element2);
		clickByXpath("//span[contains(text(),'Profile')]");
		clickByXpath("//button[@id='submit']");
		closeBrowser();
		System.out.println("END OF testcase1 FROM TestCase3");

	}

}
