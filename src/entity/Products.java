package entity;


/**
 * Editor: 张恒
 * Wechat：zh17530588817
 * date: 2021/6/30/19:50
 */

/**
 * 商品
 */
public class Products {
    private String pNo;
    private String categoryId;  //种类编号
    private String pName;
    private String type;  //规格
    private String unit;  //单位
    private int pcount = 0;  //库存数量
    private double price; //价格
    private double discount;  //折扣

    public Products() {
    }

    public Products(String pNo, String categoryId, String pName, String type, String unit, int pcount, double price, double discount) {
        this.pNo = pNo;
        this.categoryId = categoryId;
        this.pName = pName;
        this.type = type;
        this.unit = unit;
        this.pcount = pcount;
        this.price = price;
        this.discount = discount;
    }

    public String getpNo() {
        return pNo;
    }

    public void setpNo(String pNo) {
        this.pNo = pNo;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getPcount() {
        return pcount;
    }

    public void setPcount(int pcount) {
        this.pcount = pcount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
