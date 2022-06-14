package com.resab.juc01.水生成.按序打印;

public class Validate {

    public static void main(String[] args) throws InterruptedException {
        String s = "HHOHHOHOHOHHHOHHOHHHOOHHHHOHHOOHHOHH";
        boolean tr = validatWater(s);
        System.out.println(tr);
    }

    private static boolean validatWater(String waters) {
        int length = waters.length();

        int numO = 0;
        for (int i = 0; i < length; i = i + 3) {
            String substring = waters.substring(i, i + 3);

            if ((substring.charAt(0) == 'O')) {
                numO++;
            }
            if ((substring.charAt(1) == 'O')) {
                numO++;
            }
            if ((substring.charAt(2) == 'O')) {
                numO++;
            }

            if (numO != 1) {
                return false;
            }
            numO = 0;

        }

        return true;
    }
}

