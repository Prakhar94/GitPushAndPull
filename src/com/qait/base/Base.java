package com.qait.base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qait.PageObjects.CommandCheckin;
import com.qait.PageObjects.Commit;
import com.qait.PageObjects.CreateRepository;
import com.qait.PageObjects.DeleteRepo;
import com.qait.PageObjects.Pull;
import com.qait.PageObjects.Readme;
import com.qait.PageObjects.SignInPage;

public class Base {
	
	public static WebDriver driver;
//	private By signInButton = By.linkText("Sign in");
	
	public Base(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (css=".btn.site-header-actions-btn.mr-2")
	private WebElement signinbtn;
	
	@FindBy (css=".btn.btn-sm.btn-primary")
	private WebElement create;
	
	
	
	public SignInPage clickSignInBtn() throws InterruptedException {
		
		System.out.println("clicking on sign in button");
		Thread.sleep(2000);
		if(signinbtn.isDisplayed()||signinbtn.isEnabled())
			signinbtn.click();
		else System.out.println("Element not found");
		return new SignInPage(driver);
	}
	
	public CreateRepository clickCreateRepository(){
		System.out.println("creating new repository");
		if(create.isDisplayed() || create.isEnabled())
			create.click();
		else System.out.println("Element not found");
		return new CreateRepository(driver);
	}
	
	public CommandCheckin runCommands(){
		System.out.println("running shell commands");
		return new CommandCheckin(driver);
	
	}
	public Commit checkCommit(){
		System.out.println("Validating Commits");
		return new Commit(driver);
	}
	
	public Readme editFile(){
		System.out.println("Editing README.md file");
		return new Readme(driver); 
	}
	
	public Pull pullFile(){
		System.out.println("Pulling files from Git");
		return new Pull(driver);
	}
	
	public DeleteRepo delete(){
		System.out.println("deleting repository");
		return new DeleteRepo(driver);
	}
	
	
	public String getPageTitle(){
		String title = driver.getTitle();
		return title;
	}
	
	public boolean verifyBasePageTitle() {
		String expectedPageTitle="How people build software · GitHub";
		return getPageTitle().contains(expectedPageTitle);
	}

}
