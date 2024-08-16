package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Common;
import selectors.ProductPageSelectors;

public class ProductPage extends Common {

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}

	public ProductPage load() {
		load("/l-shaped-raised-garden-bed");
		return this;

	}

	public ShoppingBasketPage scrollAndSelectProduct() {
		WebElement element = driver.findElement(ProductPageSelectors.scroll);

		scroll(element);
		wait.until(ExpectedConditions.elementToBeClickable(ProductPageSelectors.addCartBtn));
		driver.findElement(ProductPageSelectors.addCartBtn).click();

		return new ShoppingBasketPage(driver);
	}

}
