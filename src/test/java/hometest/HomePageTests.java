package hometest;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.SearchForAProduct;
import basetest.BaseTest;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest{

    @Test
    public void testChangLanguage(){
        homePage.clickLanguageButton();
        homePage.clickLanguageButton();
    }

    @Test
    public void testLogOutSuccessfully(){

        LoginPage loginPage = homePage.LoginButtonClick();
        loginPage.setEmail("rokayaaraby9@gmail.com");
        loginPage.setPassword("12345_Rokqya");
        loginPage.clickingLoginButton();

        SearchForAProduct searchPage = homePage.SearchField();
        searchPage.searchForProduct("Thank You");

        homePage.signOut();
    }
}
