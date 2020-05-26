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
		jbt_scan=new JButton("����ĵ");
		lmodel= new DefaultListModel<Object>();
				jlistRts = new JList<Object>(lmodel);
				//�� ���� 10�� �� ���
				jlistRts.setVisibleRowCount(10);
				//�г� �����
				JPanel jp = new JPanel();
				//��ư �߰�
				jp.add(jbt_scan);
				
				//��ư�� action event�ɱ�
				jbt_scan.addActionListener(this);
				//��ũ�� �� ����
				JScrollPane jsp = new JScrollPane(jlistRts);
				//jframe�� �߰�
				add(jsp,BorderLayout.CENTER);
				add(jp,BorderLayout.SOUTH);
				//����
				pack();
				setVisible(true);
				addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent we) {
						System.exit(0);
					}
				});
	}
	
	//�̺�Ʈ ó�� ���� actionListner�� ���� 
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
		//server������ �����ϱ� ���� ����
		ServerSocket s=null;
		for(int i = 1; i<65356; i++) {
			try {
				//�� IP�� �����̰� ��Ʈ��ȣ�� ���� 
				s=new ServerSocket(i);
				System.out.println(s.getLocalPort());
			} catch (IOException e) {
				lmodel.insertElementAt(i+"�� ��Ʈ�� ��� ���Դϴ�.", index);
				jlistRts.setSelectedIndex(index);
				} 
			}
			lmodel.insertElementAt("���� ��ĵ ����",index);
			jlistRts.setSelectedIndex(index);
		}
	
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new ServerSocketScanEx("ServerSocket Scanner");
	}
}
