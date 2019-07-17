import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.URL;
/**
 * appium自动化测试DEMO---计算器
 * @author ：hanyf
 * @version : v1.0
 * @date ：Created in 2019/7/8
 */
public class AppiumCalculator {

    private AppiumDriver driver;

    @BeforeTest
    public  void setUp() throws Exception {
        //启动appium
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(CapabilityType.BROWSER_NAME, "");
        cap.setCapability("platformName", "Android"); //指定测试平台
        cap.setCapability("deviceName", "CLB7N18416003445"); //指定测试机的ID,通过adb命令`adb devices`获取
        cap.setCapability("platformVersion", "9");

        //将上面获取到的包名和Activity名设置为值
        cap.setCapability("appPackage", "com.android.calculator2");
        cap.setCapability("appActivity", "com.android.calculator2.Calculator");

        //A new session could not be created的解决方法
        cap.setCapability("appWaitActivity","com.android.calculator2.Calculator");
        //每次启动时覆盖session，否则第二次后运行会报错不能新建session
        cap.setCapability("sessionOverride", true);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
    }

    @Test
    public void testplus() {
        //获取9
        driver.findElementById("com.android.calculator2:id/digit_9").click();
        //获取乘
        driver.findElementById("com.android.calculator2:id/op_mul").click();
        //获取5
        driver.findElementById("com.android.calculator2:id/digit_5").click();
        //获取=
        driver.findElementById("com.android.calculator2:id/eq").click();
        //fail("Not yet implemented");
    }

    @AfterClass
    public void tearDown() throws Exception
    {
        driver.quit();
    }

}
