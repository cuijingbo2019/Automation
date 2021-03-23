package test_wework.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author cuijingbo
 * @date 2021/3/22 18:20
 */
public class SchedulePage extends BasePage {

    public  final By add = By.id("com.tencent.wework:id/iga");
    public  final By taskName = By.id("com.tencent.wework:id/bfx");
    private final By tasklist = By.xpath("//*[@resource-id='com.tencent.wework:id/hw5']");
    private final By save = bytext("保存");
    //把所有需要点击的坐标，重构字段到代码上，只需要修改对应的字段，无需修改每行代码中的定位
    //refactor--->introduce files  或者快捷键ctr+alt+f

    public SchedulePage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    //添加日历
    public SchedulePage addSchedule(String name, String time){
        click(add);
        sendKeys(taskName,name);
        click(save);
        return this;
    }

    //获取日程
    public List<String> getSchedule(String day){

        if(day!=null){
            //todo:选则日期
        }
        return driver.findElements(tasklist).stream().map(x->x.getText()).collect(Collectors.toList());
    }

}
