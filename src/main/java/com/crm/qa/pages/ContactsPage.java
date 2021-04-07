package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//div[@class='ui loader']")
	WebElement contactslabel;
	
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifycontactslabeltitle() {
		return contactslabel.getText();
	}
	
	public String contacts_table_heading(String name) {
	    return driver.findElement(By.xpath("//th[contains(text(),'"+name+"')]")).getText();
	}
		
	
}
