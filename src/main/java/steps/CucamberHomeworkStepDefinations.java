package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObjectsHomework.*;


public class CucamberHomeworkStepDefinations {
    WebDriver driver;
   LoginPage loginPage=new LoginPage(driver);
    InventoryPage inventoryPage=new InventoryPage(driver);
    CartPage cartPage=new CartPage(driver);
    CheckoutPage checkoutPage=new CheckoutPage(driver);
    CheckoutOverviewPage checkoutOverviewPage=new CheckoutOverviewPage(driver);
    CheckoutSuccessPage checkoutSuccessPage=new CheckoutSuccessPage(driver);


    @Before("@parluks")
    public void openBrowser(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After("@parluks")
    public void closeBrowser(){
        driver.quit();
    }

    @Given("user is navigated to page {string}")
    public void user_is_navigated_to_page(String url) {
        driver.get(url);
    }
    @Then("user sees title of page {string}")
    public void user_sees_title_of_page(String pageTitle) {
        Assert.assertEquals(driver.getTitle(),pageTitle);
    }
    @When("user enters login {string} and password {string}")
    public void user_enters_login_and_password(String username, String password) {
        loginPage.getUserInputField().sendKeys(username);
        loginPage.getPasswordInputField().sendKeys(password);
    }
    @When("user clicks button to login")
    public void user_clicks_button_to_login() {
        loginPage.getLoginButton().click();
    }
    @Then("user is successfully logged in page")
    public void user_is_successfully_logged_in_page() {
        Assert.assertEquals(inventoryPage.getPageTitle().getText(),"PRODUCTS");
    }

    @When("user adds item to chart")
    public void user_adds_item_to_chart() {
        inventoryPage.getSauceLabsFleeceJacketAddToChartButton().click();
    }

    @When("user clicks Go to chart button")
    public void user_clicks_go_to_chart_button() {
        inventoryPage.getGoToCartIcon().click();
    }

    @Then("user sees selected item in chart")
    public void user_sees_selected_item_in_chart() {
        Assert.assertEquals(cartPage.getLinksIeliktajaiPreceiGroza().getText(),inventoryPage.getSauceLabsFleeceJacketTitleLink().getText());
    }

    @When("user adds selected item to chart")
    public void user_adds_selected_item_to_chart() {
        inventoryPage.getSauceLabsFleeceJacketAddToChartButton().click();
    }

    @When("user clicks Checkout Button")
    public void user_clicks_checkout_button() {
        inventoryPage.getGoToCartIcon().click();
    }

    @When("user enters First name {string}, last Name {string} and postal code {string}")
    public void user_enters_first_name_last_name_and_postal_code(String firstName, String lastName, String postalCode) {
        checkoutPage.getFirstNameField().sendKeys(firstName);
        checkoutPage.getLastNameField().sendKeys(lastName);
        checkoutPage.getPostalCodeField().sendKeys(postalCode);
    }

    @When("user clicks Continue Button")
    public void user_clicks_continue_button() {
        checkoutPage.getContinueButton().click();
    }

    @When("user clicks Finish button")
    public void user_clicks_finish_button() {
        checkoutOverviewPage.getFinishButton().click();
    }

    @Then("user sees sucsessful order message {string}")
    public void user_sees_sucsessful_order_message(String sucsessffulMessage) {
        Assert.assertEquals(checkoutSuccessPage.getSucsessfulOrderText().getText(),sucsessffulMessage);

    }

}
