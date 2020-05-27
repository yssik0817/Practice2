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
	//통신하기 위해서는 데이터가 읽고 쓰고
	//입출력 stream가 reader, writer
	//버퍼를 활용할 시에 flush가 가능해서 빨라짐
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
			System.out.println("클라이언트 요청 대기중");
			try {
				Socket tclient = serverSoc.accept();
				System.out.println("클라이언트 IP 주소: "
						+tclient.getInetAddress().getHostAddress());
				//클라이언트와의 입력과 출력을 위한 연결 완성
				is=tclient.getInputStream();
				os=tclient.getOutputStream();
				bfr=new BufferedReader(new InputStreamReader(is));
				bfw=new BufferedWriter(new OutputStreamWriter(os));
				String msg=bfr.readLine();
				System.out.println("수신메시지: "+msg);
				//선을 추가아혀 분리함
				msg+=System.getProperty("line.separator");
				//받은 메시지 다시 클라이언트에 전달
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
