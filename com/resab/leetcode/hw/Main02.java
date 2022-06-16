package com.resab.leetcode.hw;
// 本题为考试单行多行输入输出规范示例，无需提交，不计分。


import java.util.Scanner;

/**
 *
 */
public class Main02 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String input = in.next();
//        String input = "/aaa,/bbb";
        String url = toUrl(input);
        System.out.println(url);
    }

    private static String toUrl(String input) {
        if (input.equals(",")) {
            return "/";
        } else {
            if (input.contains(",")) {
                String[] split = input.split(",");
                for (int i = 0; i < split.length; i++) {
                    int start = 0;
                    int end = split[i].length();
                    if (split[i].startsWith("/")) {
                        start += 1;
                    }
                    if (split[i].endsWith("/")) {
                        end -= 1;
                    }
                    String s1 = split[i].substring(start, end);
                    split[i] = s1;
                }

                StringBuffer stringBuffer = new StringBuffer();
                for (String s : split) {
                    stringBuffer.append("/" + s);
                }
                return stringBuffer.toString();
            } else {
                int start = 0;
                int end = input.length();
                if (input.startsWith("/")) {
                    start += 1;
                }
                if (input.endsWith("/")) {
                    end -= 1;
                }
                String s1 = input.substring(start, end);
                return "/" + s1;
            }
        }
    }
}