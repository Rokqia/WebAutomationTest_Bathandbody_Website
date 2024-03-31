package changepasswordtest;

import Pages.ChangePasswordPage;
import Pages.LoginPage;
import basetest.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ChangePasswordTest extends BaseTest{

    @Test
    public void testValidChangePassword(){
        LoginPage loginPage = homePage.LoginButtonClick();
        loginPage.setEmail("rokqyaaraby@gmail");
        loginPage.setPassword("123456_Rokaya");
        loginPage.clickingLoginButton();

        ChangePasswordPage changePasswordPage = homePage.clickChangePassword();
        changePasswordPage.setCurrentPassword("123456_Rokaya");
        changePasswordPage.setNewPassword("123456_Rokqya");
        changePasswordPage.changePassword();
        assertTrue(changePasswordPage.getAlertText().contains("Your password has been changed."));
    }

}
