package com.csy.lambda.functioninteface;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * <p>Description：
 * 1、该接口主要作用是接收参数，经过特定逻辑处理后（逻辑需要自己实现），然后输出处理结果。
 * 2、Consumer是一个接口，并且只要实现一个 accept 方法，就可以作为一个“消费者”输出信息。
 * 3、其实，lambda 表达式、方法引用的返回值都是 Consumer 类型，所以，他们能够作为 forEach 方法的参数，并且输出一个值。
 * 4、其他接口：IntConsumer、DoubleConsumer、LongConsumer、BiConsumer
 * </p>
 *
 * @author shuyun.cheng
 * @date 2020/10/16 17:48
 */
public class ConsumerTest {

    private final Stream<String> stream = Stream.of("aaa", "bbb", "ddd", "ccc", "fff");

    @Test
    public void testConsumer() {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        stream.forEach(consumer);
    }

    @Test
    public void testLambda() {
        Stream<String> stream = Stream.of("aaa", "bbb", "ddd", "ccc", "fff");
        //lambda表达式返回的就是一个Consumer接口，这就是为什么forEach方法可以使用lambda表达式作为参数了吧。
        Consumer<String> consumer1 = (s) -> System.out.println(s);
        stream.forEach(consumer1);
    }

    @Test
    public void testMethodRef() {
        Stream<String> stream = Stream.of("aaa", "bbb", "ddd", "ccc", "fff");
        Consumer<String> consumer2 = System.out::println;
        stream.forEach(consumer2);
    }

}
