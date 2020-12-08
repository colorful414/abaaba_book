package com.abaaba.book.servlet.book;


import com.abaaba.book.bean.User;
import com.abaaba.book.dao.UserDao;
import com.abaaba.book.dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "InfoServlet", urlPatterns = { "/InfoServlet" })
public class InfoServlet extends HttpServlet{
    private static final String USEREDIT_PATH="/jsp/book/myinfo.jsp";
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user=new User(
                Integer.parseInt(request.getParameter("userId")),
                request.getParameter("passWord"),
                request.getParameter("name"),
                request.getParameter("sex"),
                Integer.parseInt(request.getParameter("age")),
                request.getParameter("tell"),
                request.getParameter("address"),
                request.getParameter("enabled"));
        UserDao ud=new UserDaoImpl();
        if(ud.userUpdate(user)) {
            request.setAttribute("userMessage", "用户更新成功");
            request.getRequestDispatcher(USEREDIT_PATH).forward(request, response);
        }else {
            //更新失败跳转到修改页面
            request.setAttribute("userMessage", "用户更新失败");
            request.setAttribute("userInfo", ud.findUser(Integer.valueOf(user.getUserId())));//这里回去是Admin对象
            request.getRequestDispatcher(USEREDIT_PATH).forward(request, response);
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
