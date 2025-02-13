package sec03_threadproperties.EX01;

// 쓰레드 객체 가져오기 / 이름 설정 / 쓰레드 수
public class ThreadProperties_1 {

    public static void main(String[] args) throws InterruptedException {

        //#1 객체 가져오기(currentThread())
        Thread curThread = Thread.currentThread();
        System.out.println("현재 쓰레드 이름 = " + curThread.getName());
        System.out.println("동작하는 쓰레드 수 = " + Thread.activeCount());

        Thread.getAllStackTraces().keySet().forEach(thread ->
                System.out.println("실행 중인 쓰레드: " + thread.getName())
        );

        //# 쓰레드 이름 지정(자동 지정)
        for(int i = 0; i<3; i++) {
            Thread thread = new Thread();
            System.out.println(thread.getName());
            thread.start();
        }

        //#3 쓰레드 이름 직접  지정
        for(int i = 0; i<3; i++) {
            Thread thread = new Thread();
            thread.setName(i+ "번째 쓰레드");
            System.out.println(thread.getName());
            thread.start();
        }

        //#4 쓰레드 이름 자동 지정
        for(int i = 0; i<3; i++) {
            Thread thread = new Thread();
            System.out.println(thread.getName());
            thread.start();
        }

        Thread.sleep(100);
        //#5 쓰레드 수
        System.out.println("동작하는 쓰레드 수 = " + Thread.activeCount());
    }

}
