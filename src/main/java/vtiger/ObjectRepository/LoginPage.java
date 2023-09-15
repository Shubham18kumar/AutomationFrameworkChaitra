
	
	package vtiger.ObjectRepository;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class LoginPage {
		// Rule 1 - create a separate pom for every webpage
		// Rule 2  identify the web elements using @FindBy,  @FindAll,  @FindBys
	     // Declaration 
		 @FindBy(name="user_name")
		 private WebElement userNameEdt;
		 
		 @FindBy(name="user_Password")
		 private WebElement passwordEdt;
		 
		 @FindBy(name="submitButton")
		 private WebElement loginBtn;
		 
		 // Rule 3  create a constructor to initialize the web elements 
		 // Intialisation
			public LoginPage(WebDriver driver) {
				PageFactory.initElements(driver, this);	
			}
			
			// Rule4: Provide getters for accessing the web elements 
			//Utilisation
			public WebElement getUserNameEdt() {
				return userNameEdt;
			} 
			
			public WebElement getPasswordEdt() {
				return passwordEdt;
			} 
			
			public WebElement getLoginBtn() {
				return loginBtn;	
			} 
			
	         //Rule 5: Provide 	Buisness library	
			// - is a generic method created using web elements present only in current page
			
			public void loginToApp(String USERNAME , String PASSWORD) throws InterruptedException 
			{
				userNameEdt.sendKeys(USERNAME);
				passwordEdt.sendKeys(PASSWORD);
				loginBtn.click();	
			}
	}

}
