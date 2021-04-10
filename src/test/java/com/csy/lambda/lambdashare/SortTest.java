package com.csy.lambda.lambdashare;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * <p>Description：</p>
 *
 * @author shuyun.cheng
 * @date 2020/10/28 21:09
 */
public class SortTest {
    public static void main(String[] args) {
        List<Item> list = new ArrayList<>();
        list.add(new Item(6, "秋裤", 99.80));
        list.add(new Item(7, "保暖内衣", 9999.80));
        list.add(new Item(8, "靴子", 499.80));
        list.add(new Item(9, "羽绒服", 899.99));
        /*
        list.sort(new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.getId()  - o2.getId();
            }
        });
        */
        list.sort(Comparator.comparingInt(Item::getId));
        System.out.println(JSON.toJSONString(list));
        list.sort(Comparator.comparingDouble(Item::getPrice));
        System.out.println(JSON.toJSONString(list));
    }
}
