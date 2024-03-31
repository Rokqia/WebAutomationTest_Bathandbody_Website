package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailVerificationRequiredPage extends NavBar{

    private By statusAlert = By.xpath("//div[@role='alert']");

    public EmailVerificationRequiredPage(WebDriver driver) {
        super(driver);
    }

    public String getAlertText(){
        return driver.findElement(statusAlert).getText();
    }

}
