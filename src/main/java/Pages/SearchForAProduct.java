
package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;
import java.util.List;

public class SearchForAProduct extends NavBar {

    private By searchField = By.name("search");
    //private By resultProduct = By.xpath("//a[@href='/en/buy-japanese-cherry-blossom-fine-fragrance-mist.html']");
    private By resultProduct = By.xpath("(//div[@class='c-products__item views-row'])[3]");
    private By addToCardButton = By.xpath("(//button[@class ='addtobag-button'])[3]");
    private By addToProductPage = By.xpath("//button[@value ='Add to bag']");
    private By quantityButton = By.id("edit-quantity");
    private By clearButton = By.id("react-algolia-searchbar-clear-button");
    private By wishListButton = By.xpath("(//div[@class ='wishlist-icon wishlist top-right'])[1]");
    private By SortingButton = By.xpath("(//div[@id='sort_by'])[1]");

    private By filterByProductTypeButton = By.xpath("(//div[@id='attr_collection_1'])[1]");
    private By filtertByFragranceNameButton = By.xpath("(//div[@id='attr_fragrance_name'])[1]");
    private By filtertByFragranceCategoryButton = By.xpath("(//div[@id='attr_fragrance_category'])[1]");
    private By filtertByPormotionsButton = By.xpath("(//div[@id='field_acq_promotion_label'])[1]");
    private By filteringOptions = By.className("show-all-filters-algolia");
    private By filterByPriceButton = By.xpath("(//div[@id='final_price'])[2]");
    private By applyChanges = By.xpath("//a[@class='facet-apply-all button']");
    private By alertText = By.xpath("//div[@class='col-2']");
    private By invalidAssertText = By.className("view-empty");

    public SearchForAProduct(WebDriver driver) {
        super(driver);
    }

    public void searchForProduct(String product) {
        driver.findElement(searchField).sendKeys(product);
    }

    public static void Clicking(WebElement element) {
        element.click();
    }

    public void chooseFromResult() {
        Clicking(driver.findElement(resultProduct));

    }

    public void checkProduct() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement productA = driver.findElement(resultProduct);
        String script = "arguments[0].scrollIntoView;";
        ((JavascriptExecutor) driver).executeScript(script, productA);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Clicking(productA);

    }

    public void loadMoreReviews() {

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement loadMore = driver.findElement(By.cssSelector(".load-more"));
        String script = "arguments[0].scrollIntoView;";
        ((JavascriptExecutor) driver).executeScript(script, loadMore);
        new Actions(driver).moveToElement(loadMore).click().perform();

    }

    public void clickAddToCard() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement addToCartButton = driver.findElement(addToCardButton);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,100)", addToCartButton);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));

        new Actions(driver).moveToElement(addToCartButton).click().perform();

    }

    public void sortingByPrice() {
        WebElement filterBy = driver.findElement(SortingButton);
        filterBy.click();
        List<WebElement> options = driver.findElements(By.xpath("//a[@class='facet-item__value']"));
        options.get(4).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void filterByProductType() {
        WebElement filterBy = driver.findElement(filterByProductTypeButton);
        filterBy.click();
        List<WebElement> options = driver.findElements(By.xpath("//li[@datadrupalfacetlabel='Product Type']/span[@class='facet-item__value']"));
        options.get(0).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        filterBy.click();
        options.get(1).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    public void filterByFragranceName() {
        WebElement filterBy = driver.findElement(filtertByFragranceNameButton);
        filterBy.click();
        List<WebElement> options = driver.findElements(By.xpath("//li[@datadrupalfacetlabel='Fragrance Name']/span[@class='facet-item__value']"));
        options.get(0).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        filterBy.click();
        options.get(1).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void filtertByFragranceCategory() {
        WebElement filterBy = driver.findElement(filtertByFragranceCategoryButton);
        filterBy.click();
        List<WebElement> options = driver.findElements(By.xpath("//li[@datadrupalfacetlabel='Fragrance Category']/span[@class='facet-item__value']"));
        options.get(0).click();
        options.get(1).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void filtertByPormotions() {
        WebElement filterBy = driver.findElement(filtertByPormotionsButton);
        filterBy.click();
        List<WebElement> options = driver.findElements(By.xpath("//li[@datadrupalfacetlabel='Promotions']/span[@class='facet-item__value']"));
        options.get(0).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void clickAllFilterOptions() {
        WebElement filterBy = driver.findElement(filteringOptions);
        filterBy.click();
    }

    public void filterByPrice() {
        WebElement filterBy = driver.findElement(filterByPriceButton);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(filterBy));

        filterBy.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        List<WebElement> options = driver.findElements(By.xpath("(//div[@id='final_price']/ul/li[1])[2]"));

        options.get(0).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    public void clickApplyFilter(){
        Clicking(driver.findElement(applyChanges));
    }


    public void clickAddToCartProductPage() {
        WebElement addToBagButton = driver.findElement(addToProductPage);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(addToBagButton));

        new Actions(driver).moveToElement(addToBagButton).click().perform();

    }

    public void productQuantity() {
        WebElement quantity = driver.findElement(quantityButton);
        Select selectQuantity = new Select(quantity);
        selectQuantity.selectByValue("2");
    }

    public void clickClear() {
        driver.findElement(clearButton).click();
    }

    public void addToWishList() {
        WebElement loveIt = driver.findElement(wishListButton);
        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", loveIt);
        loveIt.click();
    }

    public void clickCloseModal(){
        Actions actions = new Actions(driver);

        WebElement element = driver.findElement(By.xpath("//div[@class='overlay__header']/div[@class='overlay__close']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));

        // Perform the desired action
        actions.click(element).perform();
    }
    public String getAlertText(){
        return driver.findElement(alertText).getText();
    }
    public String getInvalidAssertText(){
        return driver.findElement(invalidAssertText).getText();
    }
}







