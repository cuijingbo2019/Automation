package test_wework.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.util.Arrays;
import java.util.List;

/**
 * @author cuijingbo
 * @date 2021/3/22 18:20
 */
public class SchedulePage extends BasePage {
    public SchedulePage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    //添加日历
    public SchedulePage addSchedule(String name, String time){

        return this;
    }

    //获取日程
    public List<String> getSchedule(String time){
        return Arrays.asList("1","2");
    }
}
