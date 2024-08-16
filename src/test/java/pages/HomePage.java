package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Common;
import selectors.HomePageSelectors;

public class HomePage extends Common {

	public HomePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}

	public HomePage load() {
		load("/");
		return this;
	}

	// navigate to login page from HomePage
	public LoginPage navigateToLoginPage() {
		driver.findElement(HomePageSelectors.signInbtn).click();
		return new LoginPage(driver);

	}

	// navigate to login page from HomePage
	public CreateAccount navigateToCreateAccountPage() {
		driver.findElement(HomePageSelectors.createAccountBtn).click();
		return new CreateAccount(driver);

	}

	// navigate to search result page by searching a product
	public SearchResultPage navigateToSearchResultPage() {
		driver.findElement(HomePageSelectors.searchBox).sendKeys("L-Shaped Raised Garden Bed" + Keys.ENTER);
		return new SearchResultPage(driver);

	}

	// assertion for HomePage
	public String checkHomePage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(HomePageSelectors.checkHomePage));
		return driver.findElement(HomePageSelectors.checkHomePage).getText();
	}

}
