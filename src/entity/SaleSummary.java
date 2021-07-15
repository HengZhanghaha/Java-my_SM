package entity;

/**
 * Editor: 张恒
 * Wechat：zh17530588817
 * date: 2021/6/30/19:50
 */

/**
 * 会员折扣
 */
public class SaleSummary extends SaleHistory{
    private double memberDiscount;  //会员折扣
    private double totalAmount;  //单行总金额

    public SaleSummary() {
    }

    public double getMemberDiscount() {
        return memberDiscount;
    }

    public void setMemberDiscount(double memberDiscount) {
        this.memberDiscount = memberDiscount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
