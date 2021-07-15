package dao;

/**
 * Editor: 张恒
 * tel： XXXXXXXXXXXXX
 * Wechat：zh17530588817
 * date: 2021/6/30/19:50
 */

import entity.ProductInfo;
import entity.Users;
import service.CategorieService;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * userdao
 * 连接数据库获取返回对象
 * 将各个数据赋值给变量
 */

public class UsersDao {
    public List<Users> getAllUsersDao(){
        ArrayList<Users> list = new ArrayList<>();
        Connection conn = DBMannger.getConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;

        try {
            System.out.println("[logging]:" + new Date() + " 查询所有管理员成功");
            stat  = conn.prepareStatement("select * from users");
            rs = stat.executeQuery();
            while (rs.next()){
                Users user = new Users();
                user.setUserId(rs.getInt(1));
                user.setUserName(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setRoleId(rs.getInt(4));
                list.add(user);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBMannger.closeAll(conn,stat,rs);
        }

        return list;
    }

    public boolean checkUsersDao(String userName,String pwd,int roleId){
        boolean flag = false;
        if(userName.isEmpty()){
            return flag;
        }else if(pwd.isEmpty()){
            return flag;
        }else {
            UsersDao user = new UsersDao();
            List<Users> list = user.getAllUsersDao();
            boolean tag = false;
            for (Users a: list){
                if(userName.equals(a.getUserName()) && pwd.equals(a.getPassword())
                        && roleId ==a.getRoleId()){
                    tag = true;
                    flag = true;
                }

            }
            if (!tag){
                return flag;
            }
        }
        return flag;
    }

    public boolean newUsersDao(Users user){
        boolean flag = false;
        String sql = "insert into users values(?,?,?,?)";
        Object[] objs = {user.getUserId(),user.getUserName(),user.getPassword(),user.getRoleId()};
        flag = DBMannger.executeUpdate(sql, objs);
        System.out.println("[logging]:" + new Date() + "新增管理员成功");
        return flag;
    }

    public boolean deleteUsersDao(int userId){
        boolean flag = false;
        String sql = "delete from users where userId = ?";
        Object[] objs = {userId};
        flag = DBMannger.executeUpdate(sql, objs);
        System.out.println("[logging]:" + new Date() + "删除管理员成功");
        return flag;
    }

    public int getUserIdByUserName(String userName){
        int userId = 1000;
        Connection conn = DBMannger.getConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;
        try {
//            System.out.println("[logging]:" + new Date() + "查找管理员成功");
            stat=conn.prepareStatement("select userId from users where userName = ?");
            stat.setString(1, userName);
            rs=stat.executeQuery();
            if(rs.next()){
                userId = rs.getInt(1);
            }else{
                JOptionPane.showMessageDialog(null,"查询的管理员信息不存在","错误提示",JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DBMannger.closeAll(conn, stat, rs);
        }

        return userId;
    }
    public Users getUsersByUserId(int userId){
        Users user = new Users();
        Connection conn = DBMannger.getConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;
        try {
//            System.out.println("[logging]:" + new Date() + "查找管理员成功");
            stat=conn.prepareStatement("select * from users where userId =?");
            stat.setInt(1, userId);
            rs=stat.executeQuery();
            if(rs.next()){
                user.setUserId(rs.getInt(1));
                user.setUserName(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setRoleId(rs.getInt(4));
            }else{
                JOptionPane.showMessageDialog(null,"查询的管理员不存在","错误提示",JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DBMannger.closeAll(conn, stat, rs);
        }

        return user;
    }
    public boolean updateUserPasswordDao(int userId,String password){
        boolean flag = false;
        String sql = "update users set password = ? where userId = ?";
        Object[] objs = {password,userId};
        flag = DBMannger.executeUpdate(sql, objs);
        return flag;
    }
}
