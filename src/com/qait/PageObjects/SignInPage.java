package com.qait.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	
	WebDriver driver;

	public SignInPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy (className="auth-form-header")
	private WebElement headerPageText;
	
	@FindBy (css=".btn.site-header-actions-btn.mr-2")
	private WebElement signin;
	
	@FindBy(id="login_field")
	private WebElement username;	
	
	@FindBy (id="password")
	private WebElement passwrd;
	
	@FindBy (css=".btn.btn-primary.btn-block")
	private WebElement signinbtn;
	
	@FindBy (css=".flash .container")
	private WebElement errorMsgTxt;
	
		
		
		public String getSignInPageTitle() {
			String pageTitle = driver.getTitle();
			return pageTitle;
		}
		
		public boolean verifySignInPageTitle() {
			String expectedTitle = "Sign in to GitHub · GitHub";
			return getSignInPageTitle().contains(expectedTitle);
		}
		
		public boolean verifySignInPageText() {
			
			String pageText = headerPageText.getText();
			String expectedPageText = "Sign in to GitHub";
			return pageText.contains(expectedPageText);
		}

			
			public void verifySignIn() throws InterruptedException {
				
				enterUserName("Prakhar94");
				enterPassword("Prakhar_47");
				Thread.sleep(2000);
				clickOnSignIn();
//				return getErrorMessage().contains("Incorrect username or password.");
			}
			
			public void enterUserName(String userName) {
				
				if(username.isDisplayed())
					username.sendKeys(userName);
			}
			
			public void enterPassword(String password) {
				
				if(passwrd.isDisplayed())
					passwrd.sendKeys(password);
			}
			
			public void clickOnSignIn() {
				if(signinbtn.isDisplayed())
					signinbtn.click();
			}
			
			public String getErrorMessage() {
				String strErrorMsg = null;
				if(errorMsgTxt.isDisplayed()&&errorMsgTxt.isEnabled())
				{
					strErrorMsg = errorMsgTxt.getText();
					System.out.println("Inside if "+strErrorMsg);
				}
				System.out.println(strErrorMsg);
				return strErrorMsg;
			}

}
