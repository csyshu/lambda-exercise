package com.csy.lambda.functioninteface;

import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * <p>Description：</p>
 *
 * @author shuyun.cheng
 * @date 2020/9/30 14:28
 */
public class OptionalTest {
    @Test
    public void test1() {
        // 不可以传入null
        Optional<Object> o2 = Optional.of("1");
        System.out.println(o2.get());
        // 允许传入null
        Optional<Object> o = Optional.ofNullable(null);
        System.out.println(o.isPresent());
        if (o.isPresent()) {
            System.out.println(o.get());
        }
        //声明空对象
        Optional<TestOptional> testOptional = Optional.empty();
        //判断是否为空
        boolean present = testOptional.isPresent();
        System.out.println(present);
        if (present) {
            TestOptional testOptional1 = testOptional.get();
            System.out.println(testOptional1);
        }
        // 如果没有值，就返回orElse的值，注意，这里即使前面的不为空，后面的对象也会创建
        TestOptional test1 = testOptional.orElse(new TestOptional(2, "hhh"));
        System.out.println(test1);
        // 如果没有值，就返回orElse的值，注意，这里即使前面的不为空，后面的对象不会创建，推荐使用这种用法
        TestOptional test2 = testOptional.orElseGet(() -> new TestOptional(3, "kjl"));
        System.out.println(test2);
        // 如果值空，抛出指定异常
        TestOptional test3 = testOptional.orElseThrow(() -> new RuntimeException("处理错误"));
        System.out.println(test3);
    }
}

@Data
class TestOptional {
    private Integer code;
    private String message;

    public TestOptional() {
    }

    public TestOptional(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}