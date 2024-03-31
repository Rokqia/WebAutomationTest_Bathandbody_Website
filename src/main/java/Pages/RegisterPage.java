package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage extends NavBar{
    private By fullNameField = By.name("full_name");
    private By emailField = By.name("mail");
    private By passwordField = By.name("pass");
    private By notRobotButton = By.id("recaptcha-anchor");
    private By conditionsButton = By.xpath("//div//input[contains(@type,'checkbox')]");
    private By captchaIFrame = By.xpath("//iframe[@title='reCAPTCHA']");
    private By iframeCheckbox = By.xpath("//div[@class='recaptcha-checkbox-checkmark']");
    private By registerClickButton = By.xpath("//button[@id='edit-submit']");
    private By nameEmptyAlert = By.xpath("//div[@class ='js-form-item form-item js-form-type-textfield form-type-textfield js-form-item-full-name form-item-full-name']//strong");
    private By nameAlert = By.xpath("//div[@class='js-form-item form-item js-form-type-textfield form-type-textfield js-form-item-full-name form-item-full-name form-item--error']//strong");
    private By specialCharacterNameAlert = By.xpath("//div[@class='js-form-item form-item js-form-type-textfield form-type-textfield js-form-item-full-name form-item-full-name']//strong");
    private By mailAlert = By.xpath("//div[@class ='js-form-item form-item js-form-type-email form-type-email js-form-item-mail form-item-mail form-item--error']//strong");
    private By wrongMail = By.xpath("//strong[@id='edit-mail-error']");
    private By passwordAlert = By.xpath("//div[@class ='js-form-item form-item js-form-type-password form-type-password js-form-item-pass form-item-pass']//strong");
    private By mailEmptyAlert = By.xpath("//div[@class ='js-form-item form-item js-form-type-email form-type-email js-form-item-mail form-item-mail']//strong");
    private By rechaptchaAlert = By.cssSelector(".form-item--error-message captcha-inline-error");
    private By passwordPolicies = By.className("password-tooltip");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }
    public void setFullName(String name){
        driver.findElement(fullNameField).sendKeys(name);
    }
    public void setEmailAddress(String email){
        driver.findElement(emailField).sendKeys(email);
    }
    public void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickNotRobotButton() {
        // Switch to the reCAPTCHA iframe
        WebElement captchaFrame = driver.findElement(captchaIFrame);
        driver.switchTo().frame(captchaFrame);

        WebElement checkbox = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='recaptcha-checkbox-checkmark']")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox);
        new Actions(driver).moveToElement(checkbox).click().perform();

        driver.switchTo().defaultContent();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

   public void ScrollDown() {
       JavascriptExecutor jse = (JavascriptExecutor) driver;
       jse.executeScript("window.scrollBy(0,400)");
   }
   public void clickregisterButton(){
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
       WebElement registerButton = wait.until(ExpectedConditions.elementToBeClickable(registerClickButton));
       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", registerButton);
       registerButton.click();
   }

    public EmailVerificationRequiredPage registerClickinButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement registerButton = wait.until(ExpectedConditions.elementToBeClickable(registerClickButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", registerButton);
        new Actions(driver).moveToElement(registerButton).click().perform();

        By verificationElementLocator = By.xpath("//div[@role='alert']");
        wait.until(ExpectedConditions.presenceOfElementLocated(verificationElementLocator));

        return new EmailVerificationRequiredPage(driver);
    }
    public String getEmptyNameAlert(){
        return driver.findElement(nameEmptyAlert).getText();
    }
    public String getEmptyEmailAlert(){
        return driver.findElement(mailEmptyAlert).getText();
    }
    public String getNameAlert(){
        return driver.findElement(nameAlert).getText();
    }
    public String getNameSpecialCharacterAlert(){
       return driver.findElement(specialCharacterNameAlert).getText();
    }
    public String getmailAlert(){
       return driver.findElement(mailAlert).getText();
    }
    public String getWrongMailMessage(){
        return driver.findElement(wrongMail).getText();
    }
    public String getpasswordAlert(){
       return driver.findElement(passwordAlert).getText();
    }
    public String getRcaptchaAlert(){
       return driver.findElement(rechaptchaAlert).getText();
    }
    public String getPasswordPolicies(){
       return driver.findElement(passwordPolicies).getText();
    }
}
