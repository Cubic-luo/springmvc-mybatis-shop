package shop.dto;

import java.util.Scanner;

/**
 * 写一些测试的小功能，和本项目无关的，用完请及时删除
 * Created by Administrator on 2017/3/24.
 */
public class Test {
    public static void main(String[] args) {
//     test();
//     number();
        switchTest();
    }
    public static void switchTest(){
        int i=9;
        switch (i){
            case 1:
                System.out.print("");
            default:
                System.out.print("Error");
            case 2:
                System.out.print("Good");
            case 3:
                System.out.print("Best");
        }
    }

    public static void test() {
        int a = 0;//记录）的个数
        Scanner in = new Scanner(System.in);
        System.out.println("请输入需要查询的字符串");
        String str = in.nextLine();
        for (int i = str.length() - 1; i >= 0; i--) {
            char value = str.charAt(i);
            if (value == ')') {
                a++;
            } else if (value == '(') {
                if (a>0){
                    a--;
                }else {
                    System.out.println("无法进行匹配的字符串是位于字符串的第" + (i + 1) + "个位置");
                }

            }

        }
        test();
    }
}
