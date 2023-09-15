
package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

	public class HomePage extends WebDriverUtility{
		//Declaration - dropdowns,frames,windows,textfields,popups
		@FindBy(linkText = "Organisations")
		private WebElement organisationLnk;
		
		@FindBy(linkText = "Contacts")
		private WebElement contactsLnk;
		
		@FindBy(linkText = "Products")
		private WebElement productsLnk;
		
		@FindBy(xpath ="//img[@src='themes/softed/images/user.PNG']")
		private WebElement administatorImg;
		
		@FindBy(linkText = "Sign Out")
		private WebElement signoutLnk;
		
		// INITILISATION
		public HomePage(WebDriver driver) {
			PageFactory.initElements(driver, this);	
		}
		
		//Utilisation
		public WebElement getOrganisationLnk() {
			return organisationLnk;
		} 
		
		public WebElement getContactLnk() {
			return contactsLnk;		
		} 
		
		
		public WebElement getProductLnk() {
			return productsLnk;	
		} 
		
		
		public WebElement getAdministratorImg() {
			return getAdministratorImg();	
		} 
		
		public WebElement getSignOutLnk() {
			return signoutLnk;	
		} 
		
		//Buisness library
		/**
		 *  This method will logout of application
		 * @param driver
		 * @throws InterruptedException 
		 * @throws InterrruptedException
		 */
		public void logoutOfApp(WebDriver driver) throws InterruptedException {
			mouseHoverAction(driver, getAdministratorImg());
			Thread.sleep(1000);
			signoutLnk.click();	
		}
		
		/**
		 * This method will click on organistaions link
		 */
		public void clickOnOrganisationLink() {
			organisationLnk.click();
		}
		
		/**
		 * This method will click on contacts link
		 */
		
		public void clickOncontactLink() {
			contactsLnk.click();
		}		
	}
}
