import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author cuijingbo
 * @date 2021/2/5 11:27
 */
public class BaseTest {
    public static WebDriver driver;

    public static void  initData(){
        String browserName=System.getenv("browser");
        //跟进传入的浏览器名称，选择不同的driver
        if("chorme".equals(browserName)){
            System.setProperty("webdriver.chrome.driver", "D:\\BrowserDriver\\chromedriver.exe");
            driver=new ChromeDriver();
        }else if("firefox".equals(browserName)){
            System.setProperty("webdriver.firefox.driver", "D:\\BrowserDriver\\geckdriver.exe");
            driver=new FirefoxDriver();
        }
    }

    @AfterAll
    public static void tearDown(){
        driver.quit();
    }
}
