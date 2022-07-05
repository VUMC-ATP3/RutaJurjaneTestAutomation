package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

    public WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    private By continueShopingButton= By.id("continue-shopping");
    private By checkoutButton= By.id("checkout");
//    private By removeButton= By.cssSelector()
//            ("btn btn_secondary btn_small cart_button");
    private By linksIeliktajaiPreceiGroza= By.className("inventory_item_name");

    public WebElement getContinueShopingButton(){
        return driver.findElement(continueShopingButton);
    }

    public WebElement getCheckoutButton(){
        return driver.findElement(checkoutButton);
    }
    public WebElement getLinksIeliktajaiPreceiGroza(){
        return driver.findElement(linksIeliktajaiPreceiGroza);
    }


}
