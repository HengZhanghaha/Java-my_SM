package dao;

/**
 * Editor: 张恒
 * tel： XXXXXXXXXXXXX
 * Wechat：zh17530588817
 * date: 2021/6/30/19:50
 */

import entity.ProductInfo;
import entity.Products;
import service.CategorieService;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/***
 * 商品
 */
public class ProductsDao {
    public List<ProductInfo> getAllProductDao(){
        ArrayList<ProductInfo> list = new ArrayList<>();
        Connection conn = DBMannger.getConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;
        try {
            stat  = conn.prepareStatement("select * from products");
            rs = stat.executeQuery();
            System.out.println("[logging]:" + new Date() + "查询所有商品成功");
            while (rs.next()){
                ProductInfo product = new ProductInfo();
                product.setpNo(rs.getString(1));
                product.setCategoryId(rs.getString(2));
                product.setpName(rs.getString(3));
                product.setType(rs.getString(4) );
                product.setUnit(rs.getString(5));
                product.setPcount(rs.getInt(6));
                product.setPrice(rs.getDouble(7));
                product.setDiscount(rs.getDouble(8));
                CategorieService cs = new CategorieService();

                product.setCategoryName(cs.getCategoryNameService(product.getCategoryId()));

                list.add(product);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBMannger.closeAll(conn,stat,rs);
        }

        return list;
    }

    public ProductInfo getProductInfoByProductNo(String productNo){
        ProductInfo product = new ProductInfo();
        Connection conn = DBMannger.getConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;
        try {
            System.out.println("[logging]:" + new Date() + "查找商品信息成功");
            stat = conn.prepareStatement("select * from products where productNo = ?");
            stat.setString(1, productNo);
            rs = stat.executeQuery();
            if(rs.next()){
                product.setpNo(rs.getString(1));
                product.setCategoryId(rs.getString(2));
                product.setpName(rs.getString(3));
                product.setType(rs.getString(4) );
                product.setUnit(rs.getString(5));
                product.setPcount(rs.getInt(6));
                product.setPrice(rs.getDouble(7));
                product.setDiscount(rs.getDouble(8));
                CategorieService cs = new CategorieService();

                product.setCategoryName(cs.getCategoryNameService(product.getCategoryId()));
            }else {
                JOptionPane.showMessageDialog(null,"查询的商品不存在！","错误提示",JOptionPane.ERROR_MESSAGE);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBMannger.closeAll(conn,stat,rs);
        }
        return product;
    }
    public ProductInfo getProductInfoByproductName(String productName){
        ProductInfo product = new ProductInfo();
        Connection conn=DBMannger.getConnection();
        PreparedStatement stat=null;
        ResultSet rs=null;
        try {
            System.out.println("[logging]:" + new Date() + "查找商品信息成功");
            stat=conn.prepareStatement("select * from products where productName = ?");
            stat.setString(1, productName);
            rs=stat.executeQuery();
            if(rs.next()){
                product.setpNo(rs.getString(1));
                product.setCategoryId(rs.getString(2));
                product.setpName(rs.getString(3));
                product.setType(rs.getString(4) );
                product.setUnit(rs.getString(5));
                product.setPcount(rs.getInt(6));
                product.setPrice(rs.getDouble(7));
                product.setDiscount(rs.getDouble(8));

                CategorieService cs = new CategorieService();
                product.setCategoryName(cs.getCategoryNameService(product.getCategoryId()));
            }else{
                JOptionPane.showMessageDialog(null,"查询的商品不存在","错误提示",JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DBMannger.closeAll(conn, stat, rs);
        }

        return product;
    }

    public boolean newProductsDao(Products product){
        boolean flag = false;
        String sql = "insert into products values(?,?,?,?,?,?,?,?)";
        Object[] objs = {product.getpNo(),product.getCategoryId(),product.getpName(),
                product.getType(),product.getUnit(),product.getPcount(),product.getPrice(),
                product.getDiscount()};

        flag = DBMannger.executeUpdate(sql,objs);
        System.out.println("[logging]:" + new Date() + "新增商品成功");
        return flag;
    }

    public boolean deleteProductsDao(String productNo){
        boolean flag = false;
        String sql = "delete from products where productNo = ?";

        Object[] objs = {productNo};
        flag = DBMannger.executeUpdate(sql,objs);

        System.out.println("[logging]:" + new Date() + "删除商品成功");
        return flag;
    }

    public boolean updateProductsDao(String productNo,int pcount,double discount){
        boolean flag = false;
        String sql = "update products set pcount = ?,discount = ? where productNo= ?";
        Object[] objs = {pcount,discount,productNo};
        flag = DBMannger.executeUpdate(sql, objs);
        System.out.println("[logging]:" + new Date() + "更新商品信息成功");
        return flag;
    }

    public boolean updateProductsCountDao(String productNo,int soldNumber){
        boolean flag = false;
        int pcount = 0;
        ProductsDao pd = new ProductsDao();
        pcount = pd.getProductInfoByProductNo(productNo).getPcount()-soldNumber;
        String sql = "update products set pcount = ? where productNo = ?";
        Object[] objs = {pcount,productNo};
        flag = DBMannger.executeUpdate(sql, objs);
        return flag;
    }
    public boolean checkProductsNoDao(String ProductsNo){
        boolean flag = false;
        Connection conn = DBMannger.getConnection();
        PreparedStatement stat=null;
        ResultSet rs=null;
        try {
            stat=conn.prepareStatement("select * from products where productNo = ?");
            stat.setString(1, ProductsNo);
            rs=stat.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(null,"该商品编号已经存在","错误提示",JOptionPane.ERROR_MESSAGE);
            }else{
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DBMannger.closeAll(conn, stat, rs);
        }
        return flag;
    }
}
