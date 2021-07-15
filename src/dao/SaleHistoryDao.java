package dao;

import entity.SaleHistory;

import java.util.Date;

/**
 * Editor: 张恒
 * Wechat：zh17530588817
 * date: 2021/6/30/19:50
 * */
public class SaleHistoryDao {
    public boolean newSaleHistoryDao(SaleHistory saleHistory){

        boolean flag = false;
        if(saleHistory.getCustomerNo() == 0){
            System.out.println("此信息没必要插入");
            return flag;
        }else {
            String sql = "insert into salehistory(productNo,saleCount,price,discount,userID,saleTime,customerNo) values(?,?,?,?,?,?,?)";
            Object[] objs = {saleHistory.getProductNo(),saleHistory.getSaleCount(),saleHistory.getPrice(),
                            saleHistory.getDiscount(),saleHistory.getUserId(),saleHistory.getSaleTime(),
                            saleHistory.getCustomerNo()};
            flag = DBMannger.executeUpdate(sql,objs);
            System.out.println("[logging]:" + new Date() + "销售信息记录成功");

            return flag;
        }
    }
}
