package buoi5_Networking2.ThucHanh.BaiThucHanh2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.StringTokenizer;

public class Server {
    public static void main(String[] args) throws IOException {
        int serverPort = 2005;

        DatagramSocket serverSocket = new DatagramSocket(serverPort);
        System.out.println("Server running...");

        byte[] dataPacked = new byte[65536];
        DatagramPacket receive = new DatagramPacket(dataPacked, dataPacked.length);
        serverSocket.receive(receive);

        String math = new String(receive.getData(), receive.getOffset(), receive.getLength());
        System.out.println("Math get: " + math);

        int result;
        StringTokenizer st = new StringTokenizer(math, " ");

        int numA = Integer.parseInt(st.nextToken());
        String operator = st.nextToken();
        int numB = Integer.parseInt(st.nextToken());

        if (operator.equals("+"))
            result = numA + numB;
        else if (operator.equals("-"))
            result = numA - numB;
        else if (operator.equals("*"))
            result = numA * numB;
        else
            result = numA / numB;

        System.out.println("Sending result...");
        String res = Integer.toString(result);
        dataPacked = res.getBytes();

        int port = receive.getPort();

        DatagramPacket send = new DatagramPacket(dataPacked, dataPacked.length, InetAddress.getLocalHost(), port);
        serverSocket.send(send);

        serverSocket.close();
    }
}
