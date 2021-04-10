package com.csy.lambda.lambdacommon;


import java.util.function.Function;

/**
 * <p>Description：
 * 主体语句测试：
 * 在lambda表达式主体中的语句可以使用 break ， continue ， return 和 throw。
 * 不能使用跳转语句做非局部跳转。
 * </p>
 *
 * @author shuyun.cheng
 * @date 2020/10/20 21:03
 */
public class BodySentenceTest {
    @Test
    public void test1() {
        Function<String, String> func1 = y -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                if (i == 4) {
                    break;
                }
            }
            return y + " BodySentenceTest";
        };
        System.out.println(func1.apply("hi"));
    }

    @Test
    public void test2() {
        for(int i=0;i<10;i++){
            System.out.println(i);
            if(i == 4){

                Function<String,String> func1 = y -> {
                    //break;
                    return y + " BodySentenceTest" ;
                };
                System.out.println(func1.apply("hi"));

            }
        }
    }
}
