package xueqiu.page;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * @author cuijingbo
 * @date 2021/3/16 17:52
 */
public class MainPage extends AppBasePage {
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
