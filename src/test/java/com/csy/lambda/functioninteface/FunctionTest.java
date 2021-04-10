package com.csy.lambda.functioninteface;

import org.junit.jupiter.api.Test;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * <p>Description：
 * 1、Function 接口是一个功能型接口，它的一个作用就是转换作用，将输入数据转换成另一种形式的输出数据。
 * 2、Function 接口是一个功能型接口，是一个转换数据的作用。
 * 3、Function 接口实现 apply 方法来做转换。
 * 4、其他接口：IntFunction 、DoubleFunction 、LongFunction 、ToIntFunction 、ToDoubleFunction 、DoubleToIntFunction
 * </p>
 *
 * @author shuyun.cheng
 * @date 2020/10/16 18:35
 */
public class FunctionTest {
    @Test
    public void testFunction() {
        //① 使用map方法，泛型的第一个参数是转换前的类型，第二个是转化后的类型
        Function<String, Integer> function = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                //获取每个字符串的长度，并且返回
                return s.length();
            }
        };
        Function<String, Object> andThen = function.andThen(new Function<Integer, Object>() {
            @Override
            public Object apply(Integer integer) {
                return "后面执行";
            }
        });
        Function<Object, Integer> compose = function.compose(new Function<Object, String>() {
            @Override
            public String apply(Object o) {
                return "前面执行";
            }
        });
        String  s = "2";
        Integer apply = compose.apply(s);
        System.out.println(apply);
        Object apply1 = andThen.apply(s);
        System.out.println(apply1);

        Stream<String> stream = Stream.of("aaa", "bbbbb", "ccccccv");
        Stream<Integer> stream1 = stream.map(function);
        stream1.forEach(System.out::println);
    }
}
