import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @author cuijingbo
 * @date 2021/3/16 15:31
 */
public class DeviceTest {
    public static AndroidDriver driver;

    @BeforeAll
    public static void initData() throws Exception {
        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setCapability("platformName","Android");
        caps.setCapability("udid","127.0.0.1:7555");
        caps.setCapability("deviceName","appium");
        driver=new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"),caps);//appium端口号
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void sendSms()  {
        //driver.makeGsmCall("5551234567", GsmCallActions.CALL);
        //Thread.sleep(5000);
        //driver.sendSMS("555-123-4567","发送短信测试");
        driver.lockDevice();
    }

}
