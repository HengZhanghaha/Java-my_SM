package service;

import dao.ProductsDao;
import entity.ProductInfo;
import entity.Products;

import java.util.List;

/**
 * Editor: 张恒
 * Wechat：zh17530588817
 * date: 2021/6/25/20:01
 */
public class ProductsService {
    public List<ProductInfo> getAllProductsService(){
        ProductsDao pd = new ProductsDao();
        return pd.getAllProductDao();
    }
    public ProductInfo getProductInfoByProductNoService(String ProductNo){
        ProductsDao pd = new ProductsDao();
        return pd.getProductInfoByProductNo(ProductNo);
    }

    public ProductInfo getProductInfoByproductNameService(String productName){
        ProductsDao pd = new ProductsDao();
        return pd.getProductInfoByproductName(productName);
    }
    public boolean newProductsService(Products product){
        ProductsDao pd = new ProductsDao();
        return pd.newProductsDao(product);
    }
    public boolean deleteProductsService(String productNo){
        ProductsDao pd = new ProductsDao();
        return pd.deleteProductsDao(productNo);
    }
    public boolean updateProductsService(String productNo,int count,double discount){
        ProductsDao pd = new ProductsDao();
        return pd.updateProductsDao(productNo, count, discount);
    }
    public boolean updateProductsCountService(String productNo,int soldNumber){
        ProductsDao pd = new ProductsDao();
        return pd.updateProductsCountDao(productNo, soldNumber);
    }
    public boolean checkProductsNoDao(String ProductsNo){
        ProductsDao pd = new ProductsDao();
        return pd.checkProductsNoDao(ProductsNo);
    }
}
