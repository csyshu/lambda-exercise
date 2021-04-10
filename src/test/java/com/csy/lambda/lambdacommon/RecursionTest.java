package com.csy.lambda.lambdacommon;

import java.util.function.IntFunction;

/**
 * <p>Description：
 * 递归测试：在创建递归lambda表达式时使用方法引用
 * </p>
 *
 * @author shuyun.cheng
 * @date 2020/10/20 21:05
 */
public class RecursionTest {
    /**
     * 使用递归函数作为方法引用来创建lambda表达式
     */
    public static void main(String[] args) {
        IntFunction<Long> factorialCalc = RecursionTest::factorial;
        System.out.println(factorialCalc.apply(10));
    }

    public static long factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
