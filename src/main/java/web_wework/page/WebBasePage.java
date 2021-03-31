package web_wework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test_framwework.BasePage;

import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * @author cuijingbo
 * @date 2021/2/26 16:22
 */
public class WebBasePage extends BasePage {

    RemoteWebDriver driver;
    WebDriverWait wait;
    //封装driver/wait
    public WebBasePage() {
        URL path=this.getClass().getResource("/chromedriver.exe");
        System.out.println(path.getPath());
        System.setProperty("webdriver.chrome.driver", path.getPath());


       // System.setProperty("webdriver.chrome.driver","D://BrowserDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait=new WebDriverWait(driver,10);
    }

    public WebBasePage(RemoteWebDriver driver) {
        this.driver = driver;
        wait=new WebDriverWait(driver,10);
    }


    //封装退出
    public void quit() {
        driver.quit();
    }

    //封装点击方法：等待元素可点击后，进行点击操作
    //todo:异常处理
    public void click(By by){
        wait.until((ExpectedConditions.elementToBeClickable(by)));
        driver.findElement(by).click();
    }

    //封装sendkeys 方法，传入点击元素，传入keyword
    //todo:异常处理
    public void sendKeys(By by,String content){
        wait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).sendKeys(content);
    }

    //封装上传文件方法
    public void uplod(By by, String path){
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        driver.findElement(by).sendKeys(path);
    }

    @Override
    public void click(HashMap<String, Object> map) {
        super.click(map);
        //把map中所有的key取出来,转成Array，然后取第一个
        String key= (String) map.keySet().toArray()[0];
        //把map中所有的value取出来,转成Array，然后取第一个
        String value= (String) map.values().toArray()[0];
        By by = null;
        //tolowercase--转成小写, 字符串相等用equals
        if (key.toLowerCase().equals("id")){
            by=By.id(value);
        }
        if (key.toLowerCase().equals("linkText".toLowerCase())){
            by=By.linkText(value);
        }

        if (key.toLowerCase().equals("partialLinkText".toLowerCase())){
            by=By.partialLinkText(value);
        }
        click(by);
    }

    //重载 over


    @Override
    public void action(HashMap<String, Object> map) {
        super.action(map);
        if(map.get("action").toString().toLowerCase().equals("get")){
            driver.get(map.get("url").toString());
        }else {
            System.out.println("error get");
        }
    }
}
