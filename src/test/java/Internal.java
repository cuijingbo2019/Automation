/**
 * @author cuijingbo
 * @date 2021/2/3 16:25
 */

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

//selenium常见的操作：拖拽、鼠标悬停、frame切换、窗口切换


public class Internal {
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

    @Test
    public void click(){
        try {
            driver.get("http://sahitest.com/demo/clicks.htm");
            actions.click(driver.findElement(By.xpath("/html/body/form/input[3]")));
            Thread.sleep(2000);
            actions.doubleClick(driver.findElement(By.xpath("/html/body/form/input[2]")));
            Thread.sleep(2000);
            actions.contextClick(driver.findElement(By.xpath("/html/body/form/input[4]")));
            Thread.sleep(2000);
            actions.perform();
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    //鼠标移动
    public  void moveTest(){
        try {
            driver.get("https://www.baidu.com/");
            Thread.sleep(1000);
            actions.moveToElement(driver.findElement(By.id("s-usersetting-top")));
            actions.perform();
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    //拖动
    public  void dragTest(){
        try {
        driver.get("http://sahitest.com/demo/dragDropMooTools.htm");
        actions.dragAndDrop(driver.findElement(By.id("dragger")), driver.findElement(By.xpath("/html/body/div[2]"))).perform();
        Thread.sleep(2000);
        actions.dragAndDrop(driver.findElement(By.id("dragger")), driver.findElement(By.xpath("//*[@class='item'][last()]"))).perform();
        Thread.sleep(200);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    //输入
    public void sendTest()  {

        try {
            driver.get("http://sahitest.com/demo/label.htm");
            driver.findElements(By.xpath("//input[@type='textbox']")).get(0).sendKeys("admin");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    //窗口切换
    public void windsTest(){
        driver.get("https://www.baidu.com/");
        driver.findElement(By.xpath("//*[@id='u1']/a[last()]")).click();
        System.out.println("xpath(\"//*[@id='u1'][a][last()]\")");
        //百度窗口句柄
        String old=driver.getWindowHandle();
        System.out.println(old);
        driver.findElement(By.xpath("//*[@class='pass-reglink pass-link']")).click();

       //创建list接收窗口句柄，遍历对比是否有旧的句柄
//        List<String> handler = new ArrayList<>();
//        handler.add(driver.getWindowHandles().toString());
//        System.out.println(handler);
//        for (String a:handler){
//            if (!a.equals(old)){
//                System.out.println(old);
//            }else {
//                System.out.println(a);
//            }
//        }
        //新旧窗口切换--遍历旧窗口，与新窗口进行比较
        for (String win:driver.getWindowHandles()){
            if (!win.equals(old)){
                driver.switchTo().window(win);
                System.out.println(win);
            }
        }

        driver.switchTo().window(old);
        driver.findElement(By.xpath("//*[@title='用户名登录']")).click();


        driver.findElement(By.xpath("//*[@name='userName']")).sendKeys("cjb6526875");
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys("17610035090");
    }

    @Test
    //frame切换
    public void framTest(){
        driver.get("https://www.runoob.com/try/try.php?filename=jqueryui-api-droppable");
        //切换到对应的frame
        driver.switchTo().frame("iframeResult");
        //actions.dragAndDrop(driver.findElement(By.xpath("//*[@class='ui-draggable']")), driver.findElement(By.xpath("//*[@id='droppable']")) ).perform();
        System.out.println(driver.findElement(By.xpath("//*[@class='ui-draggable']")).getText());
        //切换回原frame
        driver.switchTo().parentFrame();
        System.out.println(driver.findElement(By.xpath("//*[@id='submitBTN']")).getText());

    }

   // @AfterAll
    //public static void quit(){
      //  driver.quit();
   // }
}