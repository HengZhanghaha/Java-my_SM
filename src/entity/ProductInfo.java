package entity;

/**
 * Editor: 张恒
 * Wechat：zh17530588817
 * */

/**
 * 商品信息
 */
public class ProductInfo extends Products {
    private String categoryName;  //种类名

    public ProductInfo() {
    }

    public ProductInfo(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
