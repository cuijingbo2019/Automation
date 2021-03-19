package wework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @author cuijingbo
 * @date 2021/2/26 16:22
 */
public class BasePage {

    RemoteWebDriver driver;
    WebDriverWait wait;
    //封装driver/wait
    public BasePage() {
        URL path=this.getClass().getResource("/chromedriver.exe");
        System.out.println(path.getPath());
        System.setProperty("webdriver.chrome.driver", path.getPath());


       // System.setProperty("webdriver.chrome.driver","D://BrowserDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait=new WebDriverWait(driver,10);
    }

    public BasePage(RemoteWebDriver driver) {
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


}
