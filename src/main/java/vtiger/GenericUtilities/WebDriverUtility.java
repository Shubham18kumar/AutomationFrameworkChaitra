package vtiger.GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class consist of re usable methods related to webDriver
 * @author ShubhamKashyap
 */

public class WebDriverUtility {
	
		/**
		 * This method will maximize the window
		 * @param driver
		 */
		
		public void maximizeWindow(WebDriver driver)
		{
			driver.manage().window().maximize();
		}
		
		/**
		 * This method will minimize the window
		 * @param driver
		 */
		public void minimizewindow(WebDriver driver)
		{
			driver.manage().window().minimize();
		}
		
		/**
		 * This method will open the window in fullScreen
		 * @param driver
		 */
		public void fullScreenWindow(WebDriver driver)
		{
		driver.manage().window().fullscreen();
		}
		
		/**
		 * This method will wait for 10 seconds for particular element to be clickable
		 * @param driver
		 * @param element
		 */
		public void waitForElementToBeClickable(WebDriver driver, WebElement element)
		{
			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(0));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		
		/**
		 * This method will handle dropdown using index
		 * @param element
		 * @param index
		 */
		public void handleDropdown(WebElement element, int index)
		{
			Select s= new Select(element);
			s.selectByIndex(index);
		}
		
		/**
		 * This method will handle dropdown using value
		 * @param element
		 * @param index
		 */
		public void handleDropdown(WebElement element, String value)
		{
			Select s= new Select(element);
			s.selectByValue(value);
		}
		
		/**
		 * This method will handle dropdown using visibleText
		 * @param text
		 * @param element
		 */
		public void handleDropdown(String text,WebElement element)
		{
			Select s= new Select(element);
			s.selectByVisibleText(text);;
		}
		
		/**
		 * This method will perform mouse hover action on a wer Element
		 * @param driver
		 * @param element
		 */
		
		public void mouseHoverAction(WebDriver driver, WebElement element)
		{
			Actions act=new Actions(driver);
			act.moveToElement(element).perform();
		}
		
		/**
		 * This method will perform rightclick anywhere on the webPage
		 * @param driver
		 */
		public void rightClickAction(WebDriver driver)
		{
			Actions act=new Actions(driver);
			act.contextClick().perform();
		}
		
		/**
		 * This method will perform rightclick anywhere on the webElement
		 * @param driver
		 * @param element
		 */
		public void rightClickAction(WebDriver driver, WebElement element)
		{
			Actions act=new Actions(driver);
			act.contextClick(element).perform();
		}
		
		/**
		 * This method will perform rightclick anywhere on the webpage
		 * @param driver
		 */
		public void doubleClickAction(WebDriver driver)
		{
			Actions act=new Actions(driver);
			act.doubleClick().perform();
		}
		
		/**
		 * This method will perform doubleclick anywhere on the webElement
		 * @param driver
		 * @param element
		 */
		public void doubleClickAction(WebDriver driver, WebElement element)
		{
			Actions act=new Actions(driver);
			act.doubleClick(element).perform();
		}
		
		
		public void dragAndDropAction(WebDriver driver, WebElement src, WebElement trg)
		{
			Actions act=new Actions(driver);
			act.dragAndDrop(src, trg).perform();
		}
		
		
		public void MoveTocursorAndClick(WebDriver driver, int x, int y)
		{
			Actions act=new Actions(driver);
			act.moveByOffset(x, y).click().perform();
		}
		
		/**
		 * This method will scroll down by 500units
		 * @param driver
		 */
		public void scrollAction(WebDriver driver)
		{
			JavascriptExecutor jse= (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,500);", "");
		}
		
		/**
		 * This method will Scroll down until a particular WebElement
		 * @param driver
		 * @param element
		 */
		public void scrollAction(WebDriver driver, WebElement element)
		{
			JavascriptExecutor jse= (JavascriptExecutor)driver;
			jse.executeScript("arguments;", "");
		}
		
		/**
		 * This method will accept the alert popup
		 * @param driver
		 */
		public void acceptAlert(WebDriver driver)
		{
			driver.switchTo().alert().accept();
		}
		
		/**
		 * This method will cancel the alert popup
		 * @param driver
		 */
		public void dismissAlert(WebDriver driver)
		{
			driver.switchTo().alert().dismiss();
		}
		
		/**
		 * This method will get the alert text and return it to caller
		 * @param driver
		 * @return
		 */
		public String getAlertText(WebDriver driver)
		{
			return driver.switchTo().alert().getText();
		}
		
		/**
		 * This method will handle frame using index
		 * @param driver
		 * @param index
		 */
		public void handleFrame(WebDriver driver, int index)
		{
			driver.switchTo().frame(index);
		}
		
		/**
		 * This method will handle frame using nameID
		 * @param driver
		 * @param nameID
		 */
		public void handleFrame(WebDriver driver, String nameID)
		{
			driver.switchTo().frame(nameID);
		}
		
		/**
		 * This method will handle frame using Element
		 * @param driver
		 * @param element
		 */
		public void handleFrame(WebDriver driver, WebElement element)
		{
			driver.switchTo().frame(element);
		}
		
		/**
		 * This method will Sitch to Immediate parent frame
		 * @param driver
		 */
		public void SwitchToParant(WebDriver driver)
		{
			driver.switchTo().parentFrame();
		}
		
		/**
		 * This method will Sitch to default parent frame
		 * @param driver
		 */
		public void SwitchToDefaultContent(WebDriver driver)
		{
			driver.switchTo().defaultContent();
		}
		
		public void SwitchToWindow(WebDriver driver, String partialWindowTitle)
		{
			// Step 1: Capture all the window IDs
			Set<String> allwinIDs = driver.getWindowHandles();
			
			// Step 2: Navigate through Each Window
			for(String id:allwinIDs)
			{		
			    // Step 3: Swithch to each and compare the title
	             String actTitle= driver.switchTo().window(id).getTitle();   		
			
			// Step 4: Compare the title with required
			   if(actTitle.contains(partialWindowTitle))
			   {
				   break;
			   }
		}

	}
		/**
		 * This method is used to take screenshot and store in required folder
		 * @param driver
		 * @param screenshotName
		 * @return Path
		 * @throws IOException 
		 * @throws Throwable
		 */
		 public String CaptureScreenShot(WebDriver driver, String screenshotName) throws IOException  
		 {
			 TakesScreenshot ts=(TakesScreenshot)driver;
			 File src=ts.getScreenshotAs(OutputType.FILE);
			 File dst = new File(".\\ScreenShots\\"+screenshotName+".png");
			 Files.copy(src, dst);
			 return dst.getAbsolutePath(); //used for extent reporting
			 
		 }

		 /**
		  * This method will wait to load webElement for 10Second
		  * @param driver
		  */
		public void waitForLoadpage(WebDriver driver)
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		
		/**
		 * This method will wait for 10Seconds for particular Element to be visible
		 * @param driver
		 * @param element
		 */
		public void waitForElementTobeVisible(WebDriver driver, WebElement element)
		{
			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		
		/**
		 * This method will wait for 10Seconds for particular Element to be Clickable
		 * @param driver
		 * @param element
		 */
		public void waitForElementTobeClickable(WebDriver driver, WebElement element)
		{
			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		
	}