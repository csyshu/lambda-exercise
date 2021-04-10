package com.csy.lambda.lambdashare;

import java.util.function.Consumer;

/**
 * <p>Description：
 * 这个问题我们在匿名内部类中也会存在，如果我们把注释放开会报错，告诉我 num 值是 final 不能被改变。这里我们虽然没有标识 num 类型为 final，但是在编译期间虚拟机会帮我们加上 final 修饰关键字
 * </p>
 *
 * @author shuyun.cheng
 * @date 2020/10/28 21:12
 */
public class ClosureTest {
    public static void main(String[] args) {
        int num = 10;
        Consumer<String> consumer = ele -> {
            System.out.println(num);
        };
        // num = num + 2;
        consumer.accept("hello");
    }
}
