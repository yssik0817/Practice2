package ch15;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InterAddressEx {
	public static void main(String[] args) throws UnknownHostException {
		
			InetAddress iaddr
			 = InetAddress.getLocalHost();
			
			System.out.println("ȣ��Ʈ�̸�: "+ iaddr.getHostName());
			System.out.println("ȣ��ƮIP�ּ�: "+iaddr.getHostAddress());
		
			iaddr=InetAddress.getByName("www.google.co.kr");
			System.out.println("ȣ��Ʈ�̸�: "+ iaddr.getHostName());
			System.out.println("ȣ��ƮIP�ּ�: "+iaddr.getHostAddress());
		
			iaddr=InetAddress.getByName("www.daum.net");
			System.out.println("ȣ��Ʈ�̸�: "+ iaddr.getHostName());
			System.out.println("ȣ��ƮIP�ּ�: "+iaddr.getHostAddress());
			
		}
	}

