import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class FirstSeleniumTest {

    WebDriver chromeParluks;

    @Test
    public void testPageTitle(){
        chromeParluks=new ChromeDriver(); //veids kā atvērt jaunu chrome lapu
        chromeParluks.navigate().to("https://www.lu.lv/");//pasakām uz kuru lapu aiziet
        chromeParluks.manage().window().maximize();//lai atver pilnu logu
        String expectedTitle="Latvijas Universitāte";
        String axtualeTitle= chromeParluks.getTitle();//liekam atrast title
        Assert.assertEquals(axtualeTitle,expectedTitle);//liekam saLĪDZINĀT
        chromeParluks.quit();


    }
    @AfterMethod
    public void closeBrowser(){
        chromeParluks.quit();
    }

}
