package vtiger.ObjectRepository;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	import vtiger.GenericUtilities.WebDriverUtility;

	public class CreateNewOrganisationPage  extends WebDriverUtility {
		
			private static final WebElement SaveBtn = null;

			//Declaration
			@FindBy(name = "accountname")
			private WebElement OrgnameEdt;
			
			@FindBy(name= "industry")
			private WebElement IndustrydropDwn;
			
			//Initialization
			public CreateNewOrganisationPage(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
				
			}

			public WebElement getOrgNameEdt()
			{
				return OrgnameEdt;
			}
			
			
			public WebElement getIndustrydropDwn()
			{
				return IndustrydropDwn;
			}
			
			public WebElement getSaveBtn()
			{
			   return SaveBtn;
			}
			
			
			public void createNewOrganisation(String ORGNAME)
			{
				OrgnameEdt.sendKeys(ORGNAME);
				SaveBtn.click();
			}
			
			//Business Library
			
			public void createNewOrganisation(String ORGNAME, String INDUSTRY)
			{
				OrgnameEdt.sendKeys(ORGNAME);
				handleDropdown(IndustrydropDwn, INDUSTRY);
				SaveBtn.click();
			}		
		}
}
