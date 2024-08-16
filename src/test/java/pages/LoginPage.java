package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Common;
import selectors.LoginSelectors;
import utils.ConfigLoader;

public class LoginPage extends Common {

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	// load page
	public LoginPage load() {
		load("/customer/account/login/");
		return this;
	}

	// Login with valid Credentials
	public LoginPage loginWithValidCredentials() {

		driver.findElement(LoginSelectors.userName).sendKeys(ConfigLoader.getConfigProperty("username"));
		driver.findElement(LoginSelectors.password).sendKeys(ConfigLoader.getConfigProperty("password"));
		driver.findElement(LoginSelectors.signInBtn).click();
		// System.out.println("the text is " + driver.findElement(check).getText());
		return this;

	}

	// Login with invalid Credentials
	public LoginPage loginWithInvalidCredentials() throws InterruptedException {

		driver.findElement(LoginSelectors.userName).sendKeys(ConfigLoader.getConfigProperty("invalidUsername"));
		driver.findElement(LoginSelectors.password).sendKeys(ConfigLoader.getConfigProperty("invalidPassword"));
		driver.findElement(LoginSelectors.signInBtn).click();

		// System.out.println("the text is " +
		// driver.findElement(checkInvalid).getText());
		return this;

	}

	// Login with invalid username
	public LoginPage loginWithInvalidUsername() throws InterruptedException {

		driver.findElement(LoginSelectors.userName).sendKeys(ConfigLoader.getConfigProperty("invalidUsername"));
		driver.findElement(LoginSelectors.password).sendKeys(ConfigLoader.getConfigProperty("password"));
		driver.findElement(LoginSelectors.signInBtn).click();

		return this;

	}

	// Login with invalid password
	public LoginPage loginWithInvalidPassword() throws InterruptedException {

		driver.findElement(LoginSelectors.userName).sendKeys(ConfigLoader.getConfigProperty("username"));
		driver.findElement(LoginSelectors.password).sendKeys(ConfigLoader.getConfigProperty("invalidPassword"));
		driver.findElement(LoginSelectors.signInBtn).click();

		return this;

	}

	// Navigate to create account page
	public CreateAccount navigateFromLoginPageToCreateAccountPage() {
		driver.findElement(LoginSelectors.createAccountBtn).click();
		return new CreateAccount(driver);
	}

	// Forget Password

	public ForgetPassword forgetpass() {
		driver.findElement(LoginSelectors.forgetPassword).click();
		return new ForgetPassword(driver);
	}

	// Assertion for successful login
	public String checkValidLogin()

	{
		// WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LoginSelectors.check));
		return driver.findElement(LoginSelectors.check).getText();

	}

	// Assertion for failed login
	public String checkInvalidLogin()

	{
		// WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LoginSelectors.checkInvalid));
		return driver.findElement(LoginSelectors.checkInvalid).getText();

	}

	// Assertion for Login Page
	public String checkLoginPage() {
		// WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LoginSelectors.userName));
		return driver.getTitle();
	}

}
