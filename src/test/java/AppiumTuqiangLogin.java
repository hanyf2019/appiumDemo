import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import tools.BaseDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * appium--途强APK登录
 * @author ：hanyf
 * @version : v1.0
 * @date ：Created in 2019/7/9
 */
public class AppiumTuqiangLogin {
    private AppiumDriver driver;
    public static Duration duration= Duration.ofMillis(300);//滑动300ms
    public static int width;// 手机屏幕宽
    public static int height;// 手机屏幕长

    @BeforeTest
    public void setUp() throws Exception {
        driver = new BaseDriver().initAndroidDriver("CLB7N18416003445","Android","9",
                "com.jimi.tuqiang","com.jimi.app.SplashActivity");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void tuqiangLogin() throws InterruptedException {

        //向左滑屏
        //获取手机屏幕的宽度
        width= driver.manage().window().getSize().width;
         //获取手机屏幕的高度
        height = driver.manage().window().getSize().height;

        System.out.println("width="+width);
        System.out.println("height="+height);
        System.out.println("width * 3 / 4="+width * 3 / 4);
        System.out.println("height / 2="+height / 2);
        System.out.println("width / 8="+width / 4);
        Thread.sleep(500);

        //滑动页面
        for (int i=0;i<4;i++){
            new TouchAction(driver)
                    .longPress(PointOption.point(width - 100, height / 2))
                    .moveTo(PointOption.point(100, height / 2)).release().perform();
            Thread.sleep(600);
        }
        //点击立即体验按钮
        driver.findElementById("com.jimi.tuqiang:id/into_main_activity").click();
        Thread.sleep(800);
        //获取登录用户名
        driver.findElementById("com.jimi.tuqiang:id/user_account_number").sendKeys("13590314123");
        //获取登录密码
        driver.findElementById("com.jimi.tuqiang:id/user_personal_phone").sendKeys("jimi123");
        //获取勾选记住我
        driver.findElementById("com.jimi.tuqiang:id/password_save_mark").click();
        //获取登录按钮
        driver.findElementById("com.jimi.tuqiang:id/user_button_login").click();
        Thread.sleep(1500);
        //如何添加设备--跳过按钮
        driver.findElementById("com.jimi.tuqiang:id/cancel_add_device").click();
        Thread.sleep(1000);
        //点击我的
        driver.findElementById("com.jimi.tuqiang:id/main_rb_me").click();
        Thread.sleep(500);
        //点击用户名
        driver.findElementById("com.jimi.tuqiang:id/mine_icon_layout").click();
        Thread.sleep(500);
        //点击退出按钮
        driver.findElementById("com.jimi.tuqiang:id/mine_exit_bt").click();
        Thread.sleep(500);
        //点击退出确认按钮
        driver.findElementById("com.jimi.tuqiang:id/views_ok").click();
        Thread.sleep(500);
    }

    @Test(enabled = false)
    public void simLogin() throws InterruptedException {
        //获取登录用户名
        driver.findElementById("com.jimi.smarthome:id/app_login_account_phone").sendKeys("13590314123");

        driver.findElementById("com.jimi.smarthome:id/app_login_get_verlicode").click();

        Thread.sleep(2000);
        //获取登录密码
        driver.findElementById("com.jimi.smarthome:id/app_login_code").sendKeys("88888");

        //获取登录按钮
        driver.findElementById("com.jimi.smarthome:id/app_login_login_bt").click();

    }

    @AfterTest
    public void tearDown() throws Exception
    {
        driver.quit();
    }
}
