package com.nenu.newsManage.filter;

import com.nenu.newsManage.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * LoginFilter
 *
 * @author Daydreamer
 * @date 2018/6/27 15:31
 */

public class LoginFilter implements Filter {

    private FilterConfig filterConfig;

    public void init(FilterConfig filterConfig) {
        System.out.println("初始化");
        this.filterConfig = filterConfig;
    }

    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException{
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        HttpSession session = servletRequest.getSession();
        User user = (User)session.getAttribute("user");
        if (user == null || user.getUserName() == "" || user.getUserName() == null){
            servletResponse.sendRedirect(((HttpServletRequest) request).getContextPath() + "/login");
            System.out.println("没有访问权限");
        }
        chain.doFilter(request, response);//发送请求，接收反馈
    }

    public void destroy(){
        System.out.println("销毁filter");
    }
}
