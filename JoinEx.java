package source.Chapter13;
public class JoinEx { 
	public static void main(String[] args){ 
		System.out.println( 
				Thread.currentThread().getName()+" start"); 

		Runnable r = new MyRunnableTwo(); 
		Thread myThread = new Thread(r); 
		myThread.start(); 
		try{ 
			myThread.join(); 
		}catch(InterruptedException ie){ 
			ie.printStackTrace(); 
		} 
		System.out.println( 
				Thread.currentThread().getName()+" end"); 
	} 
} 
