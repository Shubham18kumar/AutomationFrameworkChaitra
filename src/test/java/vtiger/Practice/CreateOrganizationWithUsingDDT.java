
	package vtiger.Practice;

	import org.apache.poi.ss.usermodel.Sheet;
	import java.io.FileInputStream;
	import java.time.Duration;
	import java.util.Properties;
	import java.util.Random;

	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.Select;

	import io.github.bonigarcia.wdm.WebDriverManager;
	import vtiger.GenericUtilities.ExcelFileUtility;
	import vtiger.GenericUtilities.JavaUtility;
	import vtiger.GenericUtilities.PropertyFileUtility;
	import vtiger.GenericUtilities.WebDriverUtility;

	public class CreateOrganizationWithUsingDDT {

		public static void main(String[] args) throws Throwable {

			Random r = new Random();
			int random = r.nextInt(1000);

			WebDriver driver = null;

			// Step 1: Read all the Data Required
			// read Data From property file

			FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
			Properties p = new Properties();
			p.load(fisp);
			String BROWSER = p.getProperty("browser");
			String URL = p.getProperty("url");
			String USERNAME = p.getProperty("username");
			String PASSWORD = p.getProperty("password");

//		     Read Data from ExcelFile
			FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
			Workbook wb = WorkbookFactory.create(fise);
			Sheet sh = wb.getSheet("Organizations");
			String ORGNAME = sh.getRow(4).getCell(2).getStringCellValue() + random;
			String INDUSTRY = sh.getRow(4).getCell(3).getStringCellValue();

			// Step 2: Launch the Browser - //Run Time Polymorphism - driver
			if (BROWSER.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (BROWSER.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else if (BROWSER.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			} else {
				System.out.println("Invalid Browser name");
			}

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("http://localhost:8888");
			// steps 2 :login to APPLICATION
			driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_password")).sendKeys("password");
			driver.findElement(By.id("submitButton")).click();

			// Step3: Navigate to Organisation Link
			driver.findElement(By.linkText("Organizations")).click();

			// Step 4: Click On Create Organisations Look Up Image
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

			// Step5: Create Organisation With Mandatory Information
			String OrgName = "Infosys" + random;
			driver.findElement(By.name("accountname")).sendKeys(OrgName);

			// Step 6: Select 'Chemicals' in Industry Dropdown
			WebElement dropdown = driver.findElement(By.name("industry"));
			Select sel = new Select(dropdown);
			sel.selectByValue(INDUSTRY);

			// Step 7: Save
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

			// Step 8: Validate
			String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if (orgHeader.contains(OrgName)) {
				System.out.println("PASS");
				System.out.println(orgHeader);
			} else {
				System.out.println("FAIL");
			}

			// Step 9: LogOut Of App
			WebElement mouseHover = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
			Actions act = new Actions(driver);
			act.moveToElement(mouseHover).perform();
			Thread.sleep(1000);
			driver.findElement(By.linkText("Sign Out")).click();

			// Step 10: Close The Browser
			driver.quit();

		}
	}
}
