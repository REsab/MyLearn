package com.resab.leetcode.hw;
// 本题为考试单行多行输入输出规范示例，无需提交，不计分。


import java.util.Scanner;

/**
 *https://blog.csdn.net/weixin_47243236/article/details/123018920?ops_request_misc=&request_id=&biz_id=102&utm_term=%E5%8D%8E%E4%B8%BA%E6%9C%BA%E8%AF%95%20%E9%93%BE%E6%8E%A5%E6%8B%BC%E6%8E%A5&utm_medium=distribute.pc_search_result.none-task-blog-2~all~sobaiduweb~default-1-123018920.142^v17^pc_search_result_control_group,157^v14^new_3&spm=1018.2226.3001.4187
 *
 *题目描述：
 *
 * 给定一个url前缀和url后缀,通过,分割 需要将其连接为一个完整的url
 * 如果前缀结尾和后缀开头都没有/，需要自动补上/连接符
 * 如果前缀结尾和后缀开头都为/，需要自动去重
 * 约束：不用考虑前后缀URL不合法情况
 *
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