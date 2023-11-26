package org.example;

public class Main2 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                throw new RuntimeException("Intentional Exception");
            }
        });

        /**
         * 처음부터 전체 스레드에 해당되는 예외 핸들러를 지정할 수 있음.
         * 스레드 내에서 발생한 예외가 어디서도 캐치되지 않으 핸들러가 호출됨
         * 그러면 캐치되지 않은 스레드와 예외를 출력하기만 하면 됨.
         *
         * */

        thread.setName("Misbehaving thread");
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("A critical error happend in Thread " + t.getName() + "the error is " + e.getMessage());
            }
        });
        thread.start();
    }
}
