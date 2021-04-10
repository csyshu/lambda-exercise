package com.csy.lambda.functioninteface;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>Description：
 * 1、Predicate 接口是一个谓词型接口，其实，这个就是一个类似于 boolean类型的判断的接口，返回ture/false。
 * 2、Predicate 是一个谓词型接口，其实只是起到一个判断作用。
 * 3、Predicate 通过实现一个 test 方法做判断。
 * </p>
 *
 * @author shuyun.cheng
 * @date 2020/10/16 18:21
 */
public class PredicateTest {
    @Test
    public void testPredicate() {
        Predicate<Integer> predicate = (Integer num) -> num > 5;
        System.out.println(predicate.test(6));
    }

    @Test
    public void testPredicateParam() {
        // 肯定谓词
        Predicate<Integer> predicate = (Integer num) -> num > 5;
        Stream<Integer> stream = Stream.of(1, 23, 3, 4, 5, 56, 6, 6);
        List<Integer> list = stream.filter(predicate).collect(Collectors.toList());
        list.forEach(System.out::println);
        // 否定谓词
        Predicate<Integer> negate = predicate.negate();
        stream = Stream.of(1, 23, 3, 4, 5, 56, 6, 6);
        List<Integer> list1 = stream.filter(negate).collect(Collectors.toList());
        list1.forEach(System.out::println);
    }

}
