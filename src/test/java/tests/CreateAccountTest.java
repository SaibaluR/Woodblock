package tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import base.Common;
import pages.CreateAccount;

public class CreateAccountTest extends Common {

	@Test(priority = 1)
	public void createValidUser() {
		CreateAccount ca = new CreateAccount(driver);
		ca.load();
		//validAccountCreation();

	//	Assert.assertEquals(ca.checkValidAccountCreation(), "Thank you for registering with WoodBlocX.");

	}

	@Test(priority = 2)
	public void passwordValidation() {
		CreateAccount ca = new CreateAccount(driver);
		ca.load().passValidation();
		Assert.assertEquals(ca.validatePass(),
				"Minimum length of this field must be equal or greater than 7 symbols. Leading and trailing spaces will be ignored.");

	}

	@Test(priority = 3)
	public void mailValidation() {
		CreateAccount ca = new CreateAccount(driver);
		ca.load().mailValidation();

		Assert.assertEquals(ca.validateMailId(), "Please enter a valid email address (Ex: johndoe@domain.com).");

	}

}
