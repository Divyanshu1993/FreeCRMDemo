package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	//Page Factory - OR
	@FindBy(xpath="//span[contains(text(), 'Divyanshu Sharma')]")
	WebElement usernameLabel;
	
	@FindBy(xpath="//i[@class='calendar icon']")
	WebElement calendaricon;
	
	@FindBy(xpath="//i[@class='users icon']")
	WebElement contactsicon;
	
	//driver initialization for HomePage class
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions Methods for HomePage class
	public String get_homepage_title() {
		return driver.getTitle();
	}
	
	public String get_label_text() {
		return usernameLabel.getText();
	}
	
	public ContactsPage click_contactspage_link() {
		contactsicon.click();
		return new ContactsPage();
	}

}
