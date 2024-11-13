package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	@FindBy(xpath = "//h2[contains(text(),'Himal Patel')]")
	@CacheLookup
	WebElement namelable;

	@FindBy(xpath = "//a[contains(text(),'Blog')]")
	WebElement blog;
	
	@FindBy(xpath = "//a[contains(text(),'Contact')]")
	WebElement contact;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public boolean verifynamelable() {
		return namelable.isDisplayed();
	}

	public BlogPage clickOnblogLink() {
		blog.click();
		return new BlogPage();
	}

	public ContactPage clickoncontact() {
		contact.click();
		return new ContactPage();
	}
}
