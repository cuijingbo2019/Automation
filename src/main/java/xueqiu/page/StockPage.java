package xueqiu.page;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cuijingbo
 * @date 2021/3/19 15:32
 */
public class StockPage {
    public static AndroidDriver driver;

    public StockPage(AndroidDriver driver) {
        this.driver=driver;
    }

    //点击search-进入search页
    public StockPage toSearchPage(){
        driver.findElementById("com.xueqiu.android:id/action_search").click();
        return this;
    }

    //添加关注
    public StockPage addStock(String keyword){
        //进行查找
        driver.findElementById("com.xueqiu.android:id/search_input_text").sendKeys(keyword);
        //查找名字相同的股票，点击
        String xapth="//*[@text="+"'"+keyword+"'"+"]";
       //driver.findElementByXPath(xapth).click();


        System.out.println(driver.findElementByXPath(xapth));
        driver.findElementByXPath("//*[@text='京东']").click();

        System.out.println(driver.findElementByXPath("//*[@text='京东']"));
        //点击加自选
        driver.findElementByXPath("//*[@text='加自选']").click();

        //加完自选，点击取消，返回stock页
        driver.findElementByXPath("//*[@text='取消']").click();
        return this;
    }

    //Stock页面验证已加自选--搜索股票名称，存在则添加成功
    public String getName(String name){
        String xapth="//*[@text="+"'"+name+"'"+"]";
        return driver.findElementByXPath(xapth).getText();
    }

    //查询是否已加成功
    public String getSearch(String name){
        List<String> nameList=new ArrayList<>();
        for(Object element: driver.findElementsById("com.xueqiu.android:id/portfolio_stockName")){
          if(((WebElement)element).getText().equals(name) ){
              return ((WebElement) element).getText();
          }
        }
        return null;
    }



    //股票详情页
    public StockPage StockDetail(String name){
        String xapth="//*[@text="+"'"+name+"'"+"]";
        driver.findElementByXPath(xapth).click();
        return this;
    }

    //取消自选
    public StockPage delStock(){
        driver.findElementByXPath("//*[@text='设自选']").click();
        //todo:添加判断元素出现
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElementByXPath("//*[@text='删除自选']").click();
        //返回Stock页面
        driver.findElementById("com.xueqiu.android:id/action_back").click();
        return this;
    }



}
