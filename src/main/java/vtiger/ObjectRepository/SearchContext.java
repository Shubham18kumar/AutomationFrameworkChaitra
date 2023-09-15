package vtiger.ObjectRepository;


         
	package vtiger.ObjectRepository;

	import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;

	public interface SearchContext {
			
			/**
			 * Find all elements within the current context using the given mechanism
			 * @param by the locating mechanism to use
			 * @return A list of all {@link WebElement}s, on an empty list if nothing matches
			 * @
			 */
			List<WebElement> findElements(By by);
			
			/**
			 * Find the first {@link WebElement} using the given method.
			 * 
			 * @param by the locating mechanism
			 * @return
			 * @throws NosuchElementsException if no matching elements are found
			 */
			WebElement findElement(By by);

		}
}
