package com.resab.leetcode.hw;
// 本题为考试单行多行输入输出规范示例，无需提交，不计分。

/**
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