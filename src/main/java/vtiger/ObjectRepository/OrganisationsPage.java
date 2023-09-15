package vtiger.ObjectRepository;



	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class OrganisationsPage {
			
			//Declaration
			@FindBy(xpath= "//img[@alt='Create Organization...']")
			private WebElement CreateOrgLookUpImg;
			
			//Initialization
			public OrganisationsPage(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
				
			}
			
			//utilization
			public WebElement getCreateOrgLookUpImg()
			{
				return CreateOrgLookUpImg;
			}
			
			/**
			 * This method will check on create Organisation look up Image
			 */
		    public void clickOnCreateOrgLookUpImage()
		    {
		    	CreateOrgLookUpImg.click();
		}
		    }
}
