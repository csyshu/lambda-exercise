package com.csy.lambda.functioninteface;

import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * <p>Description：
 * 1、Supplier 接口是一个供给型的接口，其实，说白了就是一个容器，可以用来存储数据，然后可以供其他方法使用的这么一个接口。
 * 2、Supplier 接口可以理解为一个容器，用于装数据的。
 * 3、Supplier 接口有一个 get 方法，可以返回值。
 * 4、其他接口：IntSupplier 、DoubleSupplier 、LongSupplier 、BooleanSupplier
 * </p>
 *
 * @author shuyun.cheng
 * @date 2020/10/16 18:02
 */
public class SupplierTest {
    @Test
    public void testSupplier() {
        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                //返回一个随机值
                return new Random().nextInt();
            }
        };
        System.out.println(supplier.get());

        //③ 使用方法引用
        Supplier<Double> supplier2 = Math::random;
        System.out.println(supplier2.get());
    }

    @Test
    public void testLambda() {
        Supplier<Integer> supplier = () -> new Random().nextInt();
        System.out.println(supplier.get());
    }

    @Test
    public void testMethodRef() {
        Supplier<Double> supplier2 = Math::random;
        System.out.println(supplier2.get());
    }

    @Test
    public void testSupplierParam() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);

        Optional<Integer> first = stream.filter(i -> i > 4).findFirst();
        System.out.println(first.orElse(1));

        Supplier<Integer> supplier = () -> {
            //返回一个随机值
            return new Random().nextInt();
        };
        System.out.println(first.orElseGet(supplier));
    }
}
