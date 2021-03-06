package com.abaaba.book.servlet.book;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abaaba.book.bean.Catalog;
import com.abaaba.book.dao.BookDao;
import com.abaaba.book.dao.CatalogDao;
import com.abaaba.book.dao.impl.BookDaoImpl;
import com.abaaba.book.dao.impl.CatalogDaoImpl;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class GetCatalog
 */
@WebServlet("/GetCatalog")
public class GetCatalog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json");
		response.setCharacterEncoding("utf-8");

		JSONObject json = new JSONObject();

		CatalogDao cd=new CatalogDaoImpl();
		BookDao bd=new BookDaoImpl();
		List<Catalog> catalog = cd.getCatalog();
		
		//这里返回查询每个分类的数量
		for(int i=0;i<catalog.size();i++) {
			Catalog c = catalog.get(i);
			long size=bd.bookReadCount(c.getCatalogId());
			c.setCatalogSize(size);
		}
		json.put("catalog", catalog);
//		response.getWriter().append(json.toString());
		PrintWriter pw = response.getWriter();
		pw.print(json.toString());
		pw.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
