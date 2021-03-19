package xueqiu.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cuijingbo
 * @date 2021/3/16 17:54
 */
public class SearchPage {
    private AndroidDriver driver;

    private By nameLocator=By.id("name");

    public SearchPage(AndroidDriver driver) {
        this.driver=driver;
    }



    //进入搜索页
    public SearchPage search(String keyword){
        driver.findElementById("com.xueqiu.android:id/search_input_text").sendKeys(keyword);
        return this;
    }

    //search搜索校验
    public List<String> getSearchlist(){
        List<String> nameList=new ArrayList<>();
//        for(Object element: driver.findElements(nameLocator)){
//            nameList.add(((WebElement)element).getText());
//        }
        driver.findElements(nameLocator).forEach(name->nameList.add(((WebElement)name).getText()));
        return nameList;
    }


    //返回搜索结果-获取股价
    public double getPrice(){
        driver.findElement(nameLocator).click();
        return Double.parseDouble(driver.findElement(By.id("current_price")).getText());
    }

    public void addFirstSearchResult(){
        //点击第一条搜索结果
        WebElement element= (WebElement) driver.findElements(nameLocator).get(0);
        element.click();
        //点击第一条的加入自选
        driver.findElementById("com.xueqiu.android:id/follow_btn").click();
        //点击取消
        driver.findElementById("com.xueqiu.android:id/action_close").click();
    }


}
