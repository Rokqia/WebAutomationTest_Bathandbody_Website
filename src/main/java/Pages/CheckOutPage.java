package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOutPage extends NavBar{

    private By conactDetailsButton = By.className("spc-checkout-empty-delivery-text");
    private By regionInformation = By.id("spc-area-select-selected-city");
    private By cityInformation = By.id("spc-area-select-selected");
    private By streetNameField = By.name("address_line1");
    private By mobileNumberField = By.name("mobile");
    private By buildingNumberField = By.name("dependent_locality");
    private By floorNumberField = By.name("address_line2");
    private By landMarkField = By.name("sorting_code");
    private By postalCodeField = By.name("postal_code");
    private By saveButton = By.id("save-address");
    private By returnHome = By.cssSelector(".site-brand-home .logo");
    private By completePurchase = By.xpath("//div[@class='checkout-link complete-purchase complete-purchase-cta fadeInUp notInMobile submit active checkout_com_upapi_fawry']");
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddDeliveryInformation() {
        WebElement contactDetails = driver.findElement(conactDetailsButton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(contactDetails));
        Clicking(contactDetails);
    }

    public void selectRegion(String option) {
        WebElement regionDropdown = driver.findElement(regionInformation);
        regionDropdown.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebElement region = driver.findElement(By.xpath("//span[@class='spc-area-panel-item' and text()='" + option + "']"));
        region.click();
    }
    public void selectCity(String option) {
        WebElement cityDropdown = driver.findElement(cityInformation);
        cityDropdown.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebElement city = driver.findElement(By.xpath("//span[@class='spc-area-panel-item' and text()='" + option + "']"));
        city.click();
    }
    public void setMobileNumber(String mobile){
        driver.findElement(mobileNumberField).sendKeys(mobile);
    }
    public void setStreetName(String streetName){
        driver.findElement(streetNameField).sendKeys(streetName);
    }
    public void setBuildingNumber(String buildingNumber){
        driver.findElement(buildingNumberField).sendKeys(buildingNumber);
    }
    public void setFloorNumber(String floorNumber){
        driver.findElement(floorNumberField).sendKeys(floorNumber);
    }
    public void setLandMark(String landMark){
        WebElement landMarkText = driver.findElement(landMarkField);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", landMarkText);
        landMarkText.sendKeys(landMark);
    }

    public void setPostalCode(String postalCode){
        WebElement postalCodeText = driver.findElement(postalCodeField);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", postalCodeText);
        postalCodeText.sendKeys(postalCode);
    }
    public void clickSave(){
        WebElement save = driver.findElement(saveButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", save);
        Clicking(save);
    }
    public void scrollToCompletePurchase(){
        WebElement complete = driver.findElement(completePurchase);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", complete);
    }
    public void returnToHome(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ajax-progress.fullscreen-loader")));

        WebElement logoElement = driver.findElement(returnHome);

        try {
            logoElement.click();
        } catch (ElementClickInterceptedException e) {
            // Handle the exception if needed
            e.printStackTrace();
        }
    }


}
