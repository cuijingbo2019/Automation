package xueqiu.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @author cuijingbo
 * @date 2021/3/16 17:52
 */
public class MainPage {
    public static AppiumDriver driver;

    @BeforeAll
    public  static void  setup()  {
        try {
            DesiredCapabilities caps=new DesiredCapabilities();
            caps.setCapability("platformName","Android");
            caps.setCapability("deviceName","appium");
            caps.setCapability("appPackage","com.xueqiu.android");
            caps.setCapability("appActivity",".view.WelcomeActivityAlias");
            caps.setCapability("noReset","True"); //不重置应用状态
            //caps.setCapability("fillRest","True");//完全重置
            driver=new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"),caps);//appium端口号
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


    }
    @AfterAll
    public static void exit(){
        driver.quit();
    }


    //进入搜索页
    public SearchPage toSearch(){
        driver.findElementById("com.xueqiu.android:id/home_search").click();
        return new SearchPage();
    }
    //进入行情页
    public void  toStock(){

    }

}
