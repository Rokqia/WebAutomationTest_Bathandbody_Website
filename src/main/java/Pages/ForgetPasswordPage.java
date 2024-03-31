package Pages;

import org.checkerframework.checker.units.qual.N;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgetPasswordPage extends NavBar{

    private By mailField = By.name("name");
    private By submitButton = By.id("edit-submit");
    private By alertMessage = By.xpath("//div[@role='alert']");
    public ForgetPasswordPage(WebDriver driver) {
        super(driver);
    }
    public void resetPasswordMail(String email){
        driver.findElement(mailField).sendKeys(email);
    }

    public void clickSubmitButton(){
        driver.findElement(submitButton).click();
    }

    public String getAlertMessage(){
        return driver.findElement(alertMessage).getText();
    }
}
