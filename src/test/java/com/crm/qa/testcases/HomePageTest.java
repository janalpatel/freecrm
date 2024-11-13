package com.crm.qa.testcases;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.BlogPage;
import com.crm.qa.pages.HomePage;

public class HomePageTest extends TestBase {
	HomePage homepg;
	BlogPage blPage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		homepg = new HomePage();

	}

	@Test(priority = 1)
	public void homepageTitleTest() throws IOException {
		String title = homepg.verifyHomePageTitle();
		try {
			Assert.assertEquals(title, "Welcome - Himal Patel Dominion Lending Centres");
			//added 1 here to get the screenshot

		} catch (AssertionError e) {
			takeScreenshotAtEndOfTest("testInvalidLogin");
			throw e;
		}
	}

	public void takeScreenshotAtEndOfTest(String testName) throws IOException {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		System.out.println(currentDir);

		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

	@Test(priority = 2)
	public void logotest() {
		boolean flag = homepg.verifynamelable();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void verifyblogLinkTest() {
		blPage = homepg.clickOnblogLink();
	}

	@AfterMethod
	public void tearDownmethod() {
		driver.quit();
	}
}
