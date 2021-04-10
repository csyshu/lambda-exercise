package com.csy.lambda.lambdacommon;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

/**
 * <p>Description：
 * 变量获取：lambda表达式可以访问最终局部变量或局部非最终初始化只有一次的变量。
 * </p>
 *
 * @author shuyun.cheng
 * @date 2020/10/20 20:56
 */
public class VariableAcquisitionTest {
    /**
     * 访问最终变量
     */
    @Test
    public void test1() {
        final String x = "Hello";
        Function<String, String> func1 = y -> {
            return y + " " + x;
        };
        System.out.println(func1.apply("final "));
    }

    /**
     * 访问非最终，初始化一次的变量
     */
    @Test
    public void test2() {
        String x = "Hello";
        Function<String, String> func1 = y -> {
            return y + " " + x;
        };
        System.out.println(func1.apply("not final "));
    }

    /**
     * 不能改变在lambda表达式之外定义的值。
     */
    @Test
    public void test3() {
        String x = "Hello";
        Function<String, String> func1 = y -> {
            // x = "a";
            return y + " " + x;
        };
        System.out.println(func1.apply("w3cschool.cn"));

    }

    static String x = "Hello";

    /**
     * 可以更改lambda表达式中的非局部变量。
     */
    @Test
    public void test4() {
        Function<String, String> func1 = y -> {
            x = "a";
            return y + " " + x;
        };
        System.out.println(func1.apply("not local variable"));
    }
}
