
package vtiger.Practice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
public class CreateOrgWithIndustryUsingGU {

	public static void main(String[] args) throws Throwable {
		
		// Create Objects of all Utility Classes
		JavaUtility jUtil = new JavaUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();

		WebDriver driver = null;

		// Step 1: Read all the data required
		// read Data from Property file
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");

		// read data from Excel
		String ORGNAME = eUtil.readDataFromExcel("Organizations", 4, 2) + jUtil.getRandomNumber();
		String INDUSTRYTYPE = eUtil.readDataFromExcel("Organizations", 4, 3);

		// Step 2: Launch the browser //(RunTime polymorphism =driver)
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			WebDriverManager.chromedriver().setup();
			driver = new EdgeDriver();
		} else {
			System.out.println("Invalid Browser name");
		}

		driver.manage().window().maximize();

		wUtil.maximizeWindow(driver);
		wUtil.waitForLoadpage(driver);
		driver.get(URL);

		// Step 2: Login To Application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		// Step 3: Navigate to Organization Link
		driver.findElement(By.linkText("Organizations")).click();

		// Step 4: Click to create Organization LookUp Image
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		// Step 5: Create Organisation with Mandatory Information
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);

		// Step 6: Select Chemicals in Industry dropDown
		WebElement dropDown = driver.findElement(By.name("industry"));
		wUtil.handleDropdown(dropDown, INDUSTRYTYPE);

		// Step 7: Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Step 8: Validate
		String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (OrgHeader.contains(ORGNAME)) {
			System.out.println("PASS");
			System.out.println(OrgHeader);
		} else {
			System.out.println("FAIL");

		}

		// Step 9: Logout the APP
		WebElement MouseHover = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseHoverAction(driver, MouseHover);
		Thread.sleep(1000);
		driver.findElement(By.linkText("Sign Out")).click();

		// Step 10 :close the browser
		driver.quit();

	}
}