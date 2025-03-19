package Lesson_02.part1.interfaceRunnable;

public class ThreadExample2 implements Runnable{
    @Override
    public void run() {
        System.out.println("Hello from thread " + Thread.currentThread().getName());
    }
}
