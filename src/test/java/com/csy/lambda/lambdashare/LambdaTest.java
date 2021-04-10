package com.csy.lambda.lambdashare;

import org.junit.jupiter.api.Test;

/**
 * <p>Description：</p>
 *
 * @author shuyun.cheng
 * @date 2020/10/28 19:19
 */
public class LambdaTest {
    /**
     * 完整写法
     */
    @Test
    public void test1() {
        //无参无返回
        NoReturnNoParam noReturnNoParam = () -> {
            System.out.println("NoReturnNoParam");
        };
        noReturnNoParam.apply();

        //一个参数无返回
        NoReturnOneParam noReturnOneParam = (int a) -> {
            System.out.println("NoReturnOneParam param:" + a);
        };
        noReturnOneParam.apply(6);

        //多个参数无返回
        NoReturnMultiParam noReturnMultiParam = (int a, int b) -> {
            System.out.println("NoReturnMultiParam param:" + "{" + a + "," + +b + "}");
        };
        noReturnMultiParam.apply(6, 8);

        //无参有返回值
        ReturnNoParam returnNoParam = () -> {
            System.out.print("ReturnNoParam");
            return 1;
        };

        int res = returnNoParam.apply();
        System.out.println("return:" + res);

        //一个参数有返回值
        ReturnOneParam returnOneParam = (int a) -> {
            System.out.println("ReturnOneParam param:" + a);
            return 1;
        };

        int res2 = returnOneParam.apply(6);
        System.out.println("return:" + res2);

        //多个参数有返回值
        ReturnMultiParam returnMultiParam = (int a, int b) -> {
            System.out.println("ReturnMultiParam param:" + "{" + a + "," + b + "}");
            return 1;
        };

        int res3 = returnMultiParam.apply(6, 8);
        System.out.println("return:" + res3);

    }

    /**
     * 简化写法
     */
    @Test
    public void test2() {
        //1.简化参数类型，可以不写参数类型，但是必须所有参数都不写
        NoReturnMultiParam lamdba1 = (a, b) -> {
            System.out.println("简化参数类型");
        };
        lamdba1.apply(1, 2);

        //2.简化参数小括号，如果只有一个参数则可以省略参数小括号
        NoReturnOneParam lambda2 = a -> {
            System.out.println("简化参数小括号");
        };
        lambda2.apply(1);

        //3.简化方法体大括号，如果方法条只有一条语句，则可以胜率方法体大括号
        NoReturnNoParam lambda3 = () -> System.out.println("简化方法体大括号");
        lambda3.apply();

        //4.如果方法体只有一条语句，并且是 return 语句，则可以省略方法体大括号
        ReturnOneParam lambda4 = a -> a+3;
        System.out.println(lambda4.apply(5));

        ReturnMultiParam lambda5 = (a, b) -> a+b;
        // ReturnMultiParam lambda5 = Integer::sum;
        System.out.println(lambda5.apply(1, 1));
    }
}

/**
 * 多参无返回
 */
@FunctionalInterface
interface NoReturnMultiParam {
    void apply(int a, int b);
}

/**
 * 无参无返回值
 */
@FunctionalInterface
interface NoReturnNoParam {
    void apply();
}

/**
 * 一个参数无返回
 */
@FunctionalInterface
interface NoReturnOneParam {
    void apply(int a);
}

/**
 * 多个参数有返回值
 */
@FunctionalInterface
interface ReturnMultiParam {
    int apply(int a, int b);
}

/*** 无参有返回*/
@FunctionalInterface
interface ReturnNoParam {
    int apply();
}

/**
 * 一个参数有返回值
 */
@FunctionalInterface
interface ReturnOneParam {
    int apply(int a);
}
