package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Common;
import selectors.ForgetPasswordSelectors;
import utils.ConfigLoader;

public class ForgetPassword extends Common {

	public ForgetPassword(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}

	// reseting password
	public ForgetPassword reset() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ForgetPasswordSelectors.emailId));

		driver.findElement(ForgetPasswordSelectors.emailId).sendKeys(ConfigLoader.getConfigProperty("username"));
		driver.findElement(ForgetPasswordSelectors.resetBtn).click();
		return this;

	}

	// confirmation message
	public Boolean confirmation() throws InterruptedException {
		Thread.sleep(2000);

		Boolean check = driver.findElement(ForgetPasswordSelectors.checkOne).isEnabled();
		// wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(check));
		// return driver.findElement(ForgetPasswordSelectors.check).getText();
		return check;

	}
}
