package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageObjectsHomework.InventoryPage;
import pageObjectsHomework.LoginPage;


public class SouceLabsStepDefinations {
    WebDriver driver;
    LoginPage loginPage=new LoginPage(driver);
    InventoryPage inventoryPage=new InventoryPage(driver);

    @Before("@parluks")
    public void setUp(){
        driver=new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(28);
        driver.manage().window().maximize();
        loginPage=new LoginPage(driver);
        InventoryPage inventoryPage=new InventoryPage(driver);
    }

    @After("@parluks")
    public void tearDown(){
        driver.close();
    }

    @Given("user is navigated to  {string}")
    public void user_is_navigated_to(String url) {
        driver.get(url);
    }
    @Then("user sees page title {string}")
    public void user_sees_page_title(String pageTitle) {
        Assert.assertEquals(driver.getTitle(),pageTitle);
    }
    @When("user enters username {string} and password {string}")
    public void user_enters_username_and_password(String username, String password) {
        loginPage.getUserInputField().sendKeys(username);
        loginPage.getPasswordInputField().sendKeys(password);
    }

    @And("user clicks login button")
    public void user_clicks_login_button() {
        loginPage.getLoginButton().click();
    }


    @Then("user is successfully logged in")
    public void user_is_successfully_logged_in() {
        Assert.assertEquals(inventoryPage.getPageTitle().getText(),"PRODUCTS");

    }

    @Then("user sees error message {string}")
    public void user_sees_error_message(String errorMessage) {
       Assert.assertEquals(loginPage.getErrorMessage().getText(),errorMessage);
    }





}
