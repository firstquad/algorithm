package ru.firstquad.algorithm.task;

/**
 * Created by DVFirstov 26.07.18
 */
public class PingPong {

    public static void main(String[] args) {
        Pong pong = new Pong();
        new Thread(pong, "ping").start();
        new Thread(pong, "pong").start();
    }

    public static class Pong implements Runnable {
        private int count;

        @Override
        public synchronized void run() {
            while (count < 5) {
                count++;
                System.out.println(Thread.currentThread().getName());
                notifyAll();

                try {
                    if (count < 5)
                        wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
