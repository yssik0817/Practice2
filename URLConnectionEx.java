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
		//URL생성
		URL url = new URL("https://docs.oracle.com/javase/8/docs/api/");
		//URL Connection객체 받기
		URLConnection urlCon = url.openConnection();
		//실제연결 완료
		urlCon.connect();
		Map<String,List<String>> map = urlCon.getHeaderFields();
		//java Collection이란
		/*
		 * Map, List는 Interface 
		 * Map을 구현하고 잇는 구현체 많이 쓰는 것 
		 * HashMap List를 구현체 ArrayList
		 * Map은 형태가 key와 value형태로 이루어져 있고 key에
		 * 해당하는 value를 가져오는 형태의 자료구조
		 * 
		 * List는 순차적으로 해당되는 인덱스에 위치한 객체를 갖고오는 자료구조
		 * key=List<String>형태로 가져옴 
		 * 
		 */
	
		//map에 저장되어 있는 모든 키 값을 가져와라
		Set<String> s= map.keySet();
		//Set interface로 그 구현체는 순서 없음.
		//순서를 부여하고 값을 받아오는 처리에 유용 Iterator
		Iterator<String> iter=s.iterator();
		//순서대로 읽는 방법
		while(iter.hasNext()) {
			//키 이름
			String name= iter.next();
			System.out.print(name+" : ");
			List<String> value = map.get(name);
			//출력을 하기 위해서 List길이 만큼 출력
			for(String v : value) {
				System.out.print(v+"\t");
			}
			System.out.println();
		}
		int len = urlCon.getContentLength();
		System.out.println("문서길이 : "+len+"바이트");
		if(len>0) {
			InputStream input = urlCon.getInputStream();
			int readByte;
			System.out.println("=========문서내용==========");
			while((readByte=input.read())!=-1 && (--len>0)) {
				System.out.print((char)readByte);
			}
			input.close();
		}//if close
			else {
			System.out.println("내용 없음");
			}
		
	}
}