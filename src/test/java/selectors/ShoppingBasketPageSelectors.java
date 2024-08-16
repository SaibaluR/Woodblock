package selectors;

import org.openqa.selenium.By;

/**
 * 
 * This function will give the xpath in Shopping Basket page
 *
 */
public class ShoppingBasketPageSelectors {
	public static final By check = By.xpath("//div[@class='message message-success success']");
	public static final By checkOutBtn = By.xpath("//li//button[@class='action primary checkout']");
}
