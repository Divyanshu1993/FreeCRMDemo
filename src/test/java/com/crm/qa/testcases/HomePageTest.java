package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	public HomePageTest() {
		super();
	}
	
	//test cases should be independent with each other in POM.
	//before each test case launch the browser and after each test case close the browser.
	//This is the best approach of POM as this removes extra cookies that are saved at
	//execution of every test case.
	//This approach also helps the webdriver to interact with the page objects
	//(i.e. if we are not using approach then there could be a possibility that the elements
	//in the page are not clicked or getting interacted with webdriver.
	//https://www.youtube.com/watch?v=ea0P7MBQmiM&list=PLFGoYjJG_fqq6cHeqfsDes3pdVh3kpl74&index=3 
	// time 34:00 to 35:31
	
	@BeforeMethod
	public void setUp() {
		initialization();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		loginPage.loginBtn_click();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verify_homepage_title() {
		String homePageTitle = homePage.get_homepage_title();
		Assert.assertEquals(homePageTitle, "Cogmento CRM", "Home Page title not matched");
	}
	
	@Test(priority=2)
	public void verify_username_text() {
		String homePage_usertext = homePage.get_label_text();
		Assert.assertEquals(homePage_usertext, "Divyanshu Sharma", "Username text doesn't match with the expected text");
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest() {
		contactsPage = homePage.click_contactspage_link();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
