package com.nenu.newsManage.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nenu.newsManage.entity.Columns;
import com.nenu.newsManage.entity.Essay;
import com.nenu.newsManage.service.ColumnsService;
import com.nenu.newsManage.service.EssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * IndexController
 *
 * @author Daydreamer
 * @date 2018/6/27 15:04
 */

@Controller
@RequestMapping(value = "")
public class IndexController {

    @Autowired
    private EssayService essayService;

    @Autowired
    private ColumnsService columnService;

    /**
     * 去首页，不登录也可以看文章内容
     *
     * @return
     */

    //刚开始啥都不加直接进这个方法，最后返回index.jsp那个页
    @RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
    public String toIndex(//HttpSession request,
                          @RequestParam(required = false, defaultValue = "1") int pageNo,
                          @RequestParam(required = false, defaultValue = "10") int pageSize,
                          @RequestParam(required = false, defaultValue = "1") int columnId,
                          Model model) throws Exception {
        //开始分页，分页参数是页码和每页记录数
        PageHelper.startPage(pageNo, pageSize);
        List<Essay> essayList = essayService.listEssayByColumnId(pageNo,
                                                                 pageSize,
                                                                 columnId);
        //对象列表传入页面
        PageInfo<Essay> page = new PageInfo<Essay>(essayList);

        List<Columns> columnList = columnService.listColumn();
        Columns column = columnService.queryColumnById(columnId);
        model.addAttribute("essayPage", page);
        model.addAttribute("columnList", columnList);
        model.addAttribute("column", column);
        return "index";
    }
}
