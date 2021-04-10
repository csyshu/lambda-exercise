package com.csy.lambda.lambdacommon;

import org.junit.jupiter.api.Test;

import java.io.Serializable;

/**
 * <p>Description：
 * Java 8引入了一种称为交集类型的新类型。
 * 交叉类型是多种类型的交叉。
 * 交叉路口类型可能在投射中显示为目标类型。
 * 在两种类型之间使用Type1 & Type2，以表示类型1，类型2的交集的新类型。
 * </p>
 *
 * @author shuyun.cheng
 * @date 2020/10/20 14:47
 */
public class LambdaCrossTypeTest {
    /**
     * 使用具有交集类型的转型，创建一个新的合成类型，它是所有类型的子类型
     * 创建一个lambda表达式并赋值给 NonFunction ，我们使用& 来创建新的子类型。
     */
    @Test
    public void test1() {
        NonFunction nonFunction = (NonFunction & Calculator) (x, y) -> x + y;
        Calculator calculator = (NonFunction & Calculator) (x, y) -> x + y;
        long x = 2, y = 4;
        System.out.println(calculator.calculate(x, y));
    }

    @FunctionalInterface
    interface Calculator {
        long calculate(long x, long y);
    }

    interface NonFunction {

    }

    /**
     * 使一个lambda表达式可序列化
     * 将 java.io.Serializable 标记接口与我们自己的功能接口相交来创建交集类型
     */
    @Test
    public void test2() {
        Serializable calculator = (Serializable & Calculator) (x, y) -> x + y;
        Cloneable cloneable = (Cloneable & Calculator) (x, y) -> x + y;
    }
}
