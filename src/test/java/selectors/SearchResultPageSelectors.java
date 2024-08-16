package selectors;

import org.openqa.selenium.By;
/**
 * 
 * This function will give the xpath in Search Result page
 *
 */
public class SearchResultPageSelectors {
	public static final By checkSearchResult = By.xpath("//span[@class='base']");
	public static final By scroll = By.xpath("//dl[@class='block']//a[contains(text(),'raised-bed')]");
	public static final By product = By.xpath("//div[@id='product-item-info_1996']");
}
