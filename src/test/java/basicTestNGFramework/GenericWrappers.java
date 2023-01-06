package basicTestNGFramework;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GenericWrappers extends Reporter implements Wrappers {
	WebDriver driver;
	int i = 1;

	public void invokeApp(String browser, String Url) {

		try {
			//startResult();
			if (browser.equalsIgnoreCase("Chrome")) {
				WebDriverManager.chromedriver().setup();
				// Below is the learners approach, but its recommended to use WebDriverManager
				// System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else {
				WebDriverManager.firefoxdriver().setup();
				// System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				System.setProperty("webdriver.gecko.driver", "C:/Program Files/"+"Mozilla Firefox"+"/firefox.exe");
	
				driver = new FirefoxDriver();
			}
			driver.get(Url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			// Below is deprecated
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			System.out.println("The browser " + browser + " launched successfully.");

		} catch (WebDriverException e) {
			System.out.println("The browser " + browser + " failed to launch." + e);

		} finally {
			takeSnap();
		}
	}

	public void enterById(String idValue, String data) {

		try {
			driver.findElement(By.id(idValue)).clear();
			driver.findElement(By.id(idValue)).sendKeys(data);
			System.out.println("The Text field " + idValue + " is entered with text " + data + " successfully.");
		} catch (NoSuchElementException e) {
			System.out.println("The Text field with attribute as id - " + idValue + " is not found.");
		} finally {
			takeSnap();
		}
	}

	public void enterByName(String idValue, String data) {

		try {
			driver.findElement(By.id(idValue)).clear();
			driver.findElement(By.id(idValue)).sendKeys(data);
			System.out.println("The Text field " + idValue + " is entered with text " + data + " successfully.");
		} catch (NoSuchElementException e) {
			System.out.println("The Text field with attribute as id - " + idValue + " is not found.");
		} finally {
			takeSnap();
		}
	}

	public void enterByXpath(String xpathValue, String data) {
		try {
			driver.findElement(By.xpath(xpathValue)).clear();
			driver.findElement(By.xpath(xpathValue)).sendKeys(data);
			System.out.println("The Text field " + xpathValue + " is entered with text " + data + " successfully.");
		} catch (NoSuchElementException e) {
			System.out.println("The Text field with xpathValue - " + xpathValue + " is not found.");
		} finally {
			takeSnap();
		}
	}

	public void verifyTitle(String title) {
		try {
			String actualTitle = driver.getTitle();
			if (actualTitle.contains(title)) {
				System.out.println("The Expected Title in the browser " + title + " is verified with actual title "
						+ actualTitle + " .");
			} else {
				System.out.println("The Expected Title in the browser " + title + " is not matching with actual title "
						+ actualTitle + " .");
			}
		} catch (WebDriverException e) {
			System.out.println("Browser window has been closed before getting title.");
		} finally {
			takeSnap();
		}

	}

	public void verifyTextById(String id, String text) {
		try {
			// String
			// actualText=driver.findElementById(id).getAttribute("value");
			String actualText = driver.findElement(By.id(id)).getText();
			if (actualText.contains(text))
				System.out.println(
						"The Expected text " + text + " is verified with actual entered text " + actualText + " .");
			else
				System.out.println(
						"The Expected text " + text + " is not matching with actual entered text " + actualText + " .");
		} catch (WebDriverException e) {
			System.out.println("Browser window has been closed before getting text");
		} finally {
			takeSnap();
		}

	}

	public void verifyTextByXpath(String xpath, String text) {
		try {
			String actualText = driver.findElement(By.xpath(xpath)).getText();
			if (actualText.equals(text))
				System.out.println(
						"The Expected text " + text + " is verified with actual entered text " + actualText + " .");
			else
				System.out.println(
						"The Expected text " + text + " is not matching with actual entered text " + actualText + " .");
		} catch (WebDriverException e) {
			System.out.println("Browser window has been closed before getting text");
		} finally {
			takeSnap();
		}

	}

	public void verifyTextContainsByXpath(String xpath, String text) {
		try {
			String actualText = driver.findElement(By.xpath(xpath)).getText();
			if (actualText.contains(text))
				System.out.println(
						"The Expected text " + text + " is verified with actual entered text " + actualText + " .");
			else
				System.out.println(
						"The Expected text " + text + " is not matching with actual entered text " + actualText + " .");
		} catch (WebDriverException e) {
			System.out.println("Browser window has been closed before getting text");
		} finally {
			takeSnap();
		}

	}

	public void clickById(String Id) {

		try {
			driver.findElement(By.id(Id)).click();
			System.out.println("The button or element " + Id + " is clicked successfully.");
		} catch (NoSuchElementException e) {
			System.out.println("The Text field with attribute as id - " + Id + " is not found.");
		} finally {
			takeSnap();
		}

	}

	public void clickByClassName(String classVal) {
		try {
			driver.findElement(By.className(classVal)).click();
			System.out.println("The button or element " + classVal + " is clicked successfully.");
		} catch (NoSuchElementException e) {
			System.out.println("The Text field with attribute as id - " + classVal + " is not found.");
		} finally {
			takeSnap();
		}

	}

	public void clickByName(String name) {
		try {
			driver.findElement(By.name(name)).click();
			System.out.println("The button or element " + name + " is clicked successfully.");
		} catch (NoSuchElementException e) {
			System.out.println("The Text field with attribute as id - " + name + " is not found.");
		} finally {
			takeSnap();
		}

	}

	public void clickByLink(String linkText) {
		try {
			driver.findElement(By.linkText(linkText)).click();
			System.out.println("The button or element " + linkText + " is clicked successfully.");
		} catch (NoSuchElementException e) {
			System.out.println("The Text field with attribute as id - " + linkText + " is not found.");
		} finally {
			takeSnap();
		}

	}

	public void clickByLinkNoSnap(String linkText) {
		try {
			driver.findElement(By.linkText(linkText)).click();
			System.out.println("The button or element " + linkText + " is clicked successfully.");
		} catch (NoSuchElementException e) {
			System.out.println("The Text field with attribute as id - " + linkText + " is not found.");
		}

	}

	public void clickByXpath(String xpathVal) {
		try {
			driver.findElement(By.xpath(xpathVal)).click();
			System.out.println("The button or element " + xpathVal + " is clicked successfully.");
		} catch (NoSuchElementException e) {
			System.out.println("The Text field with attribute as id - " + xpathVal + " is not found.");
		} finally {
			takeSnap();
		}

	}

	public void clickByXpathNoSnap(String xpathVal) {
		try {
			driver.findElement(By.xpath(xpathVal)).click();
			System.out.println("The button or element " + xpathVal + " is clicked successfully.");
		} catch (NoSuchElementException e) {
			System.out.println("The Text field with attribute as id - " + xpathVal + " is not found.");
		}
	}

	public String getTextById(String idVal) {
		try {
			String elementText = driver.findElement(By.id(idVal)).getText();
			return elementText;
		} catch (NoSuchElementException e) {
			System.out.println("The Text field with attribute as id - " + idVal + " is not found.");
			return null;
		} finally {
			takeSnap();
		}
	}

	public String getTextByXpath(String xpathVal) {
		try {
			String elementText = driver.findElement(By.xpath(xpathVal)).getText();
			return elementText;
		} catch (NoSuchElementException e) {
			System.out.println("The Text field with attribute as xpath - " + xpathVal + " is not found.");
			return null;
		} finally {
			takeSnap();
		}

	}

	public void selectVisibileTextById(String id, String value) {

		try {
			WebElement source = driver.findElement(By.id(id));
			Select dropdown = new Select(source);
			dropdown.selectByValue(value);
			System.out.println("The button or element " + value + " is clicked successfully.");

		} catch (NoSuchElementException e) {

			System.out.println("The Text field with attribute as id - " + value + " is not found.");
		} finally {
			takeSnap();
		}

	}

	public void selectIndexById(String id, int value) {
		try {
			WebElement source = driver.findElement(By.id(id));
			Select dropdown = new Select(source);
			dropdown.selectByIndex(value);
			System.out.println("The button or element with index " + value + " is clicked successfully.");

		} catch (NoSuchElementException e) {

			System.out.println("The button or element with index " + value + " is not found.");
		} finally {
			takeSnap();
		}

	}

	public void switchToParentWindow() {
		try {
			Set<String> allWindows = driver.getWindowHandles();

			for (String eachWindow : allWindows) {

				driver.switchTo().window(eachWindow);

				// int m=0;
				// if(m==0)
				break;
			}
			System.out.println("Driver control switched to Parent window successfully");

		} catch (WebDriverException e) {

			System.out.println("No window found");
		} finally {
			takeSnap();
		}

	}

	public void switchToLastWindow() {
		try {
			Set<String> allWindows = driver.getWindowHandles();

			for (String eachWindow : allWindows) {

				driver.switchTo().window(eachWindow);

			}
			System.out.println("Driver control switched to last window successfully");

		} catch (WebDriverException e) {
			System.out.println("No Window found");
		} finally {
			takeSnap();
		}

	}

	public String acceptAlert() {
		String text = null;
		try {
			text = driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();
			System.out.println("Alert has been accepted successfully");
		} catch (NoAlertPresentException e) {

			System.out.println("Alert not found");
		} finally {
			// takeSnap();
		}
		return text;
	}

	public void switchToFrameUsingIdName(String name) {
		try {
			driver.switchTo().frame(name);
			System.out.println("Swtiched to the frame" +name+ "successfully");
		} catch (NoSuchFrameException e) {

			System.out.println("Frame not found");
		} finally {
			// takeSnap();
		}
	}
	
	public long takeSnap() {
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L; 
		try {
			
			FileUtils.copyFile(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE) , new File("./reports/images/"+number+".jpg"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		} catch (WebDriverException e) {
			reportStep("The browser has been closed.", "FAIL");
		} catch (IOException e) {
			reportStep("The snapshot could not be taken", "WARN");
		}
		return (long)number;
	}

	public void closeBrowser() {
		try {
			driver.close();
			System.out.println("Browser window has been closed successfully");
		} catch (WebDriverException e) {
			System.out.println("NO browser window found");
		}

	}

	public void closeAllBrowsers() {
		try {
			driver.quit();
			System.out.println("All Browser windows were closed successfully");
		} catch (WebDriverException e) {
			System.out.println("No Browser Window found");
		}
	}

	public WebElement getElementByXpath(String xpathVal) {
		WebElement element = null;
		try {
			element = driver.findElement(By.xpath(xpathVal));
			System.out.println("Element found successfully");
		} catch (NoSuchElementException e) {

			System.out.println("Element not found");
		} finally {
			 takeSnap();
		}
		return element;
	}
	
	
	public void scrollToElement(WebElement element) {		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);		
	}

	
}