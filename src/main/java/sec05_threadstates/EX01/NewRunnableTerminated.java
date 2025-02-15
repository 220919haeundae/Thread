package sec05_threadstates.EX01;

public class NewRunnableTerminated {
    public static void main(String[] args) {
        //#쓰레드 상태 저장 클래스
        Thread.State state;

        //#1 객체 생성(NEW)
        Thread thread = new Thread() {
            @Override
            public void run() {
                for(long i=0; i<1000000000L; i++) {} //시간지연
            }
        };

        state = thread.getState();
        System.out.println("thread sate = " + state); //NEW

        //# Thread 시작
        thread.start();
        state = thread.getState();
        System.out.println("thread sate = " + state); //Runnable

        //#3 Thread 종료
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        state = thread.getState();
        System.out.println("thread sate = " + state); //TERMINATED

    }
}
