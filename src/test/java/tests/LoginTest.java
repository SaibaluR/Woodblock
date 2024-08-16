package tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import base.Common;
import pages.ForgetPassword;
import pages.LoginPage;

public class LoginTest extends Common {

	@Test(priority = 1)
	public void validLogincheck() {
		LoginPage lp = new LoginPage(driver);
		lp.load().loginWithValidCredentials();
		Assert.assertEquals(lp.checkValidLogin(), "Sign Out");

	}

	@Test(priority = 2)
	public void invalidLogincheck() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.load().loginWithInvalidCredentials();
		Assert.assertEquals(lp.checkInvalidLogin(),
				"The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.");
	}

	@Test(priority = 3)
	public void invalidUsernameLogincheck() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.load().loginWithInvalidUsername();
		Assert.assertEquals(lp.checkInvalidLogin(),
				"The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.");
	}

	@Test(priority = 4)
	public void invalidPasswordLogincheck() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.load().loginWithInvalidPassword();
		Assert.assertEquals(lp.checkInvalidLogin(),
				"The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.");
	}

	@Test(priority = 5)
	public void forgetPasswordCheck() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		ForgetPassword fp = lp.load().forgetpass();
		fp.reset().confirmation();
		Assert.assertTrue(fp.confirmation());
		// System.out.println(fp.confirmation());

	}

}
