import org.junit.jupiter.api.Test;

/**
 * @author cuijingbo
 * @date 2021/2/5 11:25
 */
//多浏览器支持
public class BrowserTest extends BaseTest{

    @Test
    public static void browserTest() {
        driver.get("https://www.baidu.com/");
    }

}
