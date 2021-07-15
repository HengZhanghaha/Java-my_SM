package dao;

import entity.ScoreDiscount;
import entity.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Editor: 张恒
 * Wechat：zh17530588817
 * */
public class ScoreDiscountDao {
    public List<ScoreDiscount> getAllScoreDiscountDao(){
        ArrayList<ScoreDiscount> list = new ArrayList<>();
        Connection conn = DBMannger.getConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;
        try {
            stat = conn.prepareStatement("select distinct c.score,p.discount from customers c, products p");
            rs = stat.executeQuery();
            while (rs.next()){
                ScoreDiscount sc = new ScoreDiscount();
                sc.setMinScore(rs.getInt(1));
                sc.setDiscount(rs.getDouble(2));
                list.add(sc);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBMannger.closeAll(conn,stat,rs);
        }

        return list;
    }



}
