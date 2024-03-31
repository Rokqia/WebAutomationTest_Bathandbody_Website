package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends NavBar{

    public HomePage(WebDriver driver) {
        super(driver);
    }
    private void clickLinks(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }

    public RegisterPage registerButtonClick(){
        //clickLinks("CREATE AN ACCOUNT");
        clickRegisterButton();
        return new RegisterPage(driver);
    }
    public LoginPage LoginButtonClick(){
        //clickLinks("SIGN IN");
        clickLoginButton();
        return new LoginPage(driver);
    }

    public SearchForAProduct SearchField(){
        clickSearchField();
        return new SearchForAProduct(driver);
    }
    public CartPage cartButtonClick(){
        clickCartLink();
        return new CartPage(driver);
    }

    public void changeLanguage(){
        clickLanguageButton();
    }
    public ChangePasswordPage clickChangePassword(){
        clickChangePasswordButton();
        return new ChangePasswordPage(driver);
    }
    public static void Clicking(WebElement element){
        element.click();
    }
    public void signOut(){
        clickLogout();
    }


}

