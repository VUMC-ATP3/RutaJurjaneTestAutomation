package mavenTestNGHomework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TitleTest {

    WebDriver chromeParluks;

    @BeforeMethod
    public void atverParluku(){
        chromeParluks=new ChromeDriver();
    }

    @AfterMethod
    public void aizverParluku(){
        chromeParluks.quit();
    }

    @Test
    public void testTitleTvnet(){
        chromeParluks.navigate().to("https://www.tvnet.lv/");
        chromeParluks.manage().window().maximize();
        String expectedTitle= "TVNET - Īstas ziņas";
        String axtualTitle=chromeParluks.getTitle();
        Assert.assertEquals(axtualTitle,expectedTitle);

    }

    @Test
    public void testTitleDelfi() {
        chromeParluks.navigate().to("https://www.delfi.lv/");
        chromeParluks.manage().window().maximize();
        String expectedTitle = "DELFI - Vadošais ziņu portāls Latvijā - DELFI";
        Assert.assertEquals(expectedTitle, chromeParluks.getTitle());

    }


}
