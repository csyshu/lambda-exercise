package com.csy.lambda.lambdashare;

/**
 * <p>Description：</p>
 *
 * @author shuyun.cheng
 * @date 2020/10/28 21:03
 */
public class CreateThreadTest {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("循环:" + i);
            }
        });
        t.start();
    }
}
