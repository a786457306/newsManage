package com.nenu.newsManage.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nenu.newsManage.entity.Columns;
import com.nenu.newsManage.entity.Essay;
import com.nenu.newsManage.entity.User;
import com.nenu.newsManage.service.ColumnsService;
import com.nenu.newsManage.service.EssayService;
import com.nenu.newsManage.service.UserService;
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

    @Autowired
    private UserService userService;

    /**
     * 去首页，不登录直接查看网站内容
     *
     * @param pageNo
     * @param pageSize
     * @param columnId
     * @param model
     * @return
     * @throws Exception
     */
    //刚开始啥都不加直接进这个方法，最后返回index.jsp那个页
    @RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
    public String toIndex(@RequestParam(required = false, defaultValue = "1") int pageNo,
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

    /**
     * 点击文章名跳转文章具体内容
     *
     * @param essayId
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "essayDetail", method = RequestMethod.GET)
    public String toEssayDetail(@RequestParam("essayId") int essayId,
                                Model model) throws Exception{
        List<Columns> columnList = columnService.listColumn();
        Essay essay = essayService.queryEssayById(essayId);
        model.addAttribute("columnList", columnList);
        model.addAttribute("essay", essay);
        return "essayDetail";
    }

    /**
     * 去注册页
     *
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "signIn", method = RequestMethod.GET)
    public String toSignIn(Model model) throws Exception{
        List<Columns> columnList = columnService.listColumn();
        model.addAttribute("columnList", columnList);

        return "signIn";
    }

    /**
     * 用户注册
     *
     * @param user
     * @param request
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "signIn", method = RequestMethod.POST)
    public String signIn(User user,
                         HttpServletRequest request,
                         Model model) throws Exception {
            List<Columns> columnList = columnService.listColumn();
            model.addAttribute("columnList", columnList);

            //数据库中没有同名的，说明没注册过，注册成功并返回登录页
            if (userService.checkUserName(user.getUserName())) {
                userService.newUser(user);
                model.addAttribute("signInSuccessful", "注册成功，请登录！");
                request.getSession().setAttribute("user", user);
                return "login";
            }
            //用户名和密码都相同，直接登录
            if(userService.checkLogin(user)) {
                model.addAttribute("signedError","您已注册过，请直接登录！");
                request.getSession().setAttribute("user", user);
                return "signIn";
            }
            //只用户名相同，弹框提示，重新填。
            if(!userService.checkUserName(user.getUserName())) {
                model.addAttribute("userNameError","用户名已存在！");
                request.getSession().setAttribute("user", user);
                return "signIn";
            }
            return "login";
    }

    /**
     * 去登录页
     *
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String toLogin(Model model) throws Exception {
        List<Columns> columnList = columnService.listColumn();
        model.addAttribute("columnList", columnList);

        return "login";
    }

    /**
     * 用户登录
     *
     * @param user
     * @param model
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(User user,
                        Model model,
                        HttpServletRequest request) throws Exception {
        List<Columns> columnList = columnService.listColumn();
        model.addAttribute("columnList", columnList);
        //登录成功
        if (userService.checkLogin(user)) {
            request.getSession().setAttribute("user", user);
            return "admin/index";
        } else {
            model.addAttribute("loginError", "用户名或密码错误！");
            return "login";
        }
    }

    /**
     * 退出登录，注销用户session
     *
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "logout")
    public String logout(HttpSession session,
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
        session.invalidate();
        return "index";
    }

}
