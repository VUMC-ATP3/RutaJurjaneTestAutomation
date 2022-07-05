package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutSuccessPage {
    public WebDriver driver;

    public CheckoutSuccessPage(WebDriver driver) {
        this.driver = driver;
    }

    private By backHomeButton= By.id("back-to-products");
    private By sucsessfulOrderText= By.className("complete-text");

    public WebElement getBackHomeButton(){
        return driver.findElement(backHomeButton);
    }

    public WebElement getSucsessfulOrderText(){
        return driver.findElement(sucsessfulOrderText);
    }

}

