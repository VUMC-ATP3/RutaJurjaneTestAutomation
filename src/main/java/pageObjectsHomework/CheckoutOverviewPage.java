package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.security.PublicKey;

public class CheckoutOverviewPage {
    public WebDriver driver;

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    private By itemInCartLink=By.className("inventory_item_name");
    private By cancelButton= By.id("cancel");
    private By finishButton = By.id("finish");

    public WebElement getItemInCartLink(){
        return driver.findElement(itemInCartLink);
    }
    public WebElement getCancelButton(){
        return driver.findElement(cancelButton);
    }
    public WebElement getFinishButton(){
        return driver.findElement(finishButton);
    }

}
