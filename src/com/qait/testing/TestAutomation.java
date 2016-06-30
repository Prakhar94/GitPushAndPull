package com.qait.testing;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qait.PageObjects.CommandCheckin;
import com.qait.PageObjects.Commit;
import com.qait.PageObjects.CreateRepository;
import com.qait.PageObjects.DeleteRepo;
import com.qait.PageObjects.Pull;
import com.qait.PageObjects.Readme;
import com.qait.PageObjects.SignInPage;
import com.qait.base.Base;
import com.qait.initialize.Initialiser;

public class TestAutomation extends Initialiser {
	
	private WebDriver driver;
	private SignInPage signInPage;
	private Base basePage;
	private CreateRepository createRepo;
	private CommandCheckin checkin;
	private DeleteRepo dlte;
	private Commit cmmit;
	private Pull pull;
	private Readme read;
	
	@BeforeClass
	public void setUp() {
		driver=getDriver();
	}
	
	@Test
	public void step00VerifyHomePage() {
		System.out.println("Home page test...");
		Base basePage = new Base(driver);
		Assert.assertTrue(basePage.verifyBasePageTitle(), "Home page title doesn't match");
		Reporter.log("ASSERT PASSED : Home page verified successfully",true);
	}
	
	
	@Test
	public void step01VerifySignInFunction() throws InterruptedException {
		System.out.println("Sign In functionality details...");
		basePage = new Base(driver);
		signInPage = basePage.clickSignInBtn();
		Assert.assertTrue(signInPage.verifySignInPageTitle(), "Sign In page title doesn't match");
		Assert.assertTrue(signInPage.verifySignInPageText(), "Page text not matching");
		Reporter.log("ASSERT PASSED : Signin page verified successfully",true);
//		Assert.assertTrue(signInPage.verifySignIn(), "Unable to sign in");
		signInPage.verifySignIn();

	}
	
	@Test
	public void step02VerifyCreateRepository() throws InterruptedException{
		System.out.println("Creating Repository");
		basePage= new Base(driver);
		createRepo= basePage.clickCreateRepository();
		Assert.assertTrue(createRepo.verifyRepoPageTitle(), "Sign In page title doesn't match");
		createRepo.CreateAnewRepo();
		Reporter.log("ASSERT PASSED : Repository Page verified successfully",true);
	}
	
	@Test
	public void step03VerifyShellCommand() throws IOException{
		basePage= new Base(driver);
		checkin=basePage.runCommands();
		checkin.runCommand();
		
	}
	
	@Test
	public void step04VerifyCommits() throws InterruptedException{
		basePage=new Base(driver);
		cmmit=basePage.checkCommit();
		cmmit.commitUI();
		Assert.assertTrue(cmmit.verifyCommit(), "Commits are not same.");
		Reporter.log("ASSERT PASSED : Commits verified successfully",true);
	}
	
	
	@Test
	public void step06VerifyEdit() throws IOException, InterruptedException{
		basePage = new Base(driver);
		read=basePage.editFile();
		read.edit();
		pull=basePage.pullFile();
		pull.pull();
		Assert.assertTrue(read.verifyReadme(), "Readme Text doesnot match");
		Reporter.log("ASSERT PASSED : Readme File edit verified successfully",true);
				
	}
	
	@AfterClass
	public void step10Deletion() throws InterruptedException, IOException{
		basePage= new Base(driver);
		dlte=basePage.delete();
		dlte.deleteRepo();
		
	}
	

	

	
	

}
