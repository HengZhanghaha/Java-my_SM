package service;

import dao.CustomerDao;
import entity.Customers;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.List;

/**
 * Editor: 张恒
 * Wechat：zh17530588817
 * date: 2021/6/25/20:01
 */
public class CustomerService {
    public List<Customers> getAllCustomersService(){
        CustomerDao cd = new CustomerDao();
        return cd.getAllCustomersDao();
    }

    public int newCustomersService(Customers customer){
        CustomerDao cd = new CustomerDao();
        return cd.newCustomersDao(customer);
    }
    public boolean deleteCustomersService(String customerNo){
        CustomerDao cd = new CustomerDao();
        return cd.deleteCustomersDao(customerNo);
    }

    public boolean checkCustomerDao(int customerNo){
        CustomerDao cd = new CustomerDao();
        return cd.checkCustomerDao(customerNo);
    }

    public boolean updateCustomerScoreDao(int customerNo,int score){
        CustomerDao cd = new CustomerDao();
        return cd.updateCustomerScoreDao(customerNo, score);
    }

    public double getMemberDiscountByCustomerNoService(int customerNo){
        CustomerDao cd = new CustomerDao();
        return cd.getMemberDiscountByCustomerNoDao(customerNo);
    }

}
