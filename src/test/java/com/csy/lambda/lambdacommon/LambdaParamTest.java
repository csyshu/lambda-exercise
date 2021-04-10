package com.csy.lambda.lambdacommon;

import org.junit.jupiter.api.Test;

/**
 * <p>Description：lambda 行为参数化的几种形式</p>
 *
 * @author shuyun.cheng
 * @date 2020/10/19 20:42
 */
public class LambdaParamTest {
    /**
     * 1、行为参数化
     */
    @Test
    public void test1() {
        //黄色警告，后面说
        engine((x, y) -> x + y);
        engine((x, y) -> x * y);
        engine((x, y) -> x / y);
        engine((x, y) -> x % y);

        // engine((Calculator) (x, y) -> x + y);
        // engine((Calculator) (x, y) -> x * y);
        // engine((Calculator) (x, y) -> x / y);
        // engine((Calculator) (x, y) -> x % y);


    }

    private static void engine(Calculator calculator) {
        int x = 2, y = 4;
        int result = calculator.calculate(x, y);
        System.out.println(result);
    }

    @FunctionalInterface
    interface Calculator {
        int calculate(int x, int y);
    }

    /**
     * 2、行为参数模糊性，只能有一种匹配的函数式接口。
     * 如果将lambda表达式传递给多个重载的方法，那么就不能自动推断出类别，编译会报错。
     * 解决办法有两种:
     * <li>
     *     强转指定lambda表达式对应的函数接口。
     *     先将lambda表示式用指定函数接口接受，再讲函数接口传入重载方法。
     * </li>
     */
    // @Test
    // public void test2() {
    //     engine((int x, int y) -> x + y);
    //     //1、强转指定
    //     // engine((IntCalculator) (int x, int y) -> x + y);
    //     //2、先声明
    //     // IntCalculator calculator = (int x, int y) -> x + y;
    //     // engine(calculator);
    //     engine((long x, long y) -> x * y);
    //     engine((int x, int y) -> x / y);
    //     //1、强转指定
    //     // engine((IntCalculator) (int x, int y) -> x / y);
    //     //2、先声明
    //     // IntCalculator calculator2 = (int x, int y) -> x / y;
    //     // engine(calculator2);
    //     engine((long x, long y) -> x % y);
    // }
    //
    // private static void engine(IntCalculator calculator) {
    //     int x = 2, y = 4;
    //     int result = calculator.calculate(x, y);
    //     System.out.println(result);
    // }
    //
    // private static void engine(LongCalculator calculator) {
    //     long x = 2, y = 4;
    //     long result = calculator.calculate(x, y);
    //     System.out.println(result);
    // }
    //
    // @FunctionalInterface
    // interface IntCalculator {
    //     int calculate(int x, int y);
    // }
    //
    // @FunctionalInterface
    // interface LongCalculator {
    //     long calculate(long x, long y);
    // }

}