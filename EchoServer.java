package javaEx;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	//����ϱ� ���ؼ��� �����Ͱ� �а� ����
	//����� stream�� reader, writer
	//���۸� Ȱ���� �ÿ� flush�� �����ؼ� ������
	private BufferedReader bfr;		//import = shift+crtl+o
	private BufferedWriter bfw;
	private InputStream is;
	private OutputStream os;
	private ServerSocket serverSoc;
	
	public EchoServer(int port) {
		
		try {
			serverSoc = new ServerSocket(port);
		}catch(IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
		while(true) {
			System.out.println("Ŭ���̾�Ʈ ��û �����");
			try {
				Socket tclient = serverSoc.accept();
				System.out.println("Ŭ���̾�Ʈ IP �ּ�: "
						+tclient.getInetAddress().getHostAddress());
				//Ŭ���̾�Ʈ���� �Է°� ����� ���� ���� �ϼ�
				is=tclient.getInputStream();
				os=tclient.getOutputStream();
				bfr=new BufferedReader(new InputStreamReader(is));
				bfw=new BufferedWriter(new OutputStreamWriter(os));
				String msg=bfr.readLine();
				System.out.println("���Ÿ޽���: "+msg);
				//���� �߰����� �и���
				msg+=System.getProperty("line.separator");
				//���� �޽��� �ٽ� Ŭ���̾�Ʈ�� ����
				bfw.write(msg);
				bfw.flush();
				bfw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				if(bfr!=null)
					try {
						bfr.close();
					} catch (IOException e) {
					if(bfw!=null)
						try {
						bfw.close();
					} catch (IOException e1) {}
					if(is!=null)
						
						try {
							is.close();
							} catch (IOException e1) {}
					if(os!=null)
						try {
							os.close();
							} catch (IOException e1) {}
							}
					}
			}
		}
	//construct close
	
	public static void main(String[] args) {
		new EchoServer(9000);
	}
}
