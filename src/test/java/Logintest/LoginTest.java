package Logintest;

import Pages.EmailVerificationRequiredPage;
import Pages.ForgetPasswordPage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import basetest.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.*;

public class LoginTest extends BaseTest{

    SoftAssert softassert = new SoftAssert();
    @Test(priority = 1)
    public void testSuccessfulLogin(){
        LoginPage loginPage = homePage.LoginButtonClick();
        loginPage.setEmail("rahmahussien7338715@gmail.com");
        loginPage.setPassword("123456_Rokaya");
        loginPage.clickShowPassword();
        MyAccountPage accountPage = loginPage.clickingLoginButton();
        assertTrue(accountPage.getAccountText().contains("My Account"), "Text is incorrect");
    }

   @Test
    public void testForgertPasswordFunctionality(){
        LoginPage loginPage = homePage.LoginButtonClick();
        loginPage.setEmail("Rokayaaraby9@gmail.com");
        ForgetPasswordPage forgetpasswordpage = loginPage.clickForgetPassword();

        forgetpasswordpage.resetPasswordMail("Rokayaaraby9@gmail.com");
        forgetpasswordpage.clickSubmitButton();

        assertTrue(forgetpasswordpage.getAlertMessage()
                        .contains("If your account is valid, an email will be sent with instructions to reset your password."),
                "Alert Message is Incorrect");
    }

    @Test
    public void testInvalidEmptyLogin(){
        LoginPage loginPage = homePage.LoginButtonClick();

        loginPage.clickingLoginButton();

        String emailAlert = loginPage.getEmailFieldAlert();
        String passwordAlert = loginPage.getPasswordFieldAlert();

        softassert.assertTrue(emailAlert.contains("Email field is required."), "Wrong Error Message");
        softassert.assertTrue(passwordAlert.contains("Password field is required."));
    }

    @Test
    public void testInvalidEmail(){
        LoginPage loginPage = homePage.LoginButtonClick();
        loginPage.setEmail("rokayaaraby9@gmail.c");
        loginPage.setPassword("123456");
        loginPage.clickingLoginButton();

        String textAlert = loginPage.getInvalidMailAlert();
        assertTrue(textAlert.contains("The email address rokayaaraby9@gmail.c is not valid."), "Wrong Error Message");
    }

    @Test
    public void testInvalidPassword(){
        LoginPage loginPage = homePage.LoginButtonClick();
        loginPage.setEmail("Rokayaaraby9@gmail.com");
        loginPage.setPassword("12345");
        loginPage.clickingLoginButton();

        String textAlert = loginPage.getInvalidMailAlert();

        softassert.assertEquals(textAlert, "Incorrect Password", "Wrong Error Message");
    }


}
