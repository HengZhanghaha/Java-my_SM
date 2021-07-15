package service;

import dao.CategorieDao;
/**
 * Editor: 张恒
 * Wechat：zh17530588817
 * date: 2021/6/30/19:59
 **/
public class CategorieService {
    public String getCategoryNameService(String categoryId){
        CategorieDao cd = new CategorieDao();
        return cd.getCategoryNameDao(categoryId);
    }
}
