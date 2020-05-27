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
	BufferedReader keybfr; //���� Ű���� �Է¿�
	public EchoClient(String ip, int port) {
		this.ip=ip;
		this.port=port;
		//���� �����ϴ� �κ� �и�
		
		Socket client = getSocket();
		OutputStream os=null;
		InputStream is=null;
		
		//�������� ��¿�
		BufferedWriter bfw= null;
		BufferedReader bfr= null;
		
		//�������� ���� ������ �б�: �������� �Է¿�

		try {
			os = client.getOutputStream();
			is = client.getInputStream();
			System.out.print("�Է��ϼ���: ");
			str=keybfr.readLine();
			str +=System.getProperty("line.separator");
			bfw= new BufferedWriter(new OutputStreamWriter(os));
			bfr= new BufferedReader(new InputStreamReader(is));
			//Ŭ���̾�Ʈ�� Ű����� �Է¹��� ���� �������� ����
			bfw.write(str);
			bfw.flush();
			
			//������ Ŭ���̾�Ʈ�� ������ ������ �ٽ� ���� ��� �޴� �۾�
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

