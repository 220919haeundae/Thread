package sec04_synchronizedmethodandblock.EX05;

class MyData {
    synchronized void abc() {
        for(int i=0; i<3; i++) {
            System.out.println(i + "sec");
            try {Thread.sleep(1000);} catch (InterruptedException e) {throw new RuntimeException(e);}
        }
    }

    synchronized void bcd() {
        for(int i=0; i<3; i++) {
            System.out.println(i + "초");
            try {Thread.sleep(1000);} catch (InterruptedException e) {throw new RuntimeException(e);}
        }
    }

    void cde() {
        synchronized (new Object()) {
            for(int i=0; i<3; i++) {
                System.out.println(i + "번째");
                try {Thread.sleep(1000);} catch (InterruptedException e) {throw new RuntimeException(e);}
            }
        }
    }
}

public class KeyObject_2 {

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
