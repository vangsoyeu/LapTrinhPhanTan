package buoi5_Networking2.ThucHanh.BaiThucHanh2;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        String serverIP = "localhost";
        int serverPort = 2005;

        DatagramSocket clientSocket = new DatagramSocket();
        System.out.println("Client successful connection with server");

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the calculation in the format (Number_A operator Number_B): ");
        String math = scan.nextLine();

        byte[] dataPacked = math.getBytes();
        InetAddress ipAddress = InetAddress.getLocalHost();
        DatagramPacket sendData = new DatagramPacket(dataPacked, dataPacked.length, ipAddress, serverPort);

        clientSocket.send(sendData);

        dataPacked = new byte[65536];
        DatagramPacket receice = new DatagramPacket(dataPacked, dataPacked.length);

        clientSocket.receive(receice);

        String result = new String(receice.getData(), receice.getOffset(), receice.getLength());
        System.out.println("Kết quả = " + result);

        clientSocket.close();
    }
}
