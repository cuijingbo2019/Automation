package test_framwework;

import web_wework.page.WebBasePage;
import xueqiu.page.AppBasePage;

/**
 * @author cuijingbo
 * @date 2021/3/31 21:22
 */
public class UIAutoFactory {
    //工厂方法，创建具体的basepage
    //根据传入的引擎，创建不同的basepage
    public static BasePage create(String driverName){
        if (driverName.equals("web") || driverName.equals("selenium")){
            return new  WebBasePage();
        }
        if (driverName.equals("app") || driverName.equals("appium")){
            return new AppBasePage();

        }

        if (driverName.equals("uiautomator")){
            //使用uiatutomator
        }
        if (driverName.equals("atx")){
            //使用python
        }

        return null;
    }
}
