package com.hackbulgaria.corejava;

public class WaitNotifyMechanism {
    public static long startTime = System.currentTimeMillis();
    public static Integer counter = 0;
    public static final Object monitor = new Object();
    private static int turn = 0;

    public static void increment() {
        System.out.println("Incrementing from Thread : " + Thread.currentThread().getName() + " " + counter );
        counter++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread() {
            public void run() {
                for (int i = 0; i < 2_000_000; i++) {
                    synchronized (monitor) {
                        while (turn != 1) {
                            try {
                                monitor.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }
                        increment();

                        turn = (turn + 1) % 2;
                        monitor.notify();
                    }

                }
            }
        };
        Thread t2 = new Thread() {

            public void run() {
                for (int i = 0; i < 2_000_000; i++) {
                    synchronized (monitor) {
                        while (turn != 0) {
                            try {
                                monitor.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                        increment();

                        turn = (turn + 1) % 2;
                        monitor.notify();
                    }
                }
            }
        };
        t1.setName("T1");
        t2.setName("T2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counter);
        System.out.println(System.currentTimeMillis() - startTime);
    }
}