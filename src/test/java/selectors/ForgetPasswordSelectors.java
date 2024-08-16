package selectors;

import org.openqa.selenium.By;

/**
 * 
 * This function will give the xpath in Forget password page
 *
 */
public class ForgetPasswordSelectors {
	public static final By emailId = By.xpath("//input[@id='email_address']");
	public static final By resetBtn = By.xpath("//button[@type='submit']//span[contains(text(),'Reset My Password')]");
	public static final By check = By.xpath("//div[@class='message-success success message']");
	public static final By checkOne = By.xpath("//div[@class='page messages']");

}
