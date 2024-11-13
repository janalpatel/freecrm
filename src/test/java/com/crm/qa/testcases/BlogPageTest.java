package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.BlogPage;
import com.crm.qa.pages.HomePage;


public class BlogPageTest extends TestBase {
	BlogPage blogpg;
	HomePage homepg;

	public BlogPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		blogpg = new BlogPage();
		homepg = new HomePage();
		blogpg = homepg.clickOnblogLink();

	}

	@Test(priority = 1)
	public void blogageTitleTest() {
		String title = blogpg.verifyblogPageTitle();
		Assert.assertEquals(title, "Blog - Himal Patel Dominion Lending Centres");
	}
	@Test(priority = 2)
	public void searchdata() {
		blogpg.login(prop.getProperty("blogdata"));
	}

	@AfterMethod
	public void tearDownmethod() {
		driver.quit();
	}

}
