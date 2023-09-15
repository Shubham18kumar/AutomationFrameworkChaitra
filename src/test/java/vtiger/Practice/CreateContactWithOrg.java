package vtiger.Practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContactWithOrg {
	


	public static void main(String[] args) throws InterruptedException {
		// Launch The Browser
		WebDriver driver = new EdgeDriver();
		 driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		    driver.get("http://localhost:8888");
		    
		     // steps 2 :login to APPLICATION
		    driver.findElement(By.name("user_name")).sendKeys("admin");
		    driver.findElement(By.name("user_password")).sendKeys("password");
		    driver.findElement(By.id("submitButton")).click();
		    
		    // Step3: Navigate to contacts Link
		    driver.findElement(By.linkText("Contacts")).click();
		    
		    
		    // Step 4: Click On Create contact Look Up Image
		    driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
			   
		   
			// Step5: Create contacts With Mandatory Fields
		    driver.findElement(By.name("lastname")).sendKeys("spiderman");
		    
		    // Step 6: click on organisation look up image
		    driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@title='Select']")).click();
		    
		    //Step 7: switch control to child window
		    String mainWinId = driver.getWindowHandle();
		    
		    Set<String> allWinIds = driver.getWindowHandles();
		    
		    for(String ID:allWinIds){
		    	if(!ID.equals(mainWinId)) 
		    	{
		    		driver.switchTo().window(ID);
		    		System.out.println("window switched to child");
		    	}
		    	
		    }
		    // step 8  search for organisation
		    driver.findElement(By.name("search_text")).sendKeys("ch399");
		    driver.findElement(By.name("search")).click();
		    driver.findElement(By.xpath("//a[.='ch399']")).click();
		    
		    // step 9  switch the control back to main window
		    driver.switchTo().window(mainWinId);
		    System.out.println("window switched to parent");
		    
		    
		    //Step 10: Save
		    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		    
		    
		    //Step 11: Validate
		    String contactHeader = driver.findElement(By.name("lastname")).getText();
		    if( contactHeader.contains("spiderman")) 
		    {
		    	System.out.println("PASS");
		    	System.out.println(contactHeader);
		     }
		    else
		    {
		    	System.out.println("FAIL");
		    }
		    
		    // Step 12: LogOut
		    WebElement mouseHover = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		    Actions act= new Actions(driver);
		    act.moveToElement(mouseHover).perform();
		    Thread.sleep(1000);
		    driver.findElement(By.linkText("Sign Out")).click();
		    System.out.println("logout succesfully");
		    
		    // Step 13: Close The Browser
		      driver.quit();			
	}
}