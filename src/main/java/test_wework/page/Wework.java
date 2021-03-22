package test_wework.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

/**
 * @author cuijingbo
 * @date 2021/3/22 18:16
 */
public class Wework extends BasePage{
    public Wework(){
        super("com.tencent.wework",".launch.LaunchSplashActivity");
    }



    //进入首页
    public SchedulePage Schedule(){
        click(By.xpath("//*[@text='日程']"));
        return  new SchedulePage(driver);
    }






}
