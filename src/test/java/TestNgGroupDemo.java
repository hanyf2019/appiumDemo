import org.testng.annotations.Test;

/**
 * testNGDemo
 * @author ：hanyf
 * @version : v1.0
 * @date ：Created in 2019/7/15
 */
@Test(groups = {"class-group"})
public class TestNgGroupDemo {

    @Test(groups = "group1")
    public void Test1(){
        System.out.println("这是testNG1");
    }

    @Test(groups = "group1")
    public void Test2(){
        System.out.println("这是testNG2");
    }

}
