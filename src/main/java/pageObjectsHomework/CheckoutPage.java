package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
    public WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    private By firstNameField= By.id("first-name");
    private By lastNameField= By.id("last-name");
    private By postalCodeField= By.id("postal-code");
    private By cancelButton = By.id("cancel");
    private By continueButton = By.id("continue");
    private By firstNameErrorMessage= By.cssSelector("h3[data-test='error']");
    private By lastNameErrorMessage= By.cssSelector("h3[data-test='error']");
    private By postalCodeErrorMessage= By.cssSelector("h3[data-test='error']");

    public WebElement getFirstNameField(){
        return driver.findElement(firstNameField);
    }
    public WebElement getLastNameField(){
        return driver.findElement(lastNameField);
    }
    public WebElement getPostalCodeField(){
        return driver.findElement(postalCodeField);
    }
    public WebElement getCancelButton(){
        return driver.findElement(cancelButton);
    }
    public WebElement getContinueButton(){
        return driver.findElement(continueButton);
    }
    public WebElement getFirstNameErrorMessage(){
        return driver.findElement(firstNameErrorMessage);
    }
    public WebElement getLastNameErrorMessage(){
        return driver.findElement(lastNameErrorMessage);
    }

    public WebElement getPostalCodeErrorMessage(){
        return driver.findElement(postalCodeErrorMessage);
    }



}
