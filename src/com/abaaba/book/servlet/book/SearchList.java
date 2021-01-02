package com.abaaba.book.servlet.book;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abaaba.book.bean.Book;
import com.abaaba.book.bean.PageBean;
import com.abaaba.book.dao.BookDao;
import com.abaaba.book.dao.impl.BookDaoImpl;

/**
 * Servlet implementation class BookList
 */
@WebServlet("/SearchList")
public class SearchList extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final int MAX_LIST_SIZE = 12;
    private static final String BOOKSEARCH_PATH="jsp/book/booksearch.jsp";


    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        bookSearch(request,response);
    }

    private void bookSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookName = request.getParameter("bookName");//获取搜索内容
        BookDao bd = new BookDaoImpl();
        List<Book>bookSearch=bd.bookSearch(bookName);
//        int curPage = 1;
//        String page = request.getParameter("page");
//        if (page != null) {
//            curPage = Integer.parseInt(page);
//        }
//        PageBean pb=null;
//
//        if(bookNameStr!=null) {
//            int bookName=Integer.parseInt(bookNameStr);
//            pb = new PageBean(curPage, MAX_LIST_SIZE, bd.bookSearchCount(bookName));
//            bookSearch = bd.bookSearch(pb,bookName);
//
//            if(bookSearch.size()>0) {
//                request.setAttribute("title", bookSearch.get(0).getCatalog().getCatalogName());//从返回的分类集合中第一个获取数据的分类
//            }
//
//        }else {
//            pb = new PageBean(curPage, MAX_LIST_SIZE, bd.bookSearchCount());
//            bookSearch = bd.bookList(pb);
//            request.setAttribute("title", "所有图书");
//        }
//        request.setAttribute("pageBean", pb);
        request.setAttribute("bookSearch",bookSearch);

        request.getRequestDispatcher(BOOKSEARCH_PATH).forward(request, response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
