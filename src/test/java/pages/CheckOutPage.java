package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Common;
import objects.BillingAddress;
import selectors.CheckOutPageSelectors;

public class CheckOutPage extends Common {

	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 120);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	public CheckOutPage mailId(String mail) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(CheckOutPageSelectors.mailId));

		driver.findElement(CheckOutPageSelectors.mailId).sendKeys(mail);
		return this;
	}

	public CheckOutPage firtName(String name) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(CheckOutPageSelectors.firstName));
		driver.findElement(CheckOutPageSelectors.firstName).sendKeys(name);
		return this;
	}

	public CheckOutPage lastName(String name) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(CheckOutPageSelectors.lastName));
		driver.findElement(CheckOutPageSelectors.lastName).sendKeys(name);
		return this;
	}

	public CheckOutPage streetName(String name) {

		driver.findElement(CheckOutPageSelectors.streetName).sendKeys(name);
		return this;
	}

	public CheckOutPage cityName(String name) {

		driver.findElement(CheckOutPageSelectors.cityName).sendKeys(name);
		return this;

	}

	public CheckOutPage phoneNum(String num) {

		driver.findElement(CheckOutPageSelectors.phoneNum).sendKeys(num);
		return this;

	}

	public CheckOutPage setBillingAddress(BillingAddress billingAdress) {

		return

		mailId(billingAdress.getMailId()).firtName(billingAdress.getFirstName()).lastName(billingAdress.getLastName())
				.streetName(billingAdress.getStreetName()).cityName(billingAdress.getCityName())
				.phoneNum(billingAdress.getPhoneNum());

	}

	// click next button
	public CheckOutPage clickNextBtn() {
		driver.findElement(CheckOutPageSelectors.nextBtn).click();
		return this;
	}

	// click Cash on delevery button and final Checkout
	public CheckOutPage clickCodBtnAndPlaceOrderBtn() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(CheckOutPageSelectors.codBtn));
		Thread.sleep(3000);

		driver.findElement(CheckOutPageSelectors.codBtn).click();
		Thread.sleep(3000);
		// wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn));
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(CheckOutPageSelectors.placeOrderBtn));
		driver.findElement(CheckOutPageSelectors.placeOrderBtn).click();
		return this;

	}

}
