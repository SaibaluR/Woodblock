package selectors;

import org.openqa.selenium.By;
/**
 * 
 * This function will give the xpath in Check out page
 *
 */
public class CheckOutPageSelectors {
	public static final By mailId = By.xpath("(//input[@id='customer-email'])[1]");

	public static final By firstName = By.xpath("(//div[@class='control']//input[@type='text'])[1]");
	public static final By lastName = By.xpath("(//div[@class='control']//input[@type='text'])[2]");
	public static final By streetName = By.xpath("(//div[@class='control']//input[@type='text'])[4]");
	public static final By cityName = By.xpath("(//div[@class='control']//input[@type='text'])[8]");
	public static final By phoneNum = By.xpath("(//div[@class='control _with-tooltip']//input[@type='text'])[1]");
	public static final By nextBtn = By.xpath("//button[@class='button action continue primary']");
	public static final By codBtn = By.xpath("//input[@id='cashondelivery']");
	public static final By placeOrderBtn = By.xpath("(//button[@class='action primary checkout'])[1]");

}
