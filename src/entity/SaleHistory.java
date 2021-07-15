package entity;

/**
 * Editor: 张恒
 * Wechat：zh17530588817
 * date: 2021/6/30/19:50
 */

/**
 * 销售历史
 */
public class SaleHistory {
    private int id;  //记录编号
    private String productNo;
    private int saleCount = 0;
    private double price;
    private double discount;
    private int userId;
    private String saleTime;  //销售时间
    private int customerNo;  //顾客编号

    public SaleHistory() {
    }

    public SaleHistory(int id, String productNo, int saleCount, double price, double discount, int userId, String saleTime, int customerNo) {
        this.id = id;
        this.productNo = productNo;
        this.saleCount = saleCount;
        this.price = price;
        this.discount = discount;
        this.userId = userId;
        this.saleTime = saleTime;
        this.customerNo = customerNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public int getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(int saleCount) {
        this.saleCount = saleCount;
    }

    public double getPrice() {
        return price;
    }

    public int setPrice(double price) {
        int flag = 0;
        if(flag < 0){
            flag = 0;
        }else {
            this.price = price;
            flag = 1;
        }
        return flag;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getSaleTime() {
        return saleTime;
    }

    public void setSaleTime(String saleTime) {
        this.saleTime = saleTime;
    }

    public int getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(int customerNo) {
        this.customerNo = customerNo;
    }
}

