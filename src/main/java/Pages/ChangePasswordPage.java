package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangePasswordPage extends NavBar{

    private By currentPasswordField = By.name("current_pass");
    private By newPasswordField = By.name("pass");
    private By changePasswordButton = By.id("edit-submit");
    private By textAlert = By.cssSelector(".messages.messages--status");

    public ChangePasswordPage(WebDriver driver) {
        super(driver);
    }

    public void setCurrentPassword(String currentPassword){
        driver.findElement(currentPasswordField).sendKeys(currentPassword);
    }
    public void setNewPassword(String newPassword){
        driver.findElement(newPasswordField).sendKeys(newPassword);
    }
    public void changePassword(){
        Clicking(driver.findElement(changePasswordButton));
    }
    public String getAlertText(){
        return driver.findElement(textAlert).getText();
    }


}
