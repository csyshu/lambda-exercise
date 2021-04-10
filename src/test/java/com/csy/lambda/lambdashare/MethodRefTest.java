package com.csy.lambda.lambdashare;

/**
 * <p>Description：方法引用测试</p>
 *
 * @author shuyun.cheng
 * @date 2020/10/28 20:50
 */
public class MethodRefTest {
    public static void main(String[] args) {
        ReturnOneParam lambda1 = a -> doubleNum(a);
        System.out.println(lambda1.apply(3));

        //lambda2 引用了已经实现的 doubleNum 方法
        ReturnOneParam lambda2 = MethodRefTest::doubleNum;
        System.out.println(lambda2.apply(3));

        MethodRefTest exe = new MethodRefTest();

        //lambda4 引用了已经实现的 addTwo 方法
        ReturnOneParam lambda4 = exe::addTwo;
        System.out.println(lambda4.apply(2));
    }

    /**
     * 要求
     * 1.参数数量和类型要与接口中定义的一致
     * 2.返回值类型要与接口中定义的一致
     */
    public static int doubleNum(int a) {
        return a * 2;
    }

    public int addTwo(int a) {
        return a + 2;
    }
}
