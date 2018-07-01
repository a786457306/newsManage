package com.nenu.newsManage.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nenu.newsManage.entity.Columns;
import com.nenu.newsManage.entity.Essay;
import com.nenu.newsManage.service.ColumnsService;
import com.nenu.newsManage.service.EssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * ColumnController
 *
 * @author Daydreamer
 * @date 2018/6/29 18:36
 */
@Controller
@RequestMapping(value = "admin")
public class AdminController {

    @Autowired
    private ColumnsService columnService;

    @Autowired
    private EssayService essayService;

    /**
     * 显示栏目列表
     *
     * @param pageNo
     * @param pageSize
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/listColumn", method = RequestMethod.GET)
    public String toColumnList(@RequestParam(required = false, defaultValue = "1") int pageNo,
                               @RequestParam(required = false, defaultValue = "10") int pageSize,
                               Model model) throws Exception {
        PageHelper.startPage(pageNo, pageSize);
        List<Columns> columnList = columnService.listColumn();
        PageInfo<Columns> page = new PageInfo<>(columnList);

        model.addAttribute("columnPage", page);
        return "admin/listColumn";
    }

    /**
     * 去新增栏目页
     *
     * @return
     */
    @RequestMapping(value = "/newColumn", method = RequestMethod.GET)
    public String toNewColumn(){
        return "admin/newColumn";
    }

    /**
     * 新增栏目
     *
     * @param column
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/newColumn", method = RequestMethod.POST)
    public String newColumn(Columns column,
                            @RequestParam(required = false, defaultValue = "1") int pageNo,
                            @RequestParam(required = false, defaultValue = "10") int pageSize,
                            Model model) throws Exception {
        if (!columnService.checkColumn(column.getColumnName())) {
            columnService.newColumn(column);
            PageHelper.startPage(pageNo, pageSize);
            List<Columns> columnList = columnService.listColumn();
            PageInfo<Columns> page = new PageInfo<>(columnList);

            model.addAttribute("columnPage", page);
            return "admin/listColumn";
        } else {
            model.addAttribute("existedError", "栏目已存在");
            return "admin/newColumn";
        }
    }

    /**
     * 删除栏目
     *
     * @param columnId
     * @param pageNo
     * @param pageSize
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/delColumn")
    public String delColumn(int columnId,
                            @RequestParam(required = false, defaultValue = "1") int pageNo,
                            @RequestParam(required = false, defaultValue = "10") int pageSize,
                            Model model) throws Exception {
        columnService.delColumn(columnId);
        essayService.delEssayByColumnId(columnId);
        PageHelper.startPage(pageNo, pageSize);
        List<Columns> columnList = columnService.listColumn();
        PageInfo<Columns> page = new PageInfo<>(columnList);

        model.addAttribute("columnPage", page);
        return "admin/listColumn";
    }

    /**
     * 去修改栏目页
     *
     * @param columnId
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/updateColumn")
    public String toUpdateColumn(int columnId,
                                 Model model) throws Exception {
        Columns column = columnService.queryColumnById(columnId);
        model.addAttribute("column", column);
        return "admin/updateColumn";
    }

    /**
     * 修改栏目
     *
     * @param column
     * @param pageNo
     * @param pageSize
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/updateColumn", method = RequestMethod.POST)
    public String updateColumn(Columns column,
                               @RequestParam(required = false, defaultValue = "1") int pageNo,
                               @RequestParam(required = false, defaultValue = "10") int pageSize,
                               Model model) throws Exception {
        if (!columnService.checkColumn(column.getColumnName())) {
            columnService.updateColumn(column);
            PageHelper.startPage(pageNo, pageSize);
            List<Columns> columnList = columnService.listColumn();
            PageInfo<Columns> page = new PageInfo<>(columnList);
            model.addAttribute("columnPage", page);
            return "admin/listColumn";
        } else {
            model.addAttribute("existedError", "栏目已存在");
            return "admin/updateColumn";
        }
    }

    /**
     * 去文章列表页
     *
     * @param pageNo
     * @param pageSize
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/listEssay", method = RequestMethod.GET)
    public String toEssayList(@RequestParam(required = false, defaultValue = "1") int pageNo,
                              @RequestParam(required = false, defaultValue = "10") int pageSize,
                              Model model) throws Exception {
        PageHelper.startPage(pageNo, pageSize);
        List<Essay> essayList = essayService.listEssay(pageNo, pageSize);
        PageInfo<Essay> page = new PageInfo<>(essayList);

        model.addAttribute("essayPage", page);
        return "admin/listEssay";
    }

    /**
     * 去新增文章页
     *
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/newEssay")
    public String toNewEssay(Model model) throws Exception {
        List<Columns> columnList = columnService.listColumn();
        model.addAttribute("columnList", columnList);
        return "admin/newEssay";
    }

    /**
     * 新增文章
     *
     * @param essay
     * @param pageNo
     * @param pageSize
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/newEssay", method = RequestMethod.POST)
    public String newEssay(Essay essay,
                           @RequestParam(required = false, defaultValue = "1") int pageNo,
                           @RequestParam(required = false, defaultValue = "10") int pageSize,
                           Model model)throws Exception {
        essayService.newEssay(essay);
        PageHelper.startPage(pageNo, pageSize);
        List<Essay> essayList = essayService.listEssay(pageNo, pageSize);
        PageInfo<Essay> page = new PageInfo<>(essayList);

        model.addAttribute("essayPage", page);
        return "admin/listEssay";
    }

    /**
     * 删除文章
     *
     * @param essayId
     * @param pageNo
     * @param pageSize
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "delEssay")
    public String delEssay(int essayId,
                           @RequestParam(required = false, defaultValue = "1") int pageNo,
                           @RequestParam(required = false, defaultValue = "10") int pageSize,
                           Model model)throws Exception {

        essayService.delEssay(essayId);
        PageHelper.startPage(pageNo, pageSize);
        List<Essay> essayList = essayService.listEssay(pageNo, pageSize);
        PageInfo<Essay> page = new PageInfo<>(essayList);

        model.addAttribute("essayPage", page);
        return "admin/listEssay";
    }

    /**
     * 去更新文章页
     *
     * @param essayId
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/updateEssay", method = RequestMethod.GET)
    public String toUpdateEssay(int essayId,
                                Model model)throws Exception {
        List<Columns> columnList = columnService.listColumn();
        Essay essay = essayService.queryEssayById(essayId);
        model.addAttribute("columnList", columnList);
        model.addAttribute("essay", essay);
        return "admin/updateEssay";
    }

    /**
     * 更新文章
     *
     * @param essay
     * @param pageNo
     * @param pageSize
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/updateEssay", method = RequestMethod.POST)
    public String updateEssay(Essay essay,
                              @RequestParam(required = false, defaultValue = "1") int pageNo,
                              @RequestParam(required = false, defaultValue = "10") int pageSize,
                              Model model)throws Exception {
        essayService.updateEssay(essay);
        PageHelper.startPage(pageNo, pageSize);
        List<Essay> essayList = essayService.listEssay(pageNo, pageSize);
        PageInfo<Essay> page = new PageInfo<>(essayList);

        model.addAttribute("essayPage", page);
        return "admin/listEssay";
    }
}
