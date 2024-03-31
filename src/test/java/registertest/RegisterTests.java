package registertest;

import Pages.*;
import basetest.BaseTest;
import org.jetbrains.annotations.NotNull;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.*;

public class RegisterTests extends BaseTest {

    SoftAssert softassert = new SoftAssert();
    RegisterPage registerpage;

    @Test(priority = 1)
    public void testSuccessfulRegister() {
        registerpage = homePage.registerButtonClick();
        registerpage.setFullName("Rokaya Araby");
        registerpage.setEmailAddress("asmahussein128@gmail.com");
        registerpage.setPassword("123456_Rokaya");
        registerpage.clickNotRobotButton();
        EmailVerificationRequiredPage emailVerifPage = registerpage.registerClickinButton();
        assertTrue(emailVerifPage.getAlertText().contains("A welcome message with further instructions has been sent to your email address."), "Alert text is incorrect");
    }

    @Test(priority = 2)
    public void testInvalidEmptyRegisteration() {
        registerpage = homePage.registerButtonClick();
        registerpage.clickregisterButton();
        String fullNameAlert = registerpage.getEmptyNameAlert();
        String emailAlert = registerpage.getEmptyEmailAlert();
        String passwordAlert = registerpage.getpasswordAlert();

        assertTrue(fullNameAlert.contains("Full Name field is required."),
                "The Full Name Error message is Wrong");
        assertTrue(emailAlert.contains("Email address field is required."),
                "The Email Error message is Wrong");
        assertTrue(passwordAlert.contains("Password field is required."),
                "The Password Error message is Wrong");
       // assertTrue(reCAPTCHAAlert.contains("Verification expired. Check the checkbox again."),"The reCAPTCHA Error message is Wrong");

    }

    @DataProvider(name = "fullNameData")
    public static Object[][] namedata() {
        return new Object[][]{
                {"Rokaya", "Please enter your full name."},
                {"1234","Numbers are not allowed"},
                {"Rokaya123", "Please enter a valid Full Name with no numbers."},
                {"Rokaya__", "Please enter a valid Full Name with no special characters."}
        };
    }
    @Test(dataProvider = "fullNameData", priority = 3)
    public void testInvalidFullName(String name, String errorMessage){
        String fullNameAlert;
        registerpage = homePage.registerButtonClick();
        registerpage.setFullName(name);
        registerpage.setEmailAddress("mahmoudaraby346@gmail.com");
        registerpage.setPassword("123456_Rokaya");

        registerpage.clickregisterButton();
        if(name.equals("Rokaya__"))
        {
            fullNameAlert = registerpage.getNameSpecialCharacterAlert();
        }else {
            fullNameAlert = registerpage.getNameAlert();}

        assertEquals(fullNameAlert,errorMessage, "Wrong Error Message");
    }


    @DataProvider(name = "emailData")
    public static Object[][] emaidata() {
        return new Object[][]{
                {"rokayaaraby9@", "Email address does not contain a valid email."},
                {"metomaw262@ikumaru.com", "The email address metomaw262@ikumaru.com is not valid."},
                {"rokayaaraby9@li.com", "Email address does not contain a valid email."}
        };
    }
    @Test(dataProvider = "emailData", priority = 4)
    public void testInvalidEmail(String email, String errorMessage) {
        String emailAlert;
        registerpage = homePage.registerButtonClick();
        registerpage.setFullName("Rokqya Araby");
        registerpage.setEmailAddress(email);
        registerpage.setPassword("123456_Rokaya");
        registerpage.clickregisterButton();
        if(email.equals("rokayaaraby9@"))
        {
            emailAlert = registerpage.getWrongMailMessage();
        }else {
            emailAlert = registerpage.getmailAlert();
        }

        assertTrue(emailAlert.contains(errorMessage), "Wrong Error Message");
    }
    @DataProvider(name = "passwordData")
    public static Object[][] passworddata() {
        return new Object[][]{
                {"12", "Your password must have at-least 7 characters."},
                {"123rokaya", "Your password must contain at least 1 special character."},
                {"123_", "Your password must contain at-least 1 numeric character"},
                {"12345 rokaya", "Spaces are not allowed in your password."}
        };
    }
    @Test(dataProvider = "passwordData", priority = 5)
    public void testInvalidPassword(String password, @NotNull String errorMessage) throws InterruptedException {
        registerpage = homePage.registerButtonClick();
        registerpage.setFullName("Rokqya Araby");
        registerpage.setEmailAddress("mahmoudaraby346@gmail.com");
        registerpage.setPassword(password);
        //registerpage.clickNotRobotButton();
        registerpage.registerClickinButton();
        String passwordAlert = registerpage.getpasswordAlert();
        String passwordPolicyAlert = registerpage.getPasswordPolicies();
        Thread.sleep(1000);

        assertTrue(passwordAlert.contains("The password does not satisfy the password policies."), "Wrong Error Message");
        assertTrue(passwordPolicyAlert.contains(errorMessage), "Wrong Error Message");
    }

}



