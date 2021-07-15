package service;

import dao.SaleHistoryDao;
import entity.SaleHistory;

/**
 * Editor: 张恒
 * Wechat：zh17530588817
 * date: 2021/6/25/20:01
 * */


public class SaleHistoryService {
    public boolean newSaleHistoryService(SaleHistory saleHistory){
        SaleHistoryDao shd = new SaleHistoryDao();
        return shd.newSaleHistoryDao(saleHistory);
    }
}
