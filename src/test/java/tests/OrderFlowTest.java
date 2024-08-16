package tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import java.io.IOException;

import base.Common;
import objects.BillingAddress;
import pages.CheckOutPage;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchResultPage;
import pages.ShoppingBasketPage;
import utils.JacksonUtils;

public class OrderFlowTest extends Common {

	@Test
	public void orderFlowThroughSearch() throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);
		hp.load().navigateToSearchResultPage();
		SearchResultPage srp = new SearchResultPage(driver);
		srp.scrollAndSelectProduct();

		ProductPage pp = new ProductPage(driver);

		pp.scrollAndSelectProduct();
		ShoppingBasketPage sbp = new ShoppingBasketPage(driver);

		Assert.assertEquals(sbp.checkProductAdded(),
				"You added L-Shaped Raised Garden Bed / 2.625 x 1.125 x 0.75 x 0.35m to your shopping basket.");
				
		Thread.sleep(3000);
		sbp.clickCheckOutBtn();
		Thread.sleep(3000);
		CheckOutPage cp = new CheckOutPage(driver);

		BillingAddress billingaddress = JacksonUtils.deserializeJson("BillingAddress.json", BillingAddress.class);

		cp.setBillingAddress(billingaddress).clickNextBtn().clickCodBtnAndPlaceOrderBtn();
	}

}
