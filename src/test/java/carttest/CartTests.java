package carttest;

import Pages.CartPage;
import Pages.LoginPage;
import Pages.SearchForAProduct;
import basetest.BaseTest;
import org.testng.annotations.Test;

public class CartTests extends BaseTest{

    @Test
    public void testCart() throws InterruptedException {
        LoginPage loginPage = homePage.LoginButtonClick();
        loginPage.setEmail("rahmahussien7338715@gmail.com");
        loginPage.setPassword("123456_Rokaya");
        loginPage.clickingLoginButton();

        SearchForAProduct searchPage = homePage.SearchField();
        searchPage.searchForProduct("into the night");
        searchPage.clickAddToCard();

        CartPage cartPage = homePage.cartButtonClick();
        cartPage.addToLoveItList();
        cartPage.deleteItem();
        cartPage.setPromoCode("STOCKUPEG");
        Thread.sleep(3000);
        cartPage.clickApplyCode();
        cartPage.continueToCheckOut();

    }
}
