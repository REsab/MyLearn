package com.resab.base;

import java.io.IOException;

/**
 *
 */
public class StrTest {
    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        String str = null;
        str = "hello";
        changeStr(str);
        System.out.println(str);

        str = "hello2";
        System.out.println(str);


        int aaa = 2;
        changeStr(aaa);
        System.out.println(aaa);
    }

    private static void changeStr(int aaa) {
        aaa += 33;
    }

    private static void changeStr(String str) {
        str = "abcccc";
        System.out.println(str);
    }
}