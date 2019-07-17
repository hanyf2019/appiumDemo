import com.vimalselvam.testng.SystemInfo;
import org.testng.collections.Maps;

import java.util.Map;

/**
 * @author ：hanyf
 * @version : v1.0
 * @date ：Created in 2019/7/16
 */
public class DemoSystemInfo implements SystemInfo {

    @Override
    public Map<String, String> getSystemInfo() {
        Map<String, String> systemInfo = Maps.newHashMap();
        systemInfo.put("os","win7");
        systemInfo.put("浏览器","Chrome");
        systemInfo.put("测试版本","V1.0");
        systemInfo.put("测试人员","kelsey");
        return systemInfo;
    }
}
