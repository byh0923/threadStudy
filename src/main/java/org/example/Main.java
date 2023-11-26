package org.example;

public class Main {

    /**
     * 자바에서는 JDK가 모든 스레드 관련 속성과 메서드를 스레드 클래스로 압축함.
     *
     *
     * */
    public static void main(String[] args) throws InterruptedException {
        // 스레드 생성
        Thread thread  = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("We are now in thread " + Thread.currentThread().getName());
                System.out.println("Current thread priority is " + Thread.currentThread().getPriority());
            }
        });

        thread.setName("New Worker Thread");

        thread.setPriority(Thread.MAX_PRIORITY);

        // 스레드 시작
        /**
         * jvm이 새 스레드를 생성해서 운영체제에 전달함.
         * */
        // 현재 스레드의 스레드 객체
        System.out.println(Thread.currentThread().getName() + "before starting a new thread");
        thread.start();

        System.out.println(Thread.currentThread().getName() + "after starting a new thread");
        Thread.sleep(10000);

    }

}