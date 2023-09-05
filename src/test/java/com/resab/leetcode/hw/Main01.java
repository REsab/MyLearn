package com.resab.leetcode.hw;
// 本题为考试单行多行输入输出规范示例，无需提交，不计分。

/**
 *
 * 数字涂色
 * 题目描述
 * 疫情过后，希望小学终于又重新开学了，三年二班开学第一天的任务是将后面的黑板报重新制作。黑板上已经写上了N个正整数，同学们需要给这每个数分别上一种颜色。为了让黑板报既美观又有学习意义，老师要求同种颜色的所有数都可以被这种颜色中最小的那个数整除。现在请你帮帮小朋友们，算算最少需要多少种颜色才能给这N个数进行上色。
 *
 * 输入描述
 * 第一行有一个正整数N，其中1≤N≤100。
 * 第二行有N个int型数(保证输入数据在[1,100]范围中)，表示黑板上各个正整数的值。
 *
 * 输出描述
 * 输出只有一个整数，为最少需要的颜色种数。
 *
 *
 */
public class Main01 {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
//            int n = in.nextInt();
//
//            if (n < 0 || n > 100) {
//                break;
//            }
//
//            int[] array = new int[n];
//            for (int i = 0; i < n; i++) {
//                array[i] = in.nextInt();
//                if (array[i] < 0 || array[i] > 100) {
//                    break;
//                }
//            }
//
//            System.out.println("input : ");
//            System.out.println(n);
//            for (int i : array) {
//                System.out.println(i);
//            }
//            int num = resovle(n, array);
//            System.out.println(num);
//    }


        int n = 8;
        int[] array = new int[]{3, 9, 6, 8, 77, 43, 21, 33};
        int num = resovle(n, array);
        System.out.println();
        System.out.println(num);
    }


    private static int resovle(int n, int[] array) {

//1 排序
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n - 1; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        // 2 标记可被整除的位置
        for (int i = 0; i < n; i++) {
            if (array[i] != -1) {
                for (int j = i + 1; j <= n - 1; j++) {
                    if (array[j] != -1) {
                        if (array[j] % array[i] == 0) {

                            array[j] = -1;
                        }
                    }
                }
            }
        }

        int result = 0;
        for (int i : array) {
            if (i !=  -1) {
                 result++;
            }
        }
        return result;
    }
}