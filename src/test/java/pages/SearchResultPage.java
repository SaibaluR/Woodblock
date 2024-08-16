package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Common;
import selectors.SearchResultPageSelectors;

public class SearchResultPage extends Common {

	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}

	public SearchResultPage load() {
		load("/catalogsearch/result/?q=L-Shaped+Raised+Garden+Bed");
		return this;

	}

	// assertion for search result page
	public String checkSearchResultPage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(SearchResultPageSelectors.checkSearchResult));
		return driver.findElement(SearchResultPageSelectors.checkSearchResult).getText();
	}

	// scroll and select product
	public ProductPage scrollAndSelectProduct() {
		WebElement element = driver.findElement(SearchResultPageSelectors.scroll);
		scroll(element);
		driver.findElement(SearchResultPageSelectors.product).click();

		return new ProductPage(driver);
	}

}
