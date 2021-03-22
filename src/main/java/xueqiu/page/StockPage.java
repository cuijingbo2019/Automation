package xueqiu.page;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cuijingbo
 * @date 2021/3/19 15:32
 */
public class StockPage extends BasePage {
    public StockPage(AndroidDriver<MobileElement> driver) {
        super(driver);
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

        //driver.findElementByXPath("//*[@text='京东']").click();
        click(By.xpath("//*[@text='京东']"));

        //点击加自选
        //driver.findElementByXPath("//*[@text='加自选']").click();
        click(By.xpath("//*[@text='加自选']"));
        //加完自选，点击取消，返回stock页
        //driver.findElementByXPath("//*[@text='取消']").click();
        click(By.xpath("//*[@text='取消']"));
        return this;
    }

    //Stock页面验证已加自选--搜索股票名称，存在则添加成功
    public String getName(String name){
        String xapth="//*[@text="+"'"+name+"'"+"]";
       // driver.findElement(By.xpath(xapth)).getText();
        return findEle(By.xpath(xapth)).getText();
    }

    //查询是否已加成功
    public String getSearch(String name){
        List<String> nameList=new ArrayList<>();
        for(Object element: driver.findElements(By.id("com.xueqiu.android:id/portfolio_stockName"))){
          if(((WebElement)element).getText().equals(name) ){
              return ((WebElement) element).getText();
          }
        }
        return null;
    }



    //股票详情页
    public StockPage StockDetail(String name){
        String xapth="//*[@text="+"'"+name+"'"+"]";
        //driver.findElement(By.xpath(xapth)).click();
        click(By.xpath(xapth));
        return this;
    }

    //取消自选
    public StockPage delStock(){
        //driver.findElement(By.xpath("//*[@text='设自选']")).click();
        click(By.xpath("//*[@text='设自选']"));
        //todo:添加判断元素出现
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       // driver.findElement(By.xpath("//*[@text='删除自选']")).click();
        click(By.xpath("//*[@text='删除自选']"));
        //返回Stock页面
        //driver.findElement(By.id("com.xueqiu.android:id/action_back")).click();
        click(By.xpath("com.xueqiu.android:id/action_back"));
        return this;
    }



}
