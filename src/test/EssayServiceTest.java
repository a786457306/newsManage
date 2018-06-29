import com.nenu.newsManage.entity.Essay;
import com.nenu.newsManage.service.ColumnsService;
import com.nenu.newsManage.service.EssayService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Embedded;
import java.util.List;

/**
 * EssayServiceTest
 *
 * @author Daydreamer
 * @date 2018/6/26 17:47
 */
public class EssayServiceTest extends AbstractTestCase {

    @Autowired
    private EssayService essayService;

    @Test
    public void newEssay() throws Exception {
        Essay essay = new Essay();
        essay.setEssayName("哼哼哼");
        essay.setEssayContent("123abcdefrgas");
        essay.setColumnId(2);
        essay.setEssayState(1);

        essayService.newEssay(essay);
        System.out.println(essay.getColumnName());
    }

    @Test
    public void delEssay() throws Exception {
        essayService.delEssay(3);
    }

    @Test
    public void delEssayByColumnId() throws Exception {
        essayService.delEssayByColumnId(2);
    }

    @Test
    public void updateEssay() throws Exception {
        Essay essay = new Essay();
        essay.setEssayId(3);
        essay.setEssayName("anbcd");
        essay.setEssayContent("djaf32dsjkldfas");
        essay.setColumnId(1);
        essay.setEssayState(1);

        essayService.updateEssay(essay);
        System.out.println(essay.getColumnName());
    }

    @Test
    public void listEssay() throws Exception {

        List<Essay> essayList = essayService.listEssay(1, 5);
        for (Essay essay : essayList){
            System.out.println(essay.getEssayName() + " " + essay.getColumnName());
        }
    }

    @Test
    public void queryEssayById() throws Exception {
        Essay essay = essayService.queryEssayById(3);
        System.out.println(essay.getEssayName());
    }

    @Test
    public void listEssayByColumnId() throws Exception {
        List<Essay> essayList = essayService.listEssayByColumnId(2, 5, 2);
        for (Essay essay : essayList){
            System.out.println(essay.getEssayName() + " " + essay.getColumnName());
        }
    }
}
