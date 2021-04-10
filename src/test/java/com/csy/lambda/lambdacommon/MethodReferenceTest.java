package com.csy.lambda.lambdacommon;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * <p>Description：
 * 有六种类型的方法引用。
 * TypeName::staticMethod - 引用类的静态方法，接口或枚举
 * objectRef::instanceMethod - 引用实例方法
 * ClassName::instanceMethod - 从类中引用实例方法
 * TypeName.super::instanceMethod - 从对象的父类型引用实例方法
 * ClassName::new - 引用一个类的构造函数
 * ArrayTypeName::new - 对指定数组类型的构造函数的引用
 * </p>
 *
 * @author shuyun.cheng
 * @date 2020/10/20 17:32
 */
public class MethodReferenceTest {
    /**
     * 静态方法引用
     */
    @Test
    public void test1() {
        BiFunction<Integer, Integer, Integer> sum = Integer::sum;
        int x = 2, y = 4;
        Integer apply = sum.apply(x, y);
        System.out.println(apply);
    }

    /**
     * 实例方法引用
     */
    @Test
    public void test2() {
        Util util = new Util();
        Consumer<String> consumer = util::print;
        consumer.accept("Hello instance");
        BiConsumer<Util, String> biConsumer = Util::print;
        biConsumer.accept(util, "Hello class");
    }

    /**
     * 超类方法引用
     */
    @Test
    public void test3() {
        Util util = new Util();
        Consumer<String> superPrint = util::superPrint;
        superPrint.accept("Hello super");
    }

    /**
     * 构造函数引用
     */
    @Test
    public void test4() {
        Supplier<String> test = String::new;
        String s = test.get();
        System.out.println(s);
        Function<String, String> test1 = String::new;
        String test2 = test1.apply("test");
        System.out.println(test2);
        Supplier<Util> aNew = Util::new;
        System.out.println(aNew.get());
    }

    /**
     * 通用方法引用
     */
    @Test
    public void test5() {
        Function<String[], List<String>> asList = Arrays::asList;
        System.out.println(asList.apply(new String[]{"a", "b", "c"}));
    }

}

class Util extends UtilParent {
    public Util() {
    }

    public void print(String s) {
        System.out.println("Util:" + s);
    }

    public void superPrint(String s) {
        Consumer<String> print = Util.super::print;
        print.accept(s);
    }

}

class UtilParent {
    public void print(String s) {
        System.out.println("UtilParent:" + s);
    }
}
