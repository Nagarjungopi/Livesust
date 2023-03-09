package com.livesust.stepdefinition;

import org.junit.Assert;
import static org.junit.Assert.*;
import org.openqa.selenium.WebElement;
import com.livesust.engineController.EngineController;
import com.livesust.locators.SignInPage;
import com.livesust.testbase.TestBase;
import com.livesust.utils.TestUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignInPageStep extends TestBase{
	
	SignInPage Signin;
	SignInPage signin = new SignInPage();
	
	@Given("^user is on signin screen$")
	public void userIsOnSigninScreen() throws Throwable {
		EngineController.reportInstance.createStep("Given", "user is on signin screen");
		try {
			//openapp
			Thread.sleep(2000);
			TestUtils.selectBrowser();	
			System.out.println("Livesust Website is launched");
			EngineController.reportInstance.reportStepPass("user is on signin screen");
			
			}catch(Exception e) {
			System.out.println(e);
			EngineController.reportInstance.reportStepFail("user is not able to redirect the signin screen");
			Assert.fail("User not able to launch Livesust Website");
			
		}
		EngineController.tierDown();
	}
	@When("^user enter the values (.*) and (.*)$")
	public void userEnterTheValuesAnd(String email,String password) throws Throwable {
		EngineController.reportInstance.createStep("When", "user enter the values email and password");
		try {
			Thread.sleep(2000);
			clickelement(SignInPage.Email);
			EngineController.reportInstance.reportStepPass("Enter the email: "+email);
			sendKeystoElement(SignInPage.Email,email);
			System.out.println("Email is entered");
			Thread.sleep(2000);
			clickelement(SignInPage.Password);
			EngineController.reportInstance.reportStepPass("Enter the password: "+password);
			sendKeystoElement(SignInPage.Password,password);
			System.out.println("Password is entered");
			clickelement(SignInPage.EyeIcon);
			System.out.println("password is shown");
			clickelement(SignInPage.RememberMe);
			Thread.sleep(1000);
			clickelement(SignInPage.EyeIcon);
			System.out.println("password is hidden");
			EngineController.reportInstance.reportStepPass("user successfully enter username and password");

		}catch(Exception e) {
			System.out.println(e);
			EngineController.reportInstance.reportStepFail("user is not able to enter the username and password");
			Assert.fail("User not able to launch Livesust Website");
		}
		EngineController.tierDown();
	}
	@Then("^user click on login button$")
	public void userClickOnLoginButton() throws Throwable {
		EngineController.reportInstance.createStep("Then", "user click on login button");
		try {
			Thread.sleep(1000);
			clickelement(SignInPage.LogInBtn);
			System.out.println("Clicked signin button");
			EngineController.reportInstance.reportStepPass("Clicked the login button");
			Thread.sleep(3000);
		}catch(Exception e) {
			System.out.println(e);
			EngineController.reportInstance.reportStepFail("user is not able to click the login button");
			Assert.fail("User not able to launch Deelchat application");
		}
		EngineController.tierDown();
	}
	
	
	@And("^assert the error message for unregistered email credential$")
	public void assertTheErrorMessageForUnregisteredEmailCredential() throws Throwable {
		EngineController.reportInstance.createStep("And", "assert the error message for unregistered email credential");
		try {
			WebElement errormsg = getElement(SignInPage.ToastMsg);
			explicitwaitvisible(SignInPage.ToastMsg);
			if(errormsg.isDisplayed()) {
				String validation = errormsg.getText().trim();
			//	String validationText = validation.substring(1).trim();
			//	System.out.println("error message:"+validationText);
				System.out.println("error message:"+SignInPage.InvalidEmailMsg);
				EngineController.reportInstance.reportStepPass("Error Message: "+validation);
				System.out.println("Actual Value: " +validation  + " Expected value: " +SignInPage.InvalidEmailMsg );
				EngineController.reportInstance.reportStepPass("Actual Value: " +validation  + " Expected value: " +SignInPage.InvalidEmailMsg );
				Assert.assertEquals(validation,SignInPage.InvalidEmailMsg);	
			}
		}catch(Exception e) {
			System.out.println(e);
			EngineController.reportInstance.reportStepFail("Unable to assert the unregistered email credential");
			Assert.fail("User not able to launch Livesust Website");
		}
		EngineController.tierDown();
		close();
	}
	
	@And("^assert the error message for without credential$")
	public void assertTheErrorMessageForWithoutCredential() throws Throwable {
		EngineController.reportInstance.createStep("And", "assert the error message for without credential");
		try {
			WebElement errormsg = getElement(SignInPage.ErrorMsg);
			explicitwaitvisible(SignInPage.ErrorMsg);
			if(errormsg.isDisplayed()) {
				String validationText = errormsg.getText().trim();
				System.out.println("error message:"+validationText);
				EngineController.reportInstance.reportStepPass("Error Message: "+validationText);
				System.out.println("Actual Value: " +validationText  + " Expected value: " +SignInPage.EnterEmailMsg );
				EngineController.reportInstance.reportStepPass("Actual Value: " +validationText  + " Expected value: " +SignInPage.EnterEmailMsg );
				Assert.assertEquals(validationText,SignInPage.EnterEmailMsg);	
			}
		}catch(Exception e) {
			System.out.println(e);
			EngineController.reportInstance.reportStepFail("Unable to assert the error message for without credential");
			Assert.fail("User not able to launch Livesust Website");
		}
		EngineController.tierDown();
		close();
	}
	
	@And("^assert the error message for without enter email$")
	public void assertTheErrorMessageForWithoutEnterEmail() throws Throwable {
		EngineController.reportInstance.createStep("And", "assert the error message for without enter email");
		try {
			WebElement errormsg = getElement(SignInPage.ErrorMsg);
			explicitwaitvisible(SignInPage.ErrorMsg);
			if(errormsg.isDisplayed()) {
				String validationText = errormsg.getText().trim();
				System.out.println("error message:"+validationText);
				EngineController.reportInstance.reportStepPass("Error Message: "+validationText);
				System.out.println("error message:"+SignInPage.InvalidUsernameMsg);
				System.out.println("Actual Value: " +validationText  + " Expected value: " +SignInPage.InvalidUsernameMsg);	
				if(validationText.equals(SignInPage.InvalidUsernameMsg)){
				//Assert.assertEquals(validationText, SignInPage.InvalidUsernameMsg);
				Assert.assertTrue(validationText.equals(SignInPage.InvalidUsernameMsg));
				EngineController.reportInstance.reportStepPass("Actual Value: " +validationText  + " Expected value: " +SignInPage.InvalidUsernameMsg);
				}else {
					EngineController.reportInstance.reportStepFail("Unable to assert the error message for without enter email");
					Assert.fail("User not able to launch Livesust Website");
				}
			}
		}catch(Exception e) {
			System.out.println(e);
			EngineController.reportInstance.reportStepFail("Unable to assert the error message for without enter email");
			Assert.fail("User not able to launch Livesust Website");
		}
		EngineController.tierDown();
		close();
	}
	
	@And("^assert the error message for without enter password$")
	public void assertTheErrorMessageForWithoutEnterPassword() throws Throwable {
		EngineController.reportInstance.createStep("And", "assert the error message for without enter password");
		try {
			WebElement errormsg = getElement(SignInPage.ErrorMsg);
			explicitwaitvisible(SignInPage.ErrorMsg);
			if(errormsg.isDisplayed()) {
				String validationText = errormsg.getText().trim();
				System.out.println("error message:"+validationText);
				EngineController.reportInstance.reportStepPass("Error Message: "+validationText);
				System.out.println("Actual Value: " +validationText  + " Expected value: " +SignInPage.EnterPasswordMsg );
				EngineController.reportInstance.reportStepPass("Actual Value: " +validationText  + " Expected value: " +SignInPage.EnterPasswordMsg);
				Assert.assertEquals(validationText,SignInPage.EnterPasswordMsg);
			}
		}catch(Exception e) {
			System.out.println(e);
			EngineController.reportInstance.reportStepFail("Unable to assert the error message for without enter password");
			Assert.fail("User not able to launch Livesust Website");
		}
		EngineController.tierDown();
		close();
	}
	
	
	@And("^assert the error message for invalid email credential$")
	public void assertTheErrorMessageForInvalidEmailCredential() throws Throwable {
		EngineController.reportInstance.createStep("And", "assert the error message for invalid email credential");
		try {
			WebElement errormsg = getElement(SignInPage.ErrorMsg);
			explicitwaitvisible(SignInPage.ErrorMsg);
			if(errormsg.isDisplayed()) {
				String validationText = errormsg.getText().trim();
				System.out.println("error message:"+validationText);
				EngineController.reportInstance.reportStepPass("Error Message: "+validationText);
				System.out.println("Actual Value: " +validationText  + " Expected value: " +SignInPage.WrongFormat);
				EngineController.reportInstance.reportStepPass("Actual Value: " +validationText  + " Expected value: " +SignInPage.WrongFormat);
				Assert.assertEquals(validationText,SignInPage.WrongFormat);
			}
		}catch(Exception e) {
			System.out.println(e);
			EngineController.reportInstance.reportStepFail("Unable to assert the error message for invalid email credential");
			Assert.fail("User not able to logged with invalid email");
		}
		EngineController.tierDown();
		close();
	}

	@And("assert the error message for invalid password credential")
	public void assertTheErrorMessageForInvalidPasswordCredential() throws Throwable {
		EngineController.reportInstance.createStep("And", "assert the error message for invalid password credential");
		try {
			WebElement errormsg = getElement(SignInPage.ToastMsg);
			explicitwaitvisible(SignInPage.ToastMsg);
			if(errormsg.isDisplayed()) {
				String validation = errormsg.getText().trim();
				//String validationText = validation.substring(1).trim();
				//System.out.println("error message:"+validationText);
				EngineController.reportInstance.reportStepPass("Error Message: "+validation);
				System.out.println("Actual Value: " +validation  + " Expected value: " +SignInPage.InvalidPasswordMsg );
				EngineController.reportInstance.reportStepPass("Actual Value: " +validation  + " Expected value: " +SignInPage.InvalidPasswordMsg );
				Assert.assertEquals(validation,SignInPage.InvalidPasswordMsg);
			}
		}catch(Exception e) {
			System.out.println(e);
			EngineController.reportInstance.reportStepFail("Unable to assert the error message for invalid password credential");
			Assert.fail("User not able to logged with invalid password");
		}
		EngineController.tierDown();
		close();
	}
	
	@And("^check the user is successfully logged into app$")
	public void checkTheUserIsSuccessfullyLoggedintoApp() throws Throwable {
		EngineController.reportInstance.createStep("And", "check the user is successfully logged into app");
		try {
			System.out.println("User successfully logged into app");
			Thread.sleep(1000);		
			
			WebElement errormsg = getElement(SignInPage.ToastMsg);
			explicitwaitvisible(SignInPage.ToastMsg);
			if(errormsg.isDisplayed()) {
				String validation = errormsg.getText().trim();
				//String validationText = validation.substring(1).trim();
				//System.out.println("error message:"+validationText);
				EngineController.reportInstance.reportStepPass("Error Message: "+validation);
				System.out.println("Actual Value: " +validation  + " Expected value: " +SignInPage.SuccessMsg );
				EngineController.reportInstance.reportStepPass("Actual Value: " +validation  + " Expected value: " +SignInPage.SuccessMsg);
				Assert.assertEquals(validation,SignInPage.SuccessMsg);
			}
		}catch(Exception e) {
			System.out.println(e);
			EngineController.reportInstance.reportStepFail("User not able to logged into app");
			Assert.fail("User not able to logged into app");
		}
		EngineController.tierDown();
		close();
	}

}
