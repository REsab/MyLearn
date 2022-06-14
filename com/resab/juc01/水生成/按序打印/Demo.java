package com.resab.juc01.水生成.按序打印;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo {

    public static void main(String[] args) {

        boolean tr = validatWater("OHHOHHHOHOHHHHOHHOHOHOHHOHHOHHOHHOHH");
        System.out.println(tr);


        String waters = "HHHHHOHHOOHOHHOHHOHHHHHOHHOOHOHHOHHO";
        H2O h2o = new H2O();
        ExecutorService executorService = Executors.newFixedThreadPool(4);


        for (int i = 0; i < waters.length(); i++) {
            int finalI = i;


            new Thread(() -> {
                if (waters.charAt(finalI) == 'H') {
                    try {
                        h2o.hydrogen(() -> System.out.print("H"));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else if (waters.charAt(finalI) == 'O') {
                    try {
                        h2o.oxygen(() -> System.out.print("O"));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    throw new RuntimeException("'water' must consist of values in ['H', 'O'] only");
                }
            }).start();
        }

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
