package javaEx;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class EchoClient {
	private String ip;
	private int port;
	private String str;
	BufferedReader keybfr; //현재 키보드 입력용
	public EchoClient(String ip, int port) {
		this.ip=ip;
		this.port=port;
		//소켓 생성하는 부분 분리
		
		Socket client = getSocket();
		OutputStream os=null;
		InputStream is=null;
		
		//서버와의 출력용
		BufferedWriter bfw= null;
		BufferedReader bfr= null;
		
		//서버에서 에코 날린거 읽기: 서버와의 입력용

		try {
			os = client.getOutputStream();
			is = client.getInputStream();
			System.out.print("입력하세요: ");
			str=keybfr.readLine();
			str +=System.getProperty("line.separator");
			bfw= new BufferedWriter(new OutputStreamWriter(os));
			bfr= new BufferedReader(new InputStreamReader(is));
			//클라이언트가 키보드로 입력받은 것을 서버에게 전달
			bfw.write(str);
			bfw.flush();
			
			//서버가 클라이언트가 전달한 내용을 다시 보낼 경우 받는 작업
			str=bfr.readLine();
			System.out.println("Echo Result: "+str);
		} catch (IOException e) {
			e.printStackTrace();
		 }finally {
	         if (keybfr != null) {
	            try {
	               keybfr.close();
	            } catch (IOException e) {}
	         }
	         if (bfr != null) {
	            try {
	               bfr.close();
	            } catch (IOException e) {}
	         }
	         if (bfw != null) {
	            try {
	               bfw.close();
	            } catch (IOException e) {}
	         }
	         if (is != null) {
	            try {
	               is.close();
	            } catch (IOException e) {}
	         }
	         if (os != null) {
	            try {
	               os.close();
	            } catch (IOException e) {}
	         }
	            
	      }
	      
			keybfr=new BufferedReader(new InputStreamReader(System.in));
		
	}//construct close
	
	public Socket getSocket() {
		Socket c=null;
		try {
			c=new Socket(ip, port);
		}catch(IOException e) {
			
		}
		return null;
	}

	public static void main(String[] args) {
		new EchoClient("172.16.1.20",6000);
	}
	
	}

