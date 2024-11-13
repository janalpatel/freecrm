package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.utilities.TestUtill;

public class ContactsPageTest extends TestBase {
	ContactPage cntpage;
	HomePage homepg;
	String sheetname = "contact";

	@BeforeMethod
	public void setup() {
		initialization();
		cntpage = new ContactPage();
		homepg = new HomePage();
		cntpage = homepg.clickoncontact();

	}

	// @Test(priority = 1)
	public void blogageTitleTest() {
		String title = cntpage.verifyblogPageTitle();
		Assert.assertEquals(title, "Contact - Himal Patel Dominion Lending Centres");
	}

	// @Test(priority = 2)
	public void contactlable() {
		boolean flag = cntpage.verifynamelable();
		Assert.assertTrue(flag);
	}

	@Test(dataProvider = "gettestdataformxl")
	public void validatenewcontact(String fname, String lname, String email, String subj, String msg) {
		// homepg.clickoncontact();
		// cntpage.createnewcontact("janu", "himal", "123@gmail", "hello", "sir");
		cntpage.createnewcontact(fname, lname, email, subj, msg);
	}

	@DataProvider
	public Object[][] gettestdataformxl() {
		Object data[][] = TestUtill.gettestdata(sheetname);
		return data;
	}

	@AfterMethod
	public void tearDownmethod() {
		driver.quit();
	}
}
