package source.Chapter13;

public class MultiThreadEx implements Runnable { 
	public void run() { 
		int first = 0; 
		int second = 0; 
		for (int i = 0; i < 20; i++) { 
			first++; 
			second++; 
			System.out.printf("first : %d , " , first); 
			System.out.printf("second : %d , " , second); 
			System.out.printf("������ �̸� : %s %n" , 
					Thread.currentThread().getName()); 
		} 
	} 
	public static void main(String[] args) { 
		MultiThreadEx srt1 = new MultiThreadEx(); 
		Thread firstThread = new Thread(srt1, "ù��° ������"); 
		firstThread.start(); 
		MultiThreadEx srt2 = new MultiThreadEx(); 
		Thread secondThread = new Thread(srt2, "�ι�° ������"); 
		secondThread.start(); 
		MultiThreadEx srt3 = new MultiThreadEx(); 
		Thread thirdThread = new Thread(srt3, "����° ������"); 
		thirdThread.start(); 
	} 
}
