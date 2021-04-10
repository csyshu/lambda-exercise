package com.csy.lambda.functioninteface;

/**
 * <p>Description：@FunctionalInterface该注解加上后，就是生命该接口为函数式接口，只能有一个抽象方法，如果写两个，直接会报错
 * </p>
 *
 * @author shuyun.cheng
 * @date 2020/10/16 19:23
 */
@FunctionalInterface
public interface InterfaceTest {
    void accept();

    default void andThen() {
        System.out.println("默认方法1");
    }

    default void andThen1() {
        System.out.println("默认方法2");
    }
}
