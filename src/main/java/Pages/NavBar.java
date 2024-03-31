package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavBar {

    protected WebDriver driver;

    public NavBar(WebDriver driver) {
        this.driver = driver;
    }

    private By loginButton = By.linkText("SIGN IN");
    private By registerButton = By.linkText("CREATE AN ACCOUNT");
    private By changePasswordButton = By.linkText("CHANGE PASSWORD");
    private By languageButton = By.xpath("//a[@class ='language-link']");
    private By searchField = By.name("search");
    private By cartButton = By.cssSelector(".cart-link");
    private By logoutButton = By.linkText("SIGN OUT");

    public static void Clicking(WebElement element){
        element.click();
    }

    public void clickLoginButton(){
        Clicking(driver.findElement(loginButton));
    }
    public void clickRegisterButton(){
        Clicking(driver.findElement(registerButton));
    }
    public void clickChangePasswordButton(){
        Clicking(driver.findElement(changePasswordButton));
    }
    public void clickLanguageButton(){
        Clicking(driver.findElement(languageButton));
    }
    public void clickSearchField(){
        Clicking(driver.findElement(searchField));
    }
    public void clickCartLink(){Clicking(driver.findElement(cartButton));}
    public void clickLogout(){
        Clicking(driver.findElement(logoutButton));
    }


}
