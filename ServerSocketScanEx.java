package ch15;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.ServerSocket;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ServerSocketScanEx extends JFrame implements ActionListener, Runnable{
	
	private JButton jbt_scan;
	private JTextField jtp_ip;
	private JList<Object> jlistRts;
	private JLabel jlbIp;
	private DefaultListModel<Object> lmodel;
	private int index;
	private String ip;
	
	public ServerSocketScanEx(String msg) {
		super(msg);
		jbt_scan=new JButton("서비스캔");
		lmodel= new DefaultListModel<Object>();
				jlistRts = new JList<Object>(lmodel);
				//한 번에 10줄 씩 출력
				jlistRts.setVisibleRowCount(10);
				//패널 만들기
				JPanel jp = new JPanel();
				//버튼 추가
				jp.add(jbt_scan);
				
				//버튼에 action event걸기
				jbt_scan.addActionListener(this);
				//스크롤 팬 생성
				JScrollPane jsp = new JScrollPane(jlistRts);
				//jframe에 추가
				add(jsp,BorderLayout.CENTER);
				add(jp,BorderLayout.SOUTH);
				//묶기
				pack();
				setVisible(true);
				addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent we) {
						System.exit(0);
					}
				});
	}
	
	//이벤트 처리 로직 actionListner에 대한 
	public void actionPerformed(ActionEvent ae) {
		Object obj=ae.getSource();
		if(obj==jbt_scan) {
			lmodel.insertElementAt(ip, index);
			jlistRts.setSelectedIndex(index);
			index++;
			Thread t = new Thread(this);
			t.start();
		}
	}
	
	public void run() {
		//server소켓을 생성하기 위해 선언
		ServerSocket s=null;
		for(int i = 1; i<65356; i++) {
			try {
				//내 IP가 서버이고 포트번호를 생성 
				s=new ServerSocket(i);
				System.out.println(s.getLocalPort());
			} catch (IOException e) {
				lmodel.insertElementAt(i+"번 포트가 사용 중입니다.", index);
				jlistRts.setSelectedIndex(index);
				} 
			}
			lmodel.insertElementAt("서버 스캔 종료",index);
			jlistRts.setSelectedIndex(index);
		}
	
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new ServerSocketScanEx("ServerSocket Scanner");
	}
}
