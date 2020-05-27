package javaEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPEchoClient {
	private String str;
	private BufferedReader key; 
	private static int SERVERPORT=3000;
	private DatagramSocket ds;
	public UDPEchoClient(String ip, int port) {
	
	try {
		InetAddress ia = InetAddress.getByName(ip);
		DatagramSocket ds = new DatagramSocket(port);
		//키보드로 입력 받기
		
		System.out.println("message: ");
		key = new BufferedReader(new InputStreamReader(System.in));
		str=key.readLine();
		//입력받은 데이터를 바이트 배열로 저장하기
		//패킷단위로 보내려고 나눔
		
		byte buffer[] = str.getBytes();
		//서버로 전송하기위해 패킷 단위로 생성, 서버포트 지정
		DatagramPacket dp = new DatagramPacket(buffer, buffer.length,ia,SERVERPORT);
		
		//서버에게 키보드로 받은 메세지 전송 중
		ds.send(dp);
		
		//받기위한 준비 시작
		buffer= new byte[512];
		dp = new DatagramPacket(buffer, buffer.length);
		
		//서버로부터 데이터 받기
		ds.receive(dp);
		System.out.println("server ip: "+dp.getAddress()
		           +" , server port : "+dp.getPort());
		System.out.println("수신된 데이터: "+ new String(dp.getData()).trim());
		
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new UDPEchoClient("172.16.1.20",3000);
		}
}