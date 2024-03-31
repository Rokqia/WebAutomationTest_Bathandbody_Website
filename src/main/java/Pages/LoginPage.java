package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends NavBar{

    private By mailField = By.name("name");
    private By passwordField = By.name("pass");
    private By loginButton = By.id("edit-submit");
    private By showPasswordButton = By.id("unmask_password");
    private By forgetPasswordLink = By.linkText("Forgot password?");
    private By emailFieldAlert = By.xpath("//div[@class='js-form-item form-item js-form-type-email form-type-email js-form-item-name form-item-name']//strong");
    private By passwordFieldAlert = By.xpath("//div[@class='js-form-item form-item js-form-type-password form-type-password js-form-item-pass form-item-pass']//strong");
    private By invalidAlert = By.xpath("//div[@role='alert']/div");

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void setEmail(String mail){
        driver.findElement(mailField).sendKeys(mail);
    }
    public void setPassword(String pass){
        driver.findElement(passwordField).sendKeys(pass);
    }

    public MyAccountPage clickingLoginButton(){
        driver.findElement(loginButton).click();
        return new MyAccountPage(driver);
    }

    public void clickShowPassword(){
        driver.findElement(showPasswordButton).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public ForgetPasswordPage clickForgetPassword(){
        driver.findElement(forgetPasswordLink).click();
        return new ForgetPasswordPage(driver);
    }

    public String getEmailFieldAlert(){
        return driver.findElement(emailFieldAlert).getText();
    }
    public String getPasswordFieldAlert(){
        return driver.findElement(passwordField).getText();
    }
    public String getInvalidMailAlert(){
        return driver.findElement(invalidAlert).getText();
    }


}
