package sec04_synchronizedmethodandblock.EX03;

//# 공유객체

class MyData {
    int data = 3;
    
    public void plusData() {

        synchronized (this) {
            int mydata = data; // 데이터를 가져오기
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            data = mydata+1;
        }
    }
}

// 공유객체를 사용하는 쓰레드
class PlusThread extends Thread {
    MyData myData;

    public PlusThread(MyData myData) {
        this.myData = myData;
    }

    @Override
    public void run() {
        myData.plusData();
        System.out.println(getName() + "실행 결과 : " + myData.data);
    }
}

public class SynchronizedBlock {

    public static void main(String[] args) {
        //#공유객체 생성
        MyData myData = new MyData();

        //#1 PlusThread1
        Thread plusThread1 = new PlusThread(myData);
        plusThread1.setName("Thread1");
        plusThread1.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //#2 PlusThread2
        Thread plusThread2 = new PlusThread(myData);
        plusThread2.setName("Thread2");
        plusThread2.start();
    }
    
}
