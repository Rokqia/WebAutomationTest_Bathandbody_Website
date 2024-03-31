package checkouttest;

import Pages.CartPage;
import Pages.CheckOutPage;
import Pages.LoginPage;
import Pages.SearchForAProduct;
import basetest.BaseTest;
import org.testng.annotations.Test;

public class CeckoutTest extends BaseTest{

    @Test
    public void testSuccessfulCheckout() throws InterruptedException {
        LoginPage loginPage = homePage.LoginButtonClick();
        loginPage.setEmail("rahmahussien7338715@gmail.com");
        loginPage.setPassword("123456_Rokaya");
        loginPage.clickingLoginButton();

        CartPage cartPage = homePage.cartButtonClick();
        CheckOutPage checkOutPage = cartPage.continueToCheckOut();
        checkOutPage.clickAddDeliveryInformation();
        checkOutPage.setMobileNumber("1003852811");
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
    }

}
