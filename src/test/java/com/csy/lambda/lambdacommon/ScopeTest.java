package com.csy.lambda.lambdacommon;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

/**
 * <p>Description：
 * 作用域测试：在lambda中使用关键字 this 和 super 表达式在方法中，它们的行为与我们在该方法中使用它们一样
 * lambda表达式不会创建自己的作用域
 * </p>
 *
 * @author shuyun.cheng
 * @date 2020/10/20 20:45
 */
public class ScopeTest {
    @Test
    public void test1() {
        // int x= 0;
        Function<String, String> function = x -> {
            System.out.println(this);
            return x;
        };
        function.apply("test");
    }

    public String toString() {
        return "ScopeTest";
    }

    public static void main(String[] argv) {
        new ScopeTest();
    }
}
