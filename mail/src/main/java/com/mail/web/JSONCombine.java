package com.mail.web;

import com.alibaba.fastjson.JSONObject;

import java.time.LocalDate;
import java.util.Date;

public class JSONCombine {
    public static void main(String[] args) {
//        JSONObject jsonOne = new JSONObject();
//        Integer integer = new Integer(2);
//        jsonOne.put("name", integer);
//        JSONObject jsonTwo = new JSONObject();
////        JSONObject.
////        JSONObject.parseObject("");
//
//        jsonOne.put("age", "24");
//        jsonTwo.put("hobbit", "Dota");
//        jsonTwo.put("hobbit2", "wow");
//        JSONObject jsonThree = new JSONObject();
//        jsonThree.putAll(jsonOne);
//        jsonThree.putAll(jsonTwo);
//        System.out.println(jsonOne.toString());

        LocalDate todayDate = LocalDate.now();
        System.out.println("今天的日期："+todayDate);
        LocalDate today = LocalDate.now();
        LocalDate now = today;
        System.out.println(now.isBefore(today));
        //Date date
    }

} 