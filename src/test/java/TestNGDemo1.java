import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

/**
 * TestNG-Demo1
 * @author ：hanyf
 * @version : v1.0
 * @date ：Created in 2019/7/16
 */
public class TestNGDemo1 {

    @Test
    public void test1(){
        Assert.assertEquals(1,2);
    }

    @Test
    public void test2(){
        Assert.assertEquals(1,1);
    }

    @Test
    public void test3(){
        Assert.assertEquals("aaa","aaa");
    }

    @Test
    public void logDemo(){
        Reporter.log("自己定义的异常־");
        throw new RuntimeException("自己抛出的异常");

    }

}
