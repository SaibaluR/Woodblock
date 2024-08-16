package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Common;
import selectors.ShoppingBasketPageSelectors;

public class ShoppingBasketPage extends Common {

	public ShoppingBasketPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 60);
		PageFactory.initElements(driver, this);
	}

	// Assertion for adding product
	public String checkProductAdded() {

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ShoppingBasketPageSelectors.check));
		return driver.findElement(ShoppingBasketPageSelectors.check).getText();

	}

	// Clicking on Checkout button
	public CheckOutPage clickCheckOutBtn() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(ShoppingBasketPageSelectors.checkOutBtn));
		Thread.sleep(3000);
		WebElement element = driver.findElement(ShoppingBasketPageSelectors.checkOutBtn);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);

		return new CheckOutPage(driver);

	}
}
