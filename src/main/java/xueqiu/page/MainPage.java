package xueqiu.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @author cuijingbo
 * @date 2021/3/16 17:52
 */
public class MainPage extends BasePage {
    private AndroidDriver driver;


    //进入搜索页
    public SearchPage toSearch(){
        click(By.id("com.xueqiu.android:id/home_search"));
      //  driver.findElementById("com.xueqiu.android:id/home_search").click();
        return new SearchPage(driver);
    }



    //进入行情页
    public StockPage toStock(){
       // driver.findElementByXPath("(//*[@resource-id='com.xueqiu.android:id/tab_icon'])[2]").click();
        click(By.xpath("(//*[@resource-id='com.xueqiu.android:id/tab_icon'])[2]"));
        return new StockPage(driver);
    }

}
