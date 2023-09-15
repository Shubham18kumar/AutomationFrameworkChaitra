package vtiger.Practice;


	

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class Demo {

		public static void main(String[] args) {

			// Only if webDriver manager is used to download drive executables
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();

			GenericMethodPractice.add(10, 15);
			GenericMethodPractice.add(12,23);
		}
	}

