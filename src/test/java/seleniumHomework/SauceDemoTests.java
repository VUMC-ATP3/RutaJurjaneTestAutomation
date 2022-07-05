package seleniumHomework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjectsHomework.*;

public class SauceDemoTests {

public WebDriver driver;

    private final String SWAGLABS_URL = "https://www.saucedemo.com/";

    @BeforeMethod
    public void openBrowser(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testPirmaisScenarijs(){
        driver.get(SWAGLABS_URL);
        LoginPage loginPage=new LoginPage(driver);
        loginPage.getUserInputField().sendKeys("standard_user");
        loginPage.getPasswordInputField().sendKeys("secret_sauce");
        loginPage.getLoginButton().click();
        InventoryPage inventoryPage= new InventoryPage(driver);
        Assert.assertEquals(inventoryPage.getPageTitle().getText(),"PRODUCTS");
        inventoryPage.getSauceLabsFleeceJacketAddToChartButton().click();
        inventoryPage.getGoToCartIcon().click();
        CartPage cartPage=new CartPage(driver);
        Assert.assertEquals(cartPage.getLinksIeliktajaiPreceiGroza().getText(),inventoryPage.getSauceLabsFleeceJacketTitleLink().getText());
        cartPage.getCheckoutButton().click();
        CheckoutPage checkoutPage=new CheckoutPage(driver);
        checkoutPage.getFirstNameField().sendKeys("Ruta");
        checkoutPage.getLastNameField().sendKeys("Jurjane");
        checkoutPage.getPostalCodeField().sendKeys("151515");
        checkoutPage.getContinueButton().click();
        CheckoutOverviewPage checkoutOverviewPage=new CheckoutOverviewPage(driver);
        checkoutOverviewPage.getFinishButton().click();
        CheckoutSuccessPage checkoutSuccessPage=new CheckoutSuccessPage(driver);
        Assert.assertEquals(checkoutSuccessPage.getSucsessfulOrderText().getText(),"Your order has been dispatched, and will arrive just as fast as the pony can get there!");
        checkoutSuccessPage.getBackHomeButton().click();


    }

    @Test
    public void testOtraisScenarijsFirstNameError() throws InterruptedException {
        driver.get(SWAGLABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getUserInputField().sendKeys("standard_user");
        loginPage.getPasswordInputField().sendKeys("secret_sauce");
        loginPage.getLoginButton().click();
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.getGoToCartIcon().click();
        CartPage cartPage = new CartPage(driver);
        cartPage.getCheckoutButton().click();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.getContinueButton().click();
        checkoutPage.getLastNameField().sendKeys("Jurjane");
        checkoutPage.getPostalCodeField().sendKeys("151515");
        checkoutPage.getContinueButton().click();
        Assert.assertEquals(checkoutPage.getFirstNameErrorMessage().getText(), "Error: First Name is required");
        Thread.sleep(5000);
    }

     @Test
     public void testOtraisScenarijsLastNameError() throws InterruptedException {
         driver.get(SWAGLABS_URL);
         LoginPage loginPage = new LoginPage(driver);
         loginPage.getUserInputField().sendKeys("standard_user");
         loginPage.getPasswordInputField().sendKeys("secret_sauce");
         loginPage.getLoginButton().click();
         InventoryPage inventoryPage = new InventoryPage(driver);
         inventoryPage.getGoToCartIcon().click();
         CartPage cartPage = new CartPage(driver);
         cartPage.getCheckoutButton().click();
         CheckoutPage checkoutPage = new CheckoutPage(driver);
         checkoutPage.getContinueButton().click();
         checkoutPage.getFirstNameField().sendKeys("Ruta");
         checkoutPage.getPostalCodeField().sendKeys("151515");
         checkoutPage.getContinueButton().click();
         Assert.assertEquals(checkoutPage.getLastNameErrorMessage().getText(), "Error: Last Name is required");
         Thread.sleep(5000);
     }

     @Test
     public void testOtraisScenarijsPostalCodeError() throws InterruptedException {
         driver.get(SWAGLABS_URL);
         LoginPage loginPage = new LoginPage(driver);
         loginPage.getUserInputField().sendKeys("standard_user");
         loginPage.getPasswordInputField().sendKeys("secret_sauce");
         loginPage.getLoginButton().click();
         InventoryPage inventoryPage = new InventoryPage(driver);
         inventoryPage.getGoToCartIcon().click();
         CartPage cartPage = new CartPage(driver);
         cartPage.getCheckoutButton().click();
         CheckoutPage checkoutPage = new CheckoutPage(driver);
         checkoutPage.getContinueButton().click();
        checkoutPage.getFirstNameField().sendKeys("Ruta");
        checkoutPage.getLastNameField().sendKeys("Jurjane");
        checkoutPage.getContinueButton().click();
        Assert.assertEquals(checkoutPage.getPostalCodeErrorMessage().getText(), "Error: Postal Code is required");



    }
    @AfterMethod
    public void closeBrowser(){
    driver.quit();
}

}
