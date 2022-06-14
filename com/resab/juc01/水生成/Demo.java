package com.resab.juc01.水生成;


public class Demo {

    public static void main(String[] args) throws InterruptedException {

        String waters = "HHHHHOHHOOHOHHOHHOHHHHHOHHOOHOHHOHHO";
        H2O h2o = new H2O();

        for (int i = 0; i < waters.length(); i++) {
            int finalI = i;

            Thread thread = new Thread(() -> {
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
            });
            thread.start();
        }


        Thread.sleep(300);
        System.out.println();

    }


}
