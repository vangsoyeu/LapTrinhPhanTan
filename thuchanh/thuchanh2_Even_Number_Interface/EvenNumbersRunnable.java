package Buoi3_LapTrinhPhanTan.thuchanh.thuchanh2_Even_Number_Interface;

public class EvenNumbersRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 2; i <= 10; i += 2) {
            System.out.println(i);
        }
    }
}

class Main {
    public static void main(String[] args) {
        EvenNumbersRunnable evenRunnable = new EvenNumbersRunnable();
        Thread evenThread = new Thread(evenRunnable);
        evenThread.start();
    }
}
