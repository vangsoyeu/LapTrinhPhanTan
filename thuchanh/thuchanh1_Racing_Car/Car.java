package Buoi3_LapTrinhPhanTan.thuchanh.thuchanh1_Racing_Car;

import java.util.Random;

import static Buoi3_LapTrinhPhanTan.thuchanh.thuchanh1_Racing_Car.Main.DISTANCE;

public class Car implements Runnable{
    // Khai báo Tên của xe đua
    private String name;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        // Khởi tạo điểm start (hay km ban đầu)
        int runDistance = 0;
        // Khởi tạo time bắt đầu cuộc đua
        long startTime = System.currentTimeMillis();
        // Kiểm tra chừng nào còn xe chưa kết thúc quãng đường đua thì xe vẫn tiếp tục chạy
        while (DISTANCE > runDistance) {
            try {
                // Random tốc độ KM/H
                int speed = (new Random()).nextInt(20);
                // Tính toán khoảng cách đã đi được
                runDistance += speed;
                // Vẽ đường đã đi của xe
                String log = "|";
                int percentTravel = (runDistance * 100) / DISTANCE;
                for (int i = 0; i < DISTANCE; i += Main.STEP) {
                    if (percentTravel >= i + Main.STEP) {
                        log += "=";
                    } else if (percentTravel >= i && percentTravel < i + Main.STEP) {
                        log += "o";
                    } else {
                        log += "-";
                    }
                }
                log += "|";
                System.out.println("Car" + this.name + ": " + log + " " + Math.min(DISTANCE, runDistance) + "KM");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Car" + this.name + " broken...");
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Car" + this.name + " Finish in " + (endTime - startTime) / 1000 + "s");
    }
}
