package com.abaaba.book.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.abaaba.book.bean.Book;
import com.abaaba.book.bean.PageBean;
import com.abaaba.book.dao.BookDao;
import com.abaaba.book.util.DateUtil;
import com.abaaba.book.util.DbUtil;

public class BookDaoImpl implements BookDao {
    @Override
    public List<Book> bookList(PageBean pageBean) {
        List<Book> list = new ArrayList<>();

        String sql = "select * from view_book limit ?,?";
        // 查询的分页结果集
        List<Map<String, Object>> lm = DbUtil.executeQuery(sql, (pageBean.getCurPage() - 1) * pageBean.getMaxSize(),
                pageBean.getMaxSize());

        // 把查询的book结果由List<Map<String, Object>>转换为List<Book>
        if (lm.size() > 0) {
            for (Map<String, Object> map : lm) {
                Book book = new Book(map);
                list.add(book);
            }
        }

        return list;
    }

    @Override
    public long bookReadCount() {
        String sql = "select count(*) as count from s_book";
        List<Map<String, Object>> lm = DbUtil.executeQuery(sql);
        return lm.size() > 0 ? (long) lm.get(0).get("count") : 0;
    }

    @Override
    public boolean bookAdd(Book book) {
        String sql = "insert into s_book(bookName,catalogId,author,press,price,description,imgId,addTime) values(?,?,?,?,?,?,?,?)";

        int i = DbUtil.excuteUpdate(sql, book.getBookName(), book.getCatalog().getCatalogId(), book.getAuthor(),
                book.getPress(), book.getPrice(), book.getDescription(), book.getUpLoadImg().getImgId(),
                DateUtil.getTimestamp());

        return i > 0 ? true : false;
    }

    @Override
    public Book findBookById(int bookId) {
        String sql = "select * from view_book where bookId=?";
        Book book = null;
        List<Map<String, Object>> list = DbUtil.executeQuery(sql, bookId);
        if (list.size() > 0) {
            book = new Book(list.get(0));
        }
        return book;
    }

    /**
     *
     */
    @Override
    public boolean findBookByBookName(String bookName) {
        String sql = "select * from s_book where bookName=?";
        List<Map<String, Object>> list = DbUtil.executeQuery(sql, bookName);
        return list.size() > 0 ? true : false;
    }

    /**
     * 更新图书信息
     */
    @Override
    public boolean bookUpdate(Book book) {
        String sql = "update s_book set catalogId=?,author=?,press=?,price=?,description=? where bookId=?";
        int i = DbUtil.excuteUpdate(sql, book.getCatalogId(), book.getAuthor(), book.getPress(), book.getPrice(),
                book.getDescription(), book.getBookId());
        return i > 0 ? true : false;
    }

    /**
     * 图书删除
     */
    @Override
    public boolean bookDelById(int bookId) {
        String sql = "delete from s_book where bookId=?";
        int i = DbUtil.excuteUpdate(sql, bookId);
        return i > 0 ? true : false;
    }

    /**
     * 批量查询
     */
    @Override
    public String findimgIdByIds(String ids) {
        String imgIds = "";
        String sql = "select imgId from s_book where bookId in(" + ids + ")";
        List<Map<String, Object>> list = DbUtil.executeQuery(sql);
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                if (i != list.size() - 1) {
                    imgIds += list.get(i).get("imgId") + ",";
                } else {
                    imgIds += list.get(i).get("imgId");
                }
            }
        }
        return imgIds;
    }

    // 批量删除
    @Override
    public boolean bookBatDelById(String ids) {
        String sql = "delete from s_book where bookId in(" + ids + ")";
        int i = DbUtil.excuteUpdate(sql);
        return i > 0 ? true : false;
    }

    // 随机查询一定数量的书
    @Override
    public List<Book> bookList(int num) {

        List<Book> list = new ArrayList<>();
        String sql = "select * from view_book order by rand() LIMIT ?";
        List<Map<String, Object>> lm = DbUtil.executeQuery(sql, num);
        // 把查询的book结果由List<Map<String, Object>>转换为List<Book>
        if (lm.size() > 0) {
            for (Map<String, Object> map : lm) {
                Book book = new Book(map);
                list.add(book);
            }
        }
        return list;
    }

    /**
     * 查询指定数量新书
     */
    @Override
    public List<Book> newBooks(int num) {
        List<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM view_book ORDER BY addTime desc limit 0,?";
        List<Map<String, Object>> lm = DbUtil.executeQuery(sql, num);
        // 把查询的book结果由List<Map<String, Object>>转换为List<Book>
        if (lm.size() > 0) {
            for (Map<String, Object> map : lm) {
                Book book = new Book(map);
                list.add(book);
            }
        }
        return list;
    }

    /**
     * 按分类id统计图书数量
     */
    @Override
    public long bookReadCount(int catalogId) {
        String sql = "select count(*) as count from s_book where catalogId=?";
        List<Map<String, Object>> lm = DbUtil.executeQuery(sql, catalogId);
        return lm.size() > 0 ? (long) lm.get(0).get("count") : 0;
    }
    /**
     * 按分类页面统计图书数量
     */
