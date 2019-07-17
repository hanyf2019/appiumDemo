import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

/**
 * TestNG-Demo1
 * @author ：hanyf
 * @version : v1.0
 * @date ：Created in 2019/7/16
 */
public class TestNGDemo {

    @Test
    public void test1(){

        Assert.assertEquals(1,1);
    }

    @Test
    public void test2(){
        Assert.assertEquals("aaa","aaa");
    }

}
