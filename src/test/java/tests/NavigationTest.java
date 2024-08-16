package tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import base.Common;
import pages.CreateAccount;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchResultPage;

public class NavigationTest extends Common {

	@Test(priority = 1)
	public void navigateFromHomeToLoginPage() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.load();
		//Assert.assertEquals(hp.checkHomePage(), "Beautiful raised beds");
		hp.navigateToLoginPage();
		LoginPage lp = new LoginPage(driver);
		Assert.assertEquals(lp.checkLoginPage(), "Customer Login | WoodBlocX");
	}

	@Test(priority = 2)
	public void navigateFromHomeToCreateAccountPage() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.load();
	//	Assert.assertEquals(hp.checkHomePage(), "Beautiful raised beds");
		hp.navigateToCreateAccountPage();
		CreateAccount ca = new CreateAccount(driver);
		Assert.assertEquals(ca.checkCreatAccountPage(), "Create New Customer Account | WoodBlocX");

	}

	@Test(priority = 3)
	public void navigateFromLoginToCreateAccountPage() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.load().navigateFromLoginPageToCreateAccountPage();
		CreateAccount ca = new CreateAccount(driver);
		Assert.assertEquals(ca.checkCreatAccountPage(), "Create New Customer Account | WoodBlocX");
	}

	@Test(priority = 4)
	public void navigateFromHomeToSearchResultPage() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.load().navigateToSearchResultPage();
		SearchResultPage srp = new SearchResultPage(driver);
		Assert.assertEquals(srp.checkSearchResultPage(), "Search results for: 'L-Shaped Raised Garden Bed'");

	}
}