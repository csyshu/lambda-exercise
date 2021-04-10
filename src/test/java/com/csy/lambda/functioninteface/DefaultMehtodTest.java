package com.csy.lambda.functioninteface;

/**
 * <p>Description：</p>
 *
 * @author shuyun.cheng
 * @date 2020/10/16 19:25
 */
public class DefaultMehtodTest implements InterfaceTest {

    private volatile static DefaultMehtodTest defaultMehtodTest = null;

    public static DefaultMehtodTest getInstance() {
        if (defaultMehtodTest == null)
            synchronized (DefaultMehtodTest.class) {
                if (defaultMehtodTest == null) {
                    defaultMehtodTest = new DefaultMehtodTest();
                }
            }
        return defaultMehtodTest;
    }

    @Override
    public void accept() {
        System.out.println("accept");
    }

    public static void main(String[] args) {
        DefaultMehtodTest instance = DefaultMehtodTest.getInstance();
        instance.accept();
        instance.andThen();
        instance.andThen1();
    }
}
