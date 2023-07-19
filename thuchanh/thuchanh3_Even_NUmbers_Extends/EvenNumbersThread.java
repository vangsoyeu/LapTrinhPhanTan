package Buoi3_LapTrinhPhanTan.thuchanh.thuchanh3_Even_NUmbers_Extends;

public class EvenNumbersThread extends Thread {
    @Override
    public void run() {
        for (int i = 2; i <= 10; i += 2) {
            System.out.print(i+" ");
        }
    }
}

class Main {
    public static void main(String[] args) {
        EvenNumbersThread evenThread = new EvenNumbersThread();
        evenThread.run();
    }
}