package buoi5_Networking2.ThucHanh.BaiThucHanh1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Client {
    public static void main(String[] args) throws IOException {
        //Tạo địa chỉ IP, Port của server và một đối tượng DatagramSocket để kết nối với máy chủ.
        String serverIp = "localhost";
        int serverPort = 8888;
        DatagramSocket clientSocket = new DatagramSocket();

        //Tạo một mảng byte chứa dữ liệu tin nhắn cần gửi
        String message = "Hello, server!";
        byte[] sendData = message.getBytes();

        //Gửi gói tin đến server
        InetAddress serverAddress = InetAddress.getByName(serverIp);
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
        clientSocket.send(sendPacket);

        //Chuẩn bị mảng byte để nhận dữ liệu từ server
        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

        //Nhận gói tin từ server
        clientSocket.receive(receivePacket);

        //Chuyển đổi dữ liệu thành dạng chuỗi và hiển thị
        String responseMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println("Received from server: " + responseMessage);

        //Đóng kết nối DatagramSocket
        clientSocket.close();
    }
}
