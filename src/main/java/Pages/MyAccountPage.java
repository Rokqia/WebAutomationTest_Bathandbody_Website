package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends NavBar{
    private By myAccount = By.className("c-page-title");
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }
    public String getAccountText(){
        return driver.findElement(myAccount).getText();
    }

}
