package test_framwework;

import web_wework.page.WebBasePage;
import xueqiu.page.AppBasePage;

/**
 * @author cuijingbo
 * @date 2021/3/31 21:22
 */
public class Factory {
    //工厂方法，创建具体的basepage
    //根据传入的引擎，创建不同的basepage
    public static BasePage create(String driverName){
        if (driverName=="web" || driverName=="selenium"){
            return new  WebBasePage();
        }
        if (driverName=="app" || driverName==""){
            return new AppBasePage();

        }

        if (driverName=="uiautomator"){
            //使用uiatutomator
        }
        if (driverName=="atx"){
            //使用python
        }

        return null;
    }
}
