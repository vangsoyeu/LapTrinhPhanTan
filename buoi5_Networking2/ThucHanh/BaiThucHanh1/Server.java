package buoi5_Networking2.ThucHanh.BaiThucHanh1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {
    public static void main(String[] args) throws IOException {
        int serverPort = 8888;

        //Tạo DatagramSocket để liên kết với cổng trên máy chủ:
        DatagramSocket serverSocket = new DatagramSocket(serverPort);
        System.out.println("Server is running and waiting for client...");

        //Tạo 1 mảng byte để nhận dữ liệu từ gói tin nhận được:
        byte[] receiveData = new byte[1024];

        //Tạo 1 DatagramPacket để nhận gói tin từ client
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

        //Nhận gói tin từ Client
        serverSocket.receive(receivePacket);

        //Lấy địa chỉ IP và cổng của Client
        InetAddress clientAddress = receivePacket.getAddress();
        int clientPort = receivePacket.getPort();

        //Chuyển đổi dữ liệu thành dạng chuỗi
        String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println("Received from client: " + message);

        //Chuẩn bị dữ liệu gửi đi
        String responseMessage = "Hello, client!";
        byte[] sendData = responseMessage.getBytes();

        //Tạo datapacket để gửi gói tin đến Client
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
        serverSocket.send(sendPacket);

        //Đóng liên kết...
        serverSocket.close();
    }
}
