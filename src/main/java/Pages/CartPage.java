package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage extends NavBar{

    private By selectQuantity = By.cssSelector(".spcSelect__dropdown-indicator");
    private By cartDeleteProduct = By.xpath("(//button[@title ='remove this item'])[1]");
    private By cartAddToLoveIt = By.xpath("(//div[@class='wishlist-text cart cart-item'])[1]");
    private By promocodeField = By.xpath("//input[@id='promo-code']");
    private By promocodeButton = By.xpath("//button[@id='promo-action-button']");
    private By checkoutButton = By.xpath("//a[@class='checkout-link']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

   /* public void cartChangeQuantity(String value){

        WebElement dropdownElement = driver.findElement(By.cssSelector("div.spcSelect__single-value.css-1uccc91-singleValue")); // Replace with your actual CSS selector if needed
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Customize timeout if needed
        wait.until(ExpectedConditions.elementToBeClickable(dropdownElement));

        Select select = new Select(dropdownElement);
        select.selectByVisibleText(value); // Selects the fifth option (index 4)
    }*/

    public void addToLoveItList(){
        Clicking(driver.findElement(cartAddToLoveIt));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    public void deleteItem(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Clicking(driver.findElement(cartDeleteProduct));

    }
    public void setPromoCode(String code){
        driver.findElement(promocodeField).sendKeys(code);
    }
    public void clickApplyCode(){
       Clicking(driver.findElement(promocodeButton));
    }
    public CheckOutPage continueToCheckOut(){
        //((JavascriptExecutor) driver).executeScript("window.scrollBy(0,400)");
        WebElement checkout = driver.findElement(checkoutButton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(checkout));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkout);
        Clicking(checkout);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return new CheckOutPage(driver);
    }



}
