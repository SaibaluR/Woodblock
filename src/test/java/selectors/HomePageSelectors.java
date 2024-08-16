package selectors;

import org.openqa.selenium.By;

/**
 * 
 * This function will give the xpath in Home page
 *
 */
public class HomePageSelectors {
	public static final By checkHomePage = By.xpath("//h2[normalize-space()='Beautiful raised beds']");
	public static final By signInbtn = By
			.xpath("(//li[@class='link authorization-link']//a[contains(text(),'Sign In')])[1]");
	public static final By createAccountBtn = By.xpath("(//li//a[contains(text(),'Create an Account')])[1]");
	public static final By searchBox = By.xpath("//input[@id='search']");

}
