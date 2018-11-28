package com.mail.web;

import com.alibaba.fastjson.JSONObject;

public class JSONCombine {
    public static void main(String[] args) {
        JSONObject jsonOne = new JSONObject();
        JSONObject jsonTwo = new JSONObject();

        JSONObject.parseObject("");
        jsonOne.put("name", "kewen");
        jsonOne.put("age", "24");
        jsonTwo.put("hobbit", "Dota");
        jsonTwo.put("hobbit2", "wow");
        JSONObject jsonThree = new JSONObject();
        jsonThree.putAll(jsonOne);
        jsonThree.putAll(jsonTwo);
        System.out.println(jsonThree.toString());
    }
} 