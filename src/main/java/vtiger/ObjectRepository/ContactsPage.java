package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	// declaration
	@FindBy(xpath = "//img@title='Create Contact...']")
	private WebElement CreateContactLookUpImg;

	// intialisation
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilisation
	public WebElement getCreateContactLookUpImg() {
		return CreateContactLookUpImg;
	}

	// Buisness Library
	/**
	     *  This method will click on create page look up image
	     */
	   public void clickContactCreateContactLookUpImg()
	    {
	         CreateContactLookUpImg.click();	
	    }    
}

}