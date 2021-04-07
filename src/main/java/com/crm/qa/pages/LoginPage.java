package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(xpath="//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[@class='btn btn-sm btn-white btn-icon btn-icon-left btn-shadow btn-border btn-rect offset-sm-top-60 offset-top-30']")
	WebElement signUpBtn;
	
	@FindBy(name="email")
	WebElement emailAddress;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement Login;
	
	@FindBy(xpath="//a[contains(text(), 'Forgot your password?')]")
	WebElement forgotpassword_link;
	
	@FindBy(xpath="//a[contains(text(), 'Sign Up')]")
	WebElement signup_link;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public LoginPage loginBtn_click() {
		loginBtn.click();
		return this;
	}
	
	public HomePage login(String un, String pwd) {
		emailAddress.sendKeys(un);
		password.sendKeys(pwd);
		Login.click();
		return new HomePage();
	}
	

}
