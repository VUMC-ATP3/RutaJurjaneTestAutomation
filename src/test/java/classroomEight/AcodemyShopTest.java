package classroomEight;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjekts.acodemyShop.MainPage;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AcodemyShopTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void openBrowser() throws MalformedURLException {
        ChromeOptions chromeOptions = new ChromeOptions();
//        EdgeOptions options=new EdgeOptions();
        driver = new RemoteWebDriver(new URL("http://192.168.8.103:4444"),chromeOptions);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void testSwichTabs() {
        driver.get("http://shop.acodemy.lv/");
        System.out.println("Tabu skaits:" + driver.getWindowHandles().size());
        driver.findElement(By.cssSelector("div[class='site-info'] a")).click();
        System.out.println(driver.getTitle());

        System.out.println("Tabu skaits:" + driver.getWindowHandles().size());
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));//speciala komanda lai pārslēgtos starp tabiem (driver.close aizvērs konkrēto tabu kurā esi
        System.out.println(driver.getTitle());
        driver.switchTo().window(tabs.get(0));
        System.out.println(driver.getTitle());
        ;
    }

    @Test //lai varētu skrollēt lapu uz leju
    public void testJavaScript() throws InterruptedException {
        driver.get("http://shop.acodemy.lv/");
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)");
        Thread.sleep(1000);
//        ((JavascriptExecutor) driver).executeScript("alert('Ruta Ruta')");
//        Thread.sleep(1000);

        WebElement element = driver.findElement(By.cssSelector("li.post-18"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(4000);
    }

    @Test
    public void mouseActiontest() throws InterruptedException {
        driver.get("https://www.w3schools.com/howto/howto_css_dropdown.asp");
        driver.findElement(By.id("accept-choices")).click();

        Actions actions=new Actions(driver);
        WebElement hoverMeButton = driver.findElement(By.xpath("//button[text()='Hover Me']"));
        actions.moveToElement(hoverMeButton).perform();
        Thread.sleep(4000);
        driver.findElement(By.linkText("Link 1")).click();
        Thread.sleep(4000);

    }

    @Test
    public void keyBoardActionTest() throws InterruptedException {
        driver.get("https://www.selenium.dev/documentation/webdriver/actions_api/keyboard/");
        Actions actions= new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys("k").perform();
        Thread.sleep(4000);
    }

    @Test
    public void testSearch() throws InterruptedException {
        driver.get("http://shop.acodemy.lv/");
        MainPage mainPage=new MainPage(driver);
//        mainPage.searchProduct("Beanie");
//        Assert.assertEquals(mainPage.getSerachResultText(),"Showing all 2 results");
//        mainPage.getSerachResultText();
//        Thread.sleep(5000);
//        mainPage.searchProduct("T-shirt");
//        Assert.assertEquals(mainPage.getSerachResultText(),"Showing all 3 results");
        mainPage.searchProduct("Hoodie");
        Assert.assertEquals(mainPage.getSearchResults().size(),3);
        Thread.sleep(5000);


        List<WebElement> results= mainPage.getSearchResults();
        for (int i = 0; i < results.size(); i++) {
            System.out.println("####################");
            System.out.println(results.get(i).findElement(By.cssSelector("span.woocommerce-Price-amount")).getText());
        }
//        Assert.assertEquals(mainPage.getNoSearchResultText(),MainPage.NO_SEARCH_RESULTS);



    }

    @Test
    public void testEmptySearch()  {
        driver.get("http://shop.acodemy.lv/");
        MainPage mainPage = new MainPage(driver);
        mainPage.searchProduct("JurisJuris");
//        Assert.assertEquals(mainPage.getNoSearchResultText(),MainPage.NO_SEARCH_RESULTS);
    }


    @AfterMethod
    public void tearDownBrowser(){
        driver.quit();
    }






}
