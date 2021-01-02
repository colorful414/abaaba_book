package com.abaaba.book.servlet.book;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.abaaba.book.bean.*;
import com.abaaba.book.dao.BookDao;
import com.abaaba.book.dao.OrderDao;
import com.abaaba.book.dao.UserDao;
import com.abaaba.book.dao.impl.AdminDaoImpl;
import com.abaaba.book.dao.impl.BookDaoImpl;
import com.abaaba.book.dao.impl.OrderDaoImpl;
import com.abaaba.book.dao.impl.UserDaoImpl;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class UserManage
 */
@WebServlet("/SortServlet")
public class SortServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String NEWBOOK_PATH="jsp/book/newbook.jsp";
    private static final String PREBOOK_PATH="jsp/book/prebook.jsp";
    private static final String BESTBOOK_PATH="jsp/book/bestbook.jsp";

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action=request.getParameter("action");
        switch(action){
            case "newBook":
                newBook(request,response);
                break;
            case "preference":
                preference(request,response);
                break;
            case "bestSell":
                bestSell(request,response);
                break;
        }
    }



    //新书分类
    private void newBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDao bd = new BookDaoImpl();

        List<Book>newBook=bd.newBook(12);
        request.setAttribute("newBook",newBook);
        request.getRequestDispatcher(NEWBOOK_PATH).forward(request, response);
    }
    //优惠分类
    private void preference(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDao bd = new BookDaoImpl();

        List<Book>preBook=bd.preBook(12);
        request.setAttribute("preBook",preBook);
        request.getRequestDispatcher(PREBOOK_PATH).forward(request, response);
    }
    //畅销分类
    private void bestSell(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDao bd = new BookDaoImpl();
        List<Book>bestBook=bd.bestBook(12);
        request.setAttribute("bestBook",bestBook);
        OrderItem oItem=new OrderItem();
        long orderSell = oItem.getQuantity();
        request.setAttribute("orderSell",orderSell);
//        String orderSell2 =oItem.getQuantity() +"";
//        request.setAttribute("orderSell2",orderSell2);
        request.getRequestDispatcher(BESTBOOK_PATH).forward(request, response);
    }
}
