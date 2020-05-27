package javaEx;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPEchoServer {
	
	public UDPEchoServer(int port) {
		try {
			DatagramSocket dsocket = new DatagramSocket();
			while(true) {
				byte buffer[]=new byte[512];
				DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
				System.out.println("준비");
				
				//클라이언트가 보내는 데이터를 패킷단위로 받겠다.
				//tcp의 accept역할
				
				dsocket.receive(dp);
				String str=new String(dp.getData());
				System.out.println("수신 데이터: "+str);
				//클라이언트가 보낸 데이터 출력까지
				
				//Echo작업중
				InetAddress ia= dp.getAddress();
				port=dp.getPort();
				System.out.println("Client IP"+ia);
				System.out.println("Client port"+port);
				dp=new DatagramPacket(dp.getData(), dp.getData().length, ia, port);
				dsocket.send(dp);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}

	}//construct close
	
	
	public static void main(String[] args) {
		new UDPEchoServer(3000);
	}
}
