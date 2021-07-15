package entity;

/**
 * Editor: 张恒
 * Wechat：zh17530588817
 * date: 2021/6/30/19:50
 * */

/**
 * 会员
 */
public class Customers {
    private String customerNo;
    private String customerName;
    private String customerTel;
    private int customerScore;  //会员积分

    public Customers() {
    }

    public Customers(String customerNo, String customerName, String customerTel, int customerScore) {
        this.customerNo = customerNo;
        this.customerName = customerName;
        this.customerTel = customerTel;
        this.customerScore = customerScore;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerTel() {
        return customerTel;
    }

    public void setCustomerTel(String customerTel) {
        this.customerTel = customerTel;
    }

    public int getCustomerScore() {
        return customerScore;
    }

    public void setCustomerScore(int customerScore) {
        this.customerScore = customerScore;
    }
}
