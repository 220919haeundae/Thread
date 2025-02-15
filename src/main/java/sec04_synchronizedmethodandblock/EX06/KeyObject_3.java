package sec04_synchronizedmethodandblock.EX06;

class MyData {
    synchronized void abc() {
        for(int i=0; i<3; i++) {
            System.out.println(i + "sec");
            try {Thread.sleep(1000);} catch (InterruptedException e) {throw new RuntimeException(e);}
        }
    }

    synchronized void bcd() {
        System.out.println(Thread.currentThread().getName() + " - bcd() 진입");
        synchronized (SynchronizedKey.A_KEY.getLock()) {
            System.out.println(Thread.currentThread().getName() + " - A_KEY 락 획득");
            for(int i=0; i<3; i++) {
                System.out.println(i + "초");
                try { Thread.sleep(1000); } catch (InterruptedException e) { throw new RuntimeException(e); }
            }
            System.out.println(Thread.currentThread().getName() + " - A_KEY 락 해제");
        }
    }

    void cde() {
        System.out.println(Thread.currentThread().getName() + " - cde() 진입");
        synchronized (SynchronizedKey.A_KEY.getLock()) {
            System.out.println(Thread.currentThread().getName() + " - A_KEY 락 획득");
            for(int i=0; i<3; i++) {
                System.out.println(i + "번째");
                try { Thread.sleep(1000); } catch (InterruptedException e) { throw new RuntimeException(e); }
            }
            System.out.println(Thread.currentThread().getName() + " - A_KEY 락 해제");
        }
    }
}

public class KeyObject_3 {

    public static void main(String[] args) {
        MyData myData = new MyData();

        new Thread() {
            public void run() {
                myData.abc();
            }
        }.start();

        new Thread() {
            public void run() {
                myData.bcd();
            }
        }.start();

        new Thread() {
            public void run() {
                myData.cde();
            }
        }.start();

    }

}
