package sec03_threadproperties.EX04;

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(getName() + " : " + (isDaemon() ? "데몬쓰레드" : "일반쓰레드"));
        for(int i = 0; i < 6; i++) {
            System.out.println(getName() + " : " + i + "초");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class ThreadProperties_3_2 {

    public static void main(String[] args) throws InterruptedException {

//        //#1 일반 쓰레드
//        Thread thread1 = new MyThread();
//        thread1.setDaemon(false);
//        thread1.setName("thread1");
//        thread1.start();

        //#2 데몬 쓰레드
        Thread thread2 = new MyThread();
        thread2.setDaemon(true);
        thread2.setName("thread2");
        thread2.start();

        //#3 3초 후 main thread 종료
        Thread.sleep(3100);
        System.out.println("main Thread 종료");

    }


}
