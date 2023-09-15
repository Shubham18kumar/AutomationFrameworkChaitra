
	package vtiger.ObjectRepository;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class OrganisationInfoPage {
		@FindBy(xpath = "//span[@class='dvHeaderText']")
		private WebElement OrgHeaderText;
		
		public OrganisationInfoPage(WebDriver driver) 
		{ //test script	
			PageFactory.initElements(driver, this);
	      }
		
		public WebElement getOrgHeaderText()
		{
			return  OrgHeaderText;
		}
		
		// Buisness Library
		/**
		 * This method will return the header text
		 * @return
		 */
		
		public String getOrgHeader() {
			return OrgHeaderText.getText();
		}
		
		
		
	}
}
