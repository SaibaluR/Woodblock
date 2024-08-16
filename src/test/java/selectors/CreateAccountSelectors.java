package selectors;

import org.openqa.selenium.By;
/**
 * 
 * This function will give the xpath in Create account page
 *
 */
public class CreateAccountSelectors {
	public static final By firstName = By.xpath("//input[@id='firstname']");
	public static final By lastName = By.xpath("//input[@id='lastname']");
	public static final By emailId = By.xpath("//input[@id='email_address']");
	public static final By password = By.xpath("//input[@id='password']");
	public static final By confirmPassword = By.xpath("//input[@id='password-confirmation']");
	public static final By submitBtn = By.xpath("//button[@type='submit'][@title='Create an Account']");
	//public static final By check = By.xpath("//div[@data-ui-id='message-success']");
	public static final By passValidation = By.xpath("//div[@id='password-error']");
	public static final By mailValidation = By.xpath("//div[@id='email_address-error']");
}
