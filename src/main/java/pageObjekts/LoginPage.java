package pageObjekts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public WebDriver driver;
//lai obligāti padotu draiveri
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By userInputFdield= By.id("user-name");
    private By passwordInputFdield= By.id("password");
    private By loginButton= By.cssSelector("input#login-button");
    private By errorMessage= By.cssSelector("h3[data-test='error']");

    public void login(String username, String password){
        getUsernameField().sendKeys(username);
        getPasswordField().sendKeys(password);
        getLoginButton().click();
    }

    public WebElement getUsernameField(){
        return driver.findElement(userInputFdield);
    }
    public WebElement getPasswordField() {
        return driver.findElement(passwordInputFdield);
    }
    public WebElement getLoginButton() {
        return driver.findElement(loginButton);
    }

    public WebElement getErrorMessage(){
        return driver.findElement(errorMessage);
    }



}
