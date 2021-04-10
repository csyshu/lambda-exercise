package com.csy.lambda.lambdacommon;

import org.junit.jupiter.api.Test;

/**
 * <p>Description：lambda上下文处理</p>
 *
 * @author shuyun.cheng
 * @date 2020/10/20 14:17
 */
public class LambdaContextTest {
    /**
     * 赋值上下文
     * lambda表达式可以显示在赋值运算符的右侧。
     */
    @Test
    public void test1() {
        Calculator calculator = (x, y) -> x + y;
        // 静态方法引用
        // Calculator calculator = Integer::sum;
        Calculator calculator1 = (x, y) -> x * y;
        System.out.println(calculator.calculate(1, 2));
        System.out.println(calculator1.calculate(1, 2));
    }

    /**
     * 方法调用上下文
     * 使用lambda表达式作为方法或构造函数的参数。
     */
    @Test
    public void test2() {
        engine((long x, long y) -> x / y);
    }

    /**
     * 返回上下文
     * return语句中使用lambda表达式，其目标类型在方法返回类型中声明。
     */
    @Test
    public void test3() {
        System.out.println(create().calculate(2, 2));
    }

    /**
     * 转换上下文
     * 使用一个lambda表达式前面加一个cast。在转换中指定的类型是其目标类型。
     */
    @Test
    public void test4() {
        engine((LongCalculator) ((x, y) -> x * y));
    }

    private static void engine(LongCalculator calculator) {
        long x = 2, y = 4;
        long result = calculator.calculate(x, y);
        System.out.println(result);
    }

    private static Calculator create() {
        return (x, y) -> x / y;
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

    @FunctionalInterface
    interface LongCalculator {
        long calculate(long x, long y);
    }
}
