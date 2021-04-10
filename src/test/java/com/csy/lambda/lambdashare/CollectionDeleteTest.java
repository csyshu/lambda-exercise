package com.csy.lambda.lambdashare;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description：</p>
 *
 * @author shuyun.cheng
 * @date 2020/10/28 21:06
 */
public class CollectionDeleteTest {
    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item(1, "牙刷", 19.05));
        items.add(new Item(2, "洗头膏", 99.00));
        items.add(new Item(3, "键盘", 888.88));
        items.add(new Item(4, "电脑", 19999.00));
        items.add(new Item(5, "背包", 299.00));
        items.removeIf(ele -> ele.getId() == 1);
        items.forEach(System.out::println);
    }
}
