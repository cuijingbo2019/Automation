import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

/**
 * @author cuijingbo
 * @date 2021/2/5 15:33
 */
//js，时间控件专用
public class JsTest {
    public static WebDriver driver;
    public static Actions actions;
    @BeforeAll
    public static void initdata(){
        System.setProperty("webdriver.chrome.driver", "D:\\BrowserDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        actions=new Actions(driver);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    //js方式，进行元素定位，修改日期
    @Test
    public  void JsTest(){
        try {
            driver.get("https://www.12306.cn/index/");
            JavascriptExecutor jsdriver=(JavascriptExecutor)driver;
            Thread.sleep(4000);
            jsdriver.executeScript("document.getElementById('train_date').value='2020-01-11'");
            Thread.sleep(4000);
            System.out.println(jsdriver.executeScript("return document.getElementById('train_date').value='2020-01-11'"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //文件上传
    @Test
    public void imageTest(){
        driver.get("https://www.baidu.com");
        try {
            driver.findElement(By.xpath("//span[@class='soutu-btn']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@class='upload-pic']")).sendKeys("D:/TEST/3.png");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    @Test
    public void AnimailTest(){
        driver.get("http://ccs.51talk.com/game/preview/1119061/index.html");
        try {
            System.out.println("ssssss");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //复用浏览器
    //每次打开新的窗口，打开新的窗口，会非常耗费时间、浏览器也会打开很多
    //复用浏览器，可以直接从中间位置执行，省略过多不必要的操作，例如：省去登录操作

    @Test
    public void  fuyong(){
        //第一步：打开浏览器的debug模式，把浏览器设置为可执行环境变量（可执行文件设置成环境变量）
        ChromeOptions options=new ChromeOptions(); //定义一个optins
        options.setExperimentalOption("debuggerAddre","127.0.0.1:9222");//设置一个参数
        //第二步:把指定的options,传输给chromedriver
        driver= new ChromeDriver(options);

    }
}