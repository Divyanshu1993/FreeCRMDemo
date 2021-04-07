package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testutil;
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		testutil = new TestUtil();
		loginPage = new LoginPage();
		homePage = new HomePage();
		loginPage.loginBtn_click();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage=homePage.click_contactspage_link();
		Thread.sleep(5000);
	}
	
	@Test(enabled=false)
	public void verifyContactsTitleTest() {
		String contactstitle = contactsPage.verifycontactslabeltitle();
		Assert.assertEquals(contactstitle, "Contacts");
	}
	
	@Test(priority=1)
	public void verifyContactsTableHeadingTest() {
		String contactsPageHeading = contactsPage.contacts_table_heading("Category");
		Assert.assertEquals(contactsPageHeading, "Category");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
