package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class BlogPage extends TestBase {

	@FindBy(xpath = "//h1[contains(text(),'Nothing Found')]")
	WebElement bloglable;

	@FindBy(xpath = "//input[@type='search']")
	WebElement serchspace;

	public BlogPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyblogPageTitle() {
		return driver.getTitle();
	}

	public boolean verifynamelable() {
		return bloglable.isDisplayed();
	}

	public BlogPage login(String searchdata) {
		serchspace.sendKeys(searchdata);
		return new BlogPage();
	}

}
