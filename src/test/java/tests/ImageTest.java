package tests;

import org.testng.annotations.Test;
import base.Common;
import pages.HomePage;
import pages.SearchResultPage;
import utils.ImageUtils;

public class ImageTest extends Common {

	@Test(priority = 1)
	public void imageTestInHomePage() {
		HomePage hp = new HomePage(driver);
		hp.load();
		ImageUtils.image(driver);

	}

	@Test(priority = 2)
	public void imageTestInSearchResultPage() {
		SearchResultPage srp = new SearchResultPage(driver);
		srp.load();
		ImageUtils.image(driver);

	}

}
