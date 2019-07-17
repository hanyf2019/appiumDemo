import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * 驱动封装基础类
 * @author ：hanyf
 * @version : v1.0
 * @date ：Created in 2019/7/15
 */
public class BaseDriver {

    private AppiumDriver driver;

    /**
     * 初始化安装驱动
     * @param deviceName 设备名称
     * @param platformName 系统类型
     * @param platformVersion 系统版本号
     * @param appPackage APP包名
     * @param appActivity APP主线程
     * @return
     */
    public AppiumDriver initAndroidDriver(String deviceName,String platformName,String platformVersion,String appPackage,String appActivity) {
        try {
            //启动appium
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("deviceName", deviceName);
            capabilities.setCapability("platformName", platformName);
            capabilities.setCapability("platformVersion", platformVersion);

            //配置测试apk
            capabilities.setCapability("appPackage", appPackage);
            capabilities.setCapability("appActivity", appActivity);
            capabilities.setCapability("sessionOverride", true);    //每次启动时覆盖session，否则第二次后运行会报错不能新建session
            capabilities.setCapability("unicodeKeyboard", true);    //设置键盘 支持中文输入
            capabilities.setCapability("resetKeyboard", "false");     //设置默认键盘为appium的键盘
            driver = new AppiumDriver(new URL("http://localhost:4723/wd/hub"), capabilities);//虚拟机默认地址
            capabilities.setCapability("newCommandTimeout", "10");//没有新命令时的超时时间设置
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}