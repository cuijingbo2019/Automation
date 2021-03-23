package test_wework.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Text;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @author cuijingbo
 * @date 2021/3/22 15:37
 */
public class BasePage {
    private final int DefailTimeout =60;
    String packageName;
    String activityName;

    public BasePage(String packageName,String activityName )  {
        this.packageName=packageName;
        this.activityName=activityName;
        startApp(packageName,activityName);
    }

    // AndroidDriver<MobileElement> driver;
    AppiumDriver<MobileElement> driver;
    WebDriverWait wait;

    public BasePage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        wait=new WebDriverWait(driver, DefailTimeout);
    }

    public void startApp(String packageName,String activityName){
        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setCapability("platformName","Android");
        caps.setCapability("deviceName","appium");
        caps.setCapability("appPackage",packageName);
        caps.setCapability("appActivity",activityName);
        caps.setCapability("noReset","true"); //不重置应用状态
        //caps.setCapability("fillRest","True");//完全重置
        //caps.setCapability("udid","");
        //caps.setCapability("dontStopAppOnReset","true");//复用已打开的app
        try {
            driver=new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"),caps);//appium端口号
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait=new WebDriverWait(driver,DefailTimeout);
    }

    public void quit() {
        driver.quit();
    }

    //封装点击方法：等待元素可点击后，进行点击操作
    //todo:异常处理,移动端不需要等待
    public void click(By by){
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).click();
    }

    //传入定位方法，查找元素
    public MobileElement find(By by){
        return driver.findElement(by);
    }


    //通过文本定，查找元素
    public MobileElement find(String text){
        return driver.findElement(bytext(text));
    }

    //封装By方法-传入文本，返回BY.xpath
    public By bytext(String text){
        return By.xpath("//*[@text='"+text+"']");
    }


    //文本定位点击
    public void click(String text){
        find(text).click();
    }




    //封装sendkeys 方法，传入点击元素，传入keyword
    //todo:异常处理，移动端不需要等待
    public void sendKeys(By by,String content){
        driver.findElement(by).sendKeys(content);
    }









    //todo:添加等待
    public void  waitElement(){

    }

}
