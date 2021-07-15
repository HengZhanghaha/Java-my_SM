package service;

import java.util.List;

import dao.ScoreDiscountDao;

import entity.ScoreDiscount;

/**
 * Editor: 张恒
 * Wechat：zh17530588817
 * date: 2021/6/25/20:01
 * */

public class ScoreDiscountService {
    public List<ScoreDiscount> getAllScoreDiscountService(){
        ScoreDiscountDao sdd = new ScoreDiscountDao();
        return sdd.getAllScoreDiscountDao();
    }
}
