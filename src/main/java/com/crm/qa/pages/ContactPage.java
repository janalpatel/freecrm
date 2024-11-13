package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactPage extends TestBase {

	@FindBy(xpath = "//h2[contains(text(),'Contact Information')]")
	WebElement contactlable;
	
	@FindBy(id = "input_7_22" )
	WebElement firstname;

	@FindBy(id = "input_7_23" )
	WebElement Lastname;
	
	@FindBy(id = "input_7_2" )
	WebElement emailid;
	
	@FindBy(id = "input_7_17" )
	WebElement subject;
	
	@FindBy(id = "input_7_9" )
	WebElement message;
	
	public ContactPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyblogPageTitle() {
		return driver.getTitle();
	}

	public boolean verifynamelable() {
		return contactlable.isDisplayed();
	}
	public void createnewcontact(String fname,String lname,String email,String subj,String msg) {
		firstname.sendKeys(fname);
		Lastname.sendKeys(lname);
		emailid.sendKeys(email);
		subject.sendKeys(subj);
		message.sendKeys(msg);		
	}
	
}
