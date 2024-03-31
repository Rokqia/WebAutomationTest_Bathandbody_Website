package searchtest;

import Pages.LoginPage;
import Pages.SearchForAProduct;
import basetest.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.asserts.SoftAssert.*;

public class SearchTest extends BaseTest {

    SoftAssert softassert = new SoftAssert();
    SearchForAProduct searchPage;

    @Test(priority = 1)
    public void testSearchForProduct() throws InterruptedException {
        //SearchForAProduct searchPage = homePage.SearchField();
        searchPage = homePage.SearchField();
        searchPage.searchForProduct("you'r");
        searchPage.addToWishList();
        searchPage.clickClear();
        searchPage.searchForProduct("into the night");
        searchPage.addToWishList();
        searchPage.clickAddToCard();

    }

    @Test(priority = 5)
    public void testAddToCart() throws InterruptedException {
        //SearchForAProduct searchPage = homePage.SearchField();
        searchPage.clickClear();
        searchPage.searchForProduct("JAPANESE CHERRY BLOSSOM");
        searchPage.checkProduct();
        searchPage.productQuantity();
        searchPage.clickAddToCartProductPage(); //from the product page
        Thread.sleep(3000);
        String alertText = searchPage.getAlertText();
        assertTrue(alertText.contains("has been added to your bag."), "Wrong Message");
    }

    @Test(priority = 2)
    public void testSortingProducts(){
        //SearchForAProduct searchPage = homePage.SearchField();
        searchPage.clickClear();
        searchPage.searchForProduct("dark kiss");
        searchPage.sortingByPrice();
    }

    @Test(priority = 3)
    public void testFilteringSearch(){
        //SearchForAProduct searchPage = homePage.SearchField();
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
    @DataProvider(name = "searchingData")
    public static Object[][] passworddata() {
        return new Object[][]{
                {"123the one"},
                {"ja__pness"},
                {"into the night288"},
                {"iiiiiiiiiiinnnnn the stars"}
        };
    }
    @Test(priority = 4, dataProvider = "searchingData")
    public void testInvalidSearch(String productData){
        SearchForAProduct searchPage = homePage.SearchField();
        searchPage.searchForProduct(productData);

        String assertText = null;
        try {
            assertText = searchPage.getInvalidAssertText();
        } catch (Exception e) {
            System.out.println("Assert text not found.");
        }
        searchPage.clickClear();
        if (assertText != null && assertText.contains("Your search did not return any results.")) {
            assertFalse(assertText.contains("Your search did not return any results."));
        } else {
            System.out.println("Search returned results.");
        }
    }

}
