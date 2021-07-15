package entity;

/**
 * Editor: 张恒
 * Wechat：zh17530588817
 * date: 2021/6/30/19:50
 */

/**
 * 积分计算
 */
public class ScoreDiscount {
    private int minScore;  //积分
    private double discount;  //折扣

    public ScoreDiscount() {
    }

    public ScoreDiscount(int minScore, double discount) {
        this.minScore = minScore;
        this.discount = discount;
    }

    public int getMinScore() {
        return minScore;
    }

    public void setMinScore(int minScore) {
        this.minScore = minScore;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
