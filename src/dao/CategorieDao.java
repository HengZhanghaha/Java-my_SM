package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;


/**
 * Editor: 张恒
 * Wechat：zh17530588817
 * */
public class CategorieDao {
    public String getCategoryNameDao(String categoryId){  //种类编号
        String categoryName = "";
        Connection conn=DBMannger.getConnection();
        PreparedStatement stat=null; // PreparedStatement可以有效防止sql注入，
        ResultSet rs=null;
        try {
            stat=conn.prepareStatement("select * from products where categoryId = ?");
            stat.setString(1, categoryId);
            rs=stat.executeQuery();
            rs.next();
            categoryName =rs.getString(2);
//            System.out.println("[logging]:" + new Date() + "查找商品成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DBMannger.closeAll(conn, stat, rs);
        }
        return categoryName;
    }
}
