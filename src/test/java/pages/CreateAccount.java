package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Common;
import selectors.CreateAccountSelectors;
import utils.ConfigLoader;

public class CreateAccount extends Common {

	public CreateAccount(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}

	// load page
	public CreateAccount load() {
		load("/customer/account/create/");
		return this;

	}

	// creating account with valid credentials
	public CreateAccount validAccountCreation() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(CreateAccountSelectors.firstName));

		driver.findElement(CreateAccountSelectors.firstName)
				.sendKeys(ConfigLoader.getCreateAccountProperty("firstname"));
		driver.findElement(CreateAccountSelectors.lastName).sendKeys(ConfigLoader.getCreateAccountProperty("lastname"));

		int ran;
		ran = 100 + (int) (Math.random() * ((10000 - 100) + 1));
		driver.findElement(CreateAccountSelectors.emailId).sendKeys(ConfigLoader.getCreateAccountProperty("createMail")
				+ ran + ConfigLoader.getCreateAccountProperty("domain"));
		driver.findElement(CreateAccountSelectors.password).sendKeys(ConfigLoader.getCreateAccountProperty("password"));
		driver.findElement(CreateAccountSelectors.confirmPassword)
				.sendKeys(ConfigLoader.getCreateAccountProperty("password"));
		WebElement element = driver.findElement(CreateAccountSelectors.password);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);

		driver.findElement(CreateAccountSelectors.submitBtn).click();

		return this;
	}

	// Validating the password criteria
	public CreateAccount passValidation() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(CreateAccountSelectors.firstName));

		driver.findElement(CreateAccountSelectors.firstName)
				.sendKeys(ConfigLoader.getCreateAccountProperty("firstname"));
		driver.findElement(CreateAccountSelectors.lastName).sendKeys(ConfigLoader.getCreateAccountProperty("lastname"));

		int ran;
		ran = 100 + (int) (Math.random() * ((10000 - 100) + 1));
		driver.findElement(CreateAccountSelectors.emailId).sendKeys(ConfigLoader.getCreateAccountProperty("createMail")
				+ ran + ConfigLoader.getCreateAccountProperty("domain"));
		driver.findElement(CreateAccountSelectors.password)
				.sendKeys(ConfigLoader.getCreateAccountProperty("invalidPass"));
		driver.findElement(CreateAccountSelectors.confirmPassword)
				.sendKeys(ConfigLoader.getCreateAccountProperty("invalidPass"));
		return this;
	}

	// Validating the mail id criteria
	public CreateAccount mailValidation() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(CreateAccountSelectors.firstName));

		driver.findElement(CreateAccountSelectors.firstName)
				.sendKeys(ConfigLoader.getCreateAccountProperty("firstname"));
		driver.findElement(CreateAccountSelectors.lastName).sendKeys(ConfigLoader.getCreateAccountProperty("lastname"));

		int ran;
		ran = 100 + (int) (Math.random() * ((10000 - 100) + 1));
		driver.findElement(CreateAccountSelectors.emailId)
				.sendKeys(ConfigLoader.getCreateAccountProperty("createMail") + ran);
		driver.findElement(CreateAccountSelectors.password).sendKeys(ConfigLoader.getCreateAccountProperty("password"));
		driver.findElement(CreateAccountSelectors.confirmPassword)
				.sendKeys(ConfigLoader.getCreateAccountProperty("password"));
		WebElement element = driver.findElement(CreateAccountSelectors.password);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);

		driver.findElement(CreateAccountSelectors.submitBtn).click();
		return this;
	}

	// Assertion for mail id validation
	public String validateMailId() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(CreateAccountSelectors.mailValidation));
		return driver.findElement(CreateAccountSelectors.mailValidation).getText();
	}

	// Assertion for invalid password
	public String validatePass() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(CreateAccountSelectors.passValidation));
		return driver.findElement(CreateAccountSelectors.passValidation).getText();
	}

	// Assertion for successful Account creation
	/*
	 * public String checkValidAccountCreation()
	 * 
	 * { wait.until(ExpectedConditions.visibilityOfElementLocated(
	 * CreateAccountSelectors.check)); return
	 * driver.findElement(CreateAccountSelectors.check).getText();
	 * 
	 * }
	 */

	// Assertion for Login Page
	public String checkCreatAccountPage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(CreateAccountSelectors.firstName));
		return driver.getTitle();
	}

}
