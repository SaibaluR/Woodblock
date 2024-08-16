package selectors;

import org.openqa.selenium.By;

/**
 * 
 * This function will give the xpath in Login page
 *
 */
public class LoginSelectors {
	public static final By userName = By.xpath("//input[@name='login[username]']");
	public static final By password = By.xpath("//input[@name='login[password]']");
	public static final By signInBtn = By.xpath("//button[@class='action login primary']");
	public static final By check = By
			.xpath("(//li[@class='link authorization-link']//a[contains(text(),'Sign Out')])[1]");
	public static final By checkInvalid = By.xpath(
			"//div[contains(text(),'The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.')]");
	public static final By forgetPassword = By
			.xpath("//a[@class='action remind']//span[contains(text(),'Forgot Your Password?')]");

	public static final By createAccountBtn = By
			.xpath("//a[@class='action create primary']//span[contains(text(),'Create an Account')]");

}
