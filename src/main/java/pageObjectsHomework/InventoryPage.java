package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage {
    public WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    private By sortDropDown = By.className("product_sort_container");
    private By pageTitle=By.cssSelector("span[class='title']");
    private By goToCartIcon= By.className("shopping_cart_link");





    //Backpack
    private By sauceLabsBackpackTitleLink = By.id("item_4_title_link");
    private By sauceLabsBackpackAddToChartButton = By.name("add-to-cart-sauce-labs-backpack");
    private By sauceLabsBackpackImgLink = By.className("item_4_img_link");

    //BikeLight
    private By sauceLabsBikeLightTitleLink = By.id("item_0_title_link");
    private By sauceLabsBikeLightAddToChartButton = By.name("add-to-cart-sauce-labs-bike-light");
    private By sauceLabsBikeLightImgLink = By.id("item_0_img_link");

    //Bolt T-Shirt
    private By sauceLabsBoltTShirtTitleLink = By.id("item_1_title_link");
    private By sauceLabsBoltTShirtAddToChartButton = By.name("add-to-cart-sauce-labs-bolt-t-shirt");
    private By sauceLabsBoltTShirtImgLink = By.id("item_1_img_link");

    //Fleece Jacket
    private By sauceLabsFleeceJacketTitleLink = By.id("item_5_title_link");
    private By sauceLabsFleeceJacketAddToChartButton = By.name("add-to-cart-sauce-labs-fleece-jacket");
    private By sauceLabsFleeceJacketImgLink = By.id("item_5_img_link");

    //Backpack
    public WebElement getSauceLabsBackpackTitleLink() {
        return driver.findElement(sauceLabsBackpackTitleLink);
    }

    public WebElement getSauceLabsBackpackAddToChartButton() {
        return driver.findElement(sauceLabsBackpackAddToChartButton);
    }

    public WebElement getSauceLabsBackpackImgLink() {
        return driver.findElement(sauceLabsBackpackImgLink);
    }

    //BikeLight
    public WebElement getSauceLabsBikeLightTitleLink() {
        return driver.findElement(sauceLabsBikeLightTitleLink);
    }
    public WebElement getSauceLabsBikeLightAddToChartButton() {
        return driver.findElement(sauceLabsBikeLightAddToChartButton);
    }
    public WebElement getSauceLabsBikeLightImgLink() {
        return driver.findElement(sauceLabsBikeLightImgLink);
    }

    //Bolt T-Shirt
    public WebElement getSauceLabsBoltTShirtTitleLink() {
        return driver.findElement(sauceLabsBoltTShirtTitleLink);
    }
    public WebElement getSauceLabsBoltTShirtAddToChartButton() {
        return driver.findElement(sauceLabsBoltTShirtAddToChartButton);
    }
    public WebElement getSauceLabsBoltTShirtImgLink() {
        return driver.findElement(sauceLabsBoltTShirtImgLink);
    }

    //Fleece Jacket
    public WebElement getSauceLabsFleeceJacketTitleLink() {
        return driver.findElement(sauceLabsFleeceJacketTitleLink);
    }
    public WebElement getSauceLabsFleeceJacketAddToChartButton() {
        return driver.findElement(sauceLabsFleeceJacketAddToChartButton);
    }
    public WebElement getSauceLabsFleeceJacketImgLink() {
        return driver.findElement(sauceLabsFleeceJacketImgLink);
    }

    public WebElement getSortDropDown(){
        return driver.findElement(sortDropDown);
    }

    public WebElement getPageTitle(){
        return driver.findElement(pageTitle);
    }
    public WebElement getGoToCartIcon(){
        return driver.findElement(goToCartIcon);
    }
}

