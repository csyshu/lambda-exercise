package com.csy.lambda.lambdashare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>Description：</p>
 *
 * @author shuyun.cheng
 * @date 2020/10/28 21:05
 */
public class ForeachTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //lambda表达式 方法引用
        list.forEach(System.out::println);
        //偶数输出
        list.forEach(element -> {
            if (element % 2 == 0) {
                System.out.println(element);
            }
        });
    }
}
