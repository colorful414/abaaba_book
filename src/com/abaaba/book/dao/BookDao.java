package com.abaaba.book.dao;
import java.util.List;

import com.abaaba.book.bean.Book;
import com.abaaba.book.bean.PageBean;
public interface BookDao {
    // 获取图书总数
    long bookReadCount();

    // 获取图书分页列表(视图)
    List<Book> bookList(PageBean pageBean);

    // 按分类获取图书数量
    long bookReadCount(int catalogId);
//    // 按分类获取图书数量
//    long bookSortCount(int num);
//    long bookSearchCount(int bookName);
    // 按分类获取图书分页列表(视图)
    List<Book> bookList(PageBean pageBean, int catalogId);
    // 获取搜索图书(视图)
    List<Book> bookSearch(String bookName);
    // 获取新品图书(视图)
    List<Book> newBook(int num);
    // 获取优惠图书(视图)
    List<Book> preBook(int num);
    // 获取优惠图书(视图)
    List<Book> bestBook(int num);
    // 增加图书
    boolean bookAdd(Book book);

    // 根据图书id查找图书信息(视图)
    Book findBookById(int bookId);

    // 根据图书名称查找图书是否存在
    boolean findBookByBookName(String bookName);

    // 更新图书信息
    boolean bookUpdate(Book book);

    // 根据id删除图书
    boolean bookDelById(int bookId);

    // 根据id串查询图片id串
    String findimgIdByIds(String ids);

    // 批量删除图书
    boolean bookBatDelById(String ids);

    // 随机获取指定数量书
    List<Book> bookList(int num);

    // 获取指定数量新添加的图书
    List<Book> newBooks(int num);



}
