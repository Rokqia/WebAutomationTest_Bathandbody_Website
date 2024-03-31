package endtoendtest;

import Pages.*;
import basetest.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertTrue;

public class EndtoEndTests extends BaseTest{

    RegisterPage registerPage;
    LoginPage loginPage;
    ChangePasswordPage changePasswordPage;
    SearchForAProduct searchPage;
    CartPage cartPage;
    CheckOutPage checkOutPage;
    SoftAssert softassert = new SoftAssert();

    /*@Test(priority = 1)
    public void testSuccessfulRegister(){
        registerPage = homePage.registerButtonClick();
        registerPage.setFullName("Rokqya Araby");
        registerPage.setEmailAddress("");
        registerPage.setPassword("123456_Rokaya");
        registerPage.clickNotRobotButton();

        EmailVerificationRequiredPage emailVerifPage = registerPage.registerClickinButton();
        assertTrue(emailVerifPage.getAlertText().contains("A welcome message with further instructions has been sent to your email address."), "Alert text is incorrect");
    }*/

    @Test(priority = 2)
    public void testSuccessfulLogin(){
        loginPage = homePage.LoginButtonClick();
        loginPage.setEmail("rahmahussien7338715@gmail.com");
        loginPage.setPassword("123456_Rokqya");
        loginPage.clickShowPassword();
        MyAccountPage accountPage = loginPage.clickingLoginButton();
        assertTrue(accountPage.getAccountText().contains("My Account"), "Text is incorrect");
    }
    @Test(priority = 10)
    public void testChangLanguage(){
        homePage.clickLanguageButton();
        homePage.clickLanguageButton();
    }

    @Test(priority = 3)
    public void testSuccessfulSearch(){
        searchPage = homePage.SearchField();

        searchPage.searchForProduct("you'r");
        searchPage.addToWishList();
        searchPage.clickClear();
        searchPage.searchForProduct("into the night");
        searchPage.addToWishList();
        searchPage.clickAddToCard();
    }

    @Test(priority = 6)
    public void testAddToCart() throws InterruptedException {

        //searchPage = homePage.SearchField();
        searchPage.clickClear();
        searchPage.searchForProduct("JAPANESE CHERRY BLOSSOM");
        searchPage.checkProduct();
        String alertText = searchPage.getAlertText();
        assertTrue(alertText.contains("has been added to your bag."), "Wrong Message");
        searchPage.productQuantity();
        searchPage.clickAddToCartProductPage();
        Thread.sleep(2000);
        //searchPage.clickCloseModal();
    }

    @Test(priority = 4)
    public void testSortingProducts(){

        searchPage.sortingByPrice();
    }

    @Test(priority = 5)
    public void testFilteringSearch(){

        searchPage.clickClear();
        searchPage.searchForProduct("in the stars");
        searchPage.filterByProductType();
        searchPage.filterByFragranceName();
        searchPage.filtertByFragranceCategory();
        searchPage.filtertByPormotions();
        searchPage.clickAllFilterOptions();
        searchPage.filterByPrice();
        searchPage.clickApplyFilter();
    }

    @Test(priority = 7)
    public void testCart() throws InterruptedException {

        CartPage cartPage = homePage.cartButtonClick();
        cartPage.addToLoveItList();
        cartPage.deleteItem();
        cartPage.setPromoCode("BBWFIRST10");
        Thread.sleep(3000);
        cartPage.clickApplyCode();
        checkOutPage = cartPage.continueToCheckOut();

    }

    @Test(priority = 8)
    public void testSuccessfulCheckout() throws InterruptedException {

        checkOutPage.clickAddDeliveryInformation();
        checkOutPage.setMobileNumber("");
        Thread.sleep(1000);
        checkOutPage.selectRegion("Cairo");
        checkOutPage.selectCity("Ain Shams");
        checkOutPage.setStreetName("Gamal Abd El noaem street");
        checkOutPage.setBuildingNumber("24");
        checkOutPage.setFloorNumber("2");
        checkOutPage.setLandMark("supermarket");
        checkOutPage.setPostalCode("11772");
        checkOutPage.clickSave();
        checkOutPage.scrollToCompletePurchase();
        Thread.sleep(3000);
        checkOutPage.returnToHome();
    }

    @Test(priority = 11)
    public void testLogOutSuccessfully(){
        searchPage.searchForProduct("Thank You");
        homePage.signOut();
    }
}
