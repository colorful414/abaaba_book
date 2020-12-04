package com.abaaba.book.dao;
import java.util.List;

import com.abaaba.book.bean.Catalog;
import com.abaaba.book.bean.PageBean;
public interface CatalogDao {
    //获取图书分类信息
    List<Catalog> getCatalog();
    //获取图书分类信息（分页）
    List<Catalog> catalogList(PageBean pb);
    //统计总数
    long catalogReadCount();
    //分类删除
    boolean catalogDel(int catalogId);
    //分类批量删除
    boolean catalogBatDelById(String ids);
    //查找分类名称
    boolean findCatalogByCatalogName(String catalogName);
    //增加分类
    boolean catalogAdd(String catalogName);
}
