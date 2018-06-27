import com.nenu.newsManage.entity.Columns;
import com.nenu.newsManage.service.ColumnsService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * ColumnServiceTest
 *
 * @author Daydreamer
 * @date 2018/6/25 15:46
 */
public class ColumnServiceTest extends AbstractTestCase {

    @Autowired
    private ColumnsService columnsService;

    @Test
    public void newColumn() throws Exception {
        Columns column = new Columns();
        column.setColumnName("组织机构");
        column.setColumnState(1);

        columnsService.newColumn(column);
    }

    @Test
    public void delColumn() throws Exception {
        columnsService.delColumn(2);
    }

    @Test
    public void updateColumn() throws Exception {
        Columns column = new Columns();
        column.setColumnId(2);
        column.setColumnName("组织机构");
        column.setColumnState(1);
        columnsService.updateColumn(column);
    }

    @Test
    public void listColumn() throws Exception {
        List<Columns> columnsList = columnsService.listColumn();
        for (Columns column : columnsList){
            System.out.println(column.getColumnId() + " " + column.getColumnName());
        }
    }

    @Test
    public void queryColumnById() throws Exception {
        Columns column = columnsService.queryColumnById(1);
        System.out.println(column.getColumnId() + " " + column.getColumnName());
    }
}
