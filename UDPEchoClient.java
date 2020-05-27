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
		//Ű����� �Է� �ޱ�
		
		System.out.println("message: ");
		key = new BufferedReader(new InputStreamReader(System.in));
		str=key.readLine();
		//�Է¹��� �����͸� ����Ʈ �迭�� �����ϱ�
		//��Ŷ������ �������� ����
		
		byte buffer[] = str.getBytes();
		//������ �����ϱ����� ��Ŷ ������ ����, ������Ʈ ����
		DatagramPacket dp = new DatagramPacket(buffer, buffer.length,ia,SERVERPORT);
		
		//�������� Ű����� ���� �޼��� ���� ��
		ds.send(dp);
		
		//�ޱ����� �غ� ����
		buffer= new byte[512];
		dp = new DatagramPacket(buffer, buffer.length);
		
		//�����κ��� ������ �ޱ�
		ds.receive(dp);
		System.out.println("server ip: "+dp.getAddress()
		           +" , server port : "+dp.getPort());
		System.out.println("���ŵ� ������: "+ new String(dp.getData()).trim());
		
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new UDPEchoClient("172.16.1.20",3000);
		}
}