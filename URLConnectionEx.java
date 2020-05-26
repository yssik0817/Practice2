package ch15;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;
import java.util.List;

public class URLConnectionEx {
	public static void main(String[] args) throws MalformedURLException, IOException{
		//URL����
		URL url = new URL("https://docs.oracle.com/javase/8/docs/api/");
		//URL Connection��ü �ޱ�
		URLConnection urlCon = url.openConnection();
		//�������� �Ϸ�
		urlCon.connect();
		Map<String,List<String>> map = urlCon.getHeaderFields();
		//java Collection�̶�
		/*
		 * Map, List�� Interface 
		 * Map�� �����ϰ� �մ� ����ü ���� ���� �� 
		 * HashMap List�� ����ü ArrayList
		 * Map�� ���°� key�� value���·� �̷���� �ְ� key��
		 * �ش��ϴ� value�� �������� ������ �ڷᱸ��
		 * 
		 * List�� ���������� �ش�Ǵ� �ε����� ��ġ�� ��ü�� ������� �ڷᱸ��
		 * key=List<String>���·� ������ 
		 * 
		 */
	
		//map�� ����Ǿ� �ִ� ��� Ű ���� �����Ͷ�
		Set<String> s= map.keySet();
		//Set interface�� �� ����ü�� ���� ����.
		//������ �ο��ϰ� ���� �޾ƿ��� ó���� ���� Iterator
		Iterator<String> iter=s.iterator();
		//������� �д� ���
		while(iter.hasNext()) {
			//Ű �̸�
			String name= iter.next();
			System.out.print(name+" : ");
			List<String> value = map.get(name);
			//����� �ϱ� ���ؼ� List���� ��ŭ ���
			for(String v : value) {
				System.out.print(v+"\t");
			}
			System.out.println();
		}
		int len = urlCon.getContentLength();
		System.out.println("�������� : "+len+"����Ʈ");
		if(len>0) {
			InputStream input = urlCon.getInputStream();
			int readByte;
			System.out.println("=========��������==========");
			while((readByte=input.read())!=-1 && (--len>0)) {
				System.out.print((char)readByte);
			}
			input.close();
		}//if close
			else {
			System.out.println("���� ����");
			}
		
	}
}