//    @Override
//    public long bookSortCount(int num) {
//        String sql = "select count(*) as count from s_book ";
//        List<Map<String, Object>> lm = DbUtil.executeQuery(sql, num);
//        return lm.size() > 0 ? (long) lm.get(0).get("count") : 0;
//    }
    /**
     * 按搜索结果统计图书数量
     */
//    @Override
//    public long bookSearchCount(int bookName) {
//        String sql = "select count(*) as count from s_book where bookName=?";
//        List<Map<String, Object>> lm = DbUtil.executeQuery(sql, bookName);
//        return lm.size() > 0 ? (long) lm.get(0).get("count") : 0;
//    }

    /**
     * 按分类id获取图书列表
     */
    @Override
    public List<Book> bookList(PageBean pageBean, int catalogId) {
        List<Book> list = new ArrayList<>();

        String sql = "select * from view_book where catalogId=? limit ?,?";
        // 查询的分页结果集
        List<Map<String, Object>> lm = DbUtil.executeQuery(sql, catalogId,
                (pageBean.getCurPage() - 1) * pageBean.getMaxSize(), pageBean.getMaxSize());

        // 把查询的book结果由List<Map<String, Object>>转换为List<Book>
        if (lm.size() > 0) {
            for (Map<String, Object> map : lm) {
                Book book = new Book(map);
                list.add(book);
            }
        }
        return list;
    }



    /**
     * 按搜索结果获取图书
     */
    @Override
    public List<Book> bookSearch(String bookName) {
        List<Book> list = new ArrayList<>();
        String sql = "select * from view_book where bookName like '%" + bookName + "%'";
        List<Map<String, Object>> lm = DbUtil.executeQuery(sql);
          if (lm.size() > 0) {
            for (Map<String, Object> map : lm) {
                Book book = new Book(map);
                list.add(book);
              }
          }
        return list;
    }
    // 查询最新上架的书
    @Override
    public List<Book> newBook(int num) {
        List<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM view_book ORDER BY addTime desc limit 0,?";
        List<Map<String, Object>> lm = DbUtil.executeQuery(sql, num);
        // 把查询的book结果由List<Map<String, Object>>转换为List<Book>
        if (lm.size() > 0) {
            for (Map<String, Object> map : lm) {
                Book book = new Book(map);
                list.add(book);
            }
        }
        return list;
    }
    // 查询最优惠的书
    @Override
    public List<Book> preBook(int num) {
        List<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM view_book ORDER BY price asc limit 0,?";
        List<Map<String, Object>> lm = DbUtil.executeQuery(sql, num);
        // 把查询的book结果由List<Map<String, Object>>转换为List<Book>
        if (lm.size() > 0) {
            for (Map<String, Object> map : lm) {
                Book book = new Book(map);
                list.add(book);
            }
        }
        return list;
    }
    // 查询最畅销的书
    @Override
    public List<Book> bestBook(int num) {
        List<Book> list = new ArrayList<>();
        String sql = "SELECT view_book.* FROM view_book,view_order WHERE view_book.bookId=view_order.bookId  ORDER BY view_order.quantity desc limit 0,?";
        List<Map<String, Object>> lm = DbUtil.executeQuery(sql, num);
        // 把查询的book结果由List<Map<String, Object>>转换为List<Book>
        if (lm.size() > 0) {
            for (Map<String, Object> map : lm) {
                Book book = new Book(map);
                list.add(book);
            }
        }
        return list;
    }
}
