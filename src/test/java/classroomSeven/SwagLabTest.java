package classroomSeven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.dom.model.ShapeOutsideInfo;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjekts.Footer;
import pageObjekts.LoginPage;
import pageObjekts.ProductPage;

import java.time.Duration;
import java.util.List;

public class SwagLabTest {
    WebDriver driver;
    private final String SWAGLABS_URL = "https://www.saucedemo.com/";//skaistuma pēc definējam lapu, kuru mēs pārbaudīsim
    private final String LOCAL_URL = "file://C:\\Users\\A\\Desktop\\Java\\RutaJurjaneTestAutomation\\elements.html";


    @BeforeMethod(alwaysRun = true)
    public void openBrowser() {
        //Atveram brauzeri
        System.out.println("Atveram browseri");
        driver = new ChromeDriver();//lai atvērtu jaunu chrome lapu
        driver.manage().window().maximize();//lai palielinātu lapu
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //noteikts laiks, cik ilgi gaidīs mājas lapas ielādi

    }

    @Test
    public void testErrorMessage() throws InterruptedException {
        //veiksim visas darbības, lai notestētu error message
        System.out.println("Izpildam testu");
        driver.get(SWAGLABS_URL);

        //Atrod un ievada lietotāja vārdu
        WebElement userNameInputField = driver.findElement(By.id("user-name")); //lai atrod pēc ID
        userNameInputField.sendKeys("standard_user"); //lai ieraksta tekstu

        //Atrod un ievada paroli
        WebElement paroleInputField = driver.findElement(By.id("password"));
        paroleInputField.sendKeys("paroleeee");

        //Meklē login pogu
        WebElement loginPoga = driver.findElement(By.cssSelector("input#login-button")); //ar CSS selektoru
        loginPoga.click(); //nospiest pogu

//        Salīdzinām error mesage, meklējot ar CSS (meklētājā raksta h3[data-test='error'] )
        WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']"));
        String actualErrorMessage = errorMessage.getText(); //lai izlasītu, kas rakstīts šajā pogā
        String expectedErrorMessage = "Epic sadface: Password is required";
        ;
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);


        Thread.sleep(5000);//pauze, lai tik ātri neaizveras, bet mēs varētu paspēt apskatīt, ka ir ievadījies teksts

    }

    @Test
    public void testErrorMessageWithPOM() {
        driver.get(SWAGLABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getUsernameField().sendKeys("standard_user");
        loginPage.getPasswordField().sendKeys("");
        loginPage.getLoginButton().click();
        String actualText = loginPage.getErrorMessage().getText();
        String expectedErrorMessage = "Epic sadface: Password is required";
        Assert.assertEquals(actualText, expectedErrorMessage);


    }

    @Test// jau ar nodefinētiem mainīgajiem un metodēm
    public void testErrorMessageWithPOMarMetodem() {
        driver.get(SWAGLABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Juris", "");
        String actualText = loginPage.getErrorMessage().getText();
        String expectedErrorMessage = "Epic sadface: Password is required";
        Assert.assertEquals(actualText, expectedErrorMessage);


    }

    @Test
    public void testSuccessfulLogin() throws InterruptedException {
        driver.get(SWAGLABS_URL);
        WebElement userNameInputField = driver.findElement(By.id("user-name"));
//        WebElement userNameInputField =  driver.findElement(By.cssSelector("input[id='user-name']"));
        userNameInputField.sendKeys("standard_user");

        //tagad uzrakstam paroles lauku un ievadam tur vertibu
        WebElement passwordInputField = driver.findElement(By.name("password"));
        passwordInputField.sendKeys("secret_sauce");

        //atradisim Login pogu

        WebElement loginButton = driver.findElement(By.cssSelector("input#login-button"));
        loginButton.click();

        WebElement titleText = driver.findElement(By.cssSelector("span[class='title']"));
        Assert.assertEquals(titleText.getText(), "PRODUCTS");

        WebElement linkedInLink = driver.findElement(By.linkText("LinkedIn"));
        // to pašu var atras arī, viņš meklēs listu un a, kas ir zem šī lista: WebElement linkedInLink = driver.findElement(By.cssSelector("li[class='social_linkedin'] > a"));
//        linkedInLink.click();


        //lai izmantotu dropdown
        Select sortDropDown = new Select(driver.findElement(By.className("product_sort_container")));
        sortDropDown.selectByValue("hilo");

        //ar xpath
        WebElement addFleeceJacketToCartButton = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']"));
        addFleeceJacketToCartButton.click();
    }

    @Test
    public void testSucssesfulLogin() {
        driver.get(SWAGLABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        ProductPage productPage = new ProductPage(driver);
        Assert.assertEquals(productPage.getPageTitle().getText(), "PRODUCTS");
    }


        @Test
        public void testFooterCopyRightText() throws InterruptedException {
            driver.get(SWAGLABS_URL);
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login("standard_user", "secret_sauce");
            Footer footer =new Footer(driver);
            String actualString =footer.getCopyRightTextField().getText();
            String expectedString = "©️ 2022 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy";
            Assert.assertEquals(actualString,expectedString);






            Thread.sleep(5000);
    }




    @Test
    public void testSamplePage() throws InterruptedException {
        driver.get(LOCAL_URL);

        WebElement vardaLauks= driver.findElement(By.id("fNameID"));
        vardaLauks.sendKeys("Ruta");

        WebElement uzvardaLauks= driver.findElement(By.id("lNameID"));
        uzvardaLauks.sendKeys("Jurjane");

        WebElement informacija= driver.findElement(By.name("description"));
        informacija.clear();
        informacija.sendKeys("Te rakstu, ko gribu");

        WebElement studentCheckBox= driver.findElement(By.id("studentID"));
        studentCheckBox.click();

        WebElement radioButtonJava= driver.findElement(By.id("javaID"));
        System.out.println(radioButtonJava.isSelected());
        radioButtonJava.click();
        System.out.println(radioButtonJava.isSelected());

        Select milakaKrasaDropDown= new Select(driver.findElement(By.id("colorsID")));
        milakaKrasaDropDown.selectByIndex(0);
        milakaKrasaDropDown.selectByIndex(2);

        List<WebElement> saraksts= milakaKrasaDropDown.getOptions();
        for (int i = 0; i < saraksts.size(); i++) {
            System.out.println(saraksts.get(i).getText());
        }


        Thread.sleep(5000);


    }



    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        //aizveram browseri
        System.out.println("Aizveram browseri");
        driver.quit();
    }








}
