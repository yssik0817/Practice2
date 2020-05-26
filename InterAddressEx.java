package ch15;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InterAddressEx {
	public static void main(String[] args) throws UnknownHostException {
		
			InetAddress iaddr
			 = InetAddress.getLocalHost();
			
			System.out.println("호스트이름: "+ iaddr.getHostName());
			System.out.println("호스트IP주소: "+iaddr.getHostAddress());
		
			iaddr=InetAddress.getByName("www.google.co.kr");
			System.out.println("호스트이름: "+ iaddr.getHostName());
			System.out.println("호스트IP주소: "+iaddr.getHostAddress());
		
			iaddr=InetAddress.getByName("www.daum.net");
			System.out.println("호스트이름: "+ iaddr.getHostName());
			System.out.println("호스트IP주소: "+iaddr.getHostAddress());
			
		}
	}

