import junit.framework.TestCase;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * com.nenu.newsManage.AbstractTestCase
 *
 * @author Daydreamer
 * @date 2018/6/25 10:13
 */

//让测试运行于Spring测试环境
@RunWith(SpringJUnit4ClassRunner.class)
//指定Spring配置文件所在位置
@ContextConfiguration(locations = {"classpath*:Spring*.xml"})
public abstract class AbstractTestCase extends TestCase {
}