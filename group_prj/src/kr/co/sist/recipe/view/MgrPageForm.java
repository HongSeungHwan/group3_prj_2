package kr.co.sist.recipe.view;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class MgrPageForm extends JDialog {

	private JLabel jlbMenuList, jlbMenuRequest, jlbMember;
	private JTable jtMenuList, jtMenuRequest, jtMember;
	private DefaultTableModel dtmMenuList, dtmMenuRequest, dtmMember;
	private JTabbedPane jtpTab;
	private JButton jbRmvMenu, jbRmvRqust, jbSmitRqust, jbRmvMember, jbClose;
	
	public MgrPageForm() {
		setLayout(null);
		
		jlbMenuList=new JLabel("�޴�����Ʈ");
		jlbMenuRequest=new JLabel("�޴���û����Ʈ");
		jlbMember=new JLabel("��ü ȸ�� ����Ʈ");
		
		jbRmvMenu=new JButton("����");
		jbSmitRqust=new JButton("��û ����");
		jbRmvRqust=new JButton("��û ����");
		jbRmvMember=new JButton("����");
		jbClose=new JButton("�ݱ�");
		
		//���̺�
		String[] menuColumnNames={"�޴���","Ÿ��","����","���ܼ���"};
		String[][] menuData={{"������","���","9000","������ ��δ�"}};
		String[] memberColumnNames={"���̵�","�̸�","�̸���"};
		String[][] memberData={{"reallyreally","winner","winner@yge.com"}};
		// ���̺� ���� ����
		dtmMenuList=new DefaultTableModel(menuData, menuColumnNames){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		// ���̺� ���� ����
		dtmMenuRequest=new DefaultTableModel(menuData, menuColumnNames){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		// ���̺� ���� ����
		dtmMember=new DefaultTableModel(memberData, memberColumnNames){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		jtMenuList=new JTable(dtmMenuList); 
		jtMenuRequest=new JTable(dtmMenuRequest);
		jtMember=new JTable(dtmMember);
		
		jtMenuList.getTableHeader().setReorderingAllowed(false);
		jtMenuRequest.getTableHeader().setReorderingAllowed(false);
		jtMember.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane jspMenuList=new JScrollPane(jtMenuList);
		JScrollPane jspRequest=new JScrollPane(jtMenuRequest);
		JScrollPane jspMember=new JScrollPane(jtMember);
		
		//�г�
		//�޴����� �г�
		JPanel jpMgrMenu=new JPanel();
		jpMgrMenu.setLayout(null);
		jpMgrMenu.add(jlbMenuList);
		jpMgrMenu.add(jlbMenuRequest);
		jpMgrMenu.add(jspMenuList);
		jpMgrMenu.add(jspRequest);
		jpMgrMenu.add(jbRmvMenu);
		jpMgrMenu.add(jbRmvRqust);
		jpMgrMenu.add(jbSmitRqust);
		//ȸ������ �г�
		JPanel jpMgrMember=new JPanel();
		jpMgrMember.setLayout(null);
		jpMgrMember.add(jlbMember);
		jpMgrMember.add(jspMember);
		jpMgrMember.add(jbRmvMember);
		
		//�� ����
		jtpTab=new JTabbedPane();
		jtpTab.add("�޴� ����",jpMgrMenu);
		jtpTab.add("ȸ�� ����", jpMgrMember);
		
		//�̺�Ʈ
		
		
		//�� ��ġ
		jtpTab.setBounds(10, 100, 900, 640);
		//�޴������� ��ġ
		jlbMenuList.setBounds(10, 10, 100, 30);
		jlbMenuRequest.setBounds(10, 310, 100, 30);
		jbRmvMenu.setBounds(790, 10, 100, 30);
		jbSmitRqust.setBounds(790, 310, 100, 30);
		jbRmvRqust.setBounds(680, 310, 100, 30);
		jspMenuList.setBounds(10, 50, 880, 250);
		jspRequest.setBounds(10, 350, 880, 250);
		//ȸ�������� ��ġ
		jlbMember.setBounds(10, 10, 100, 30);
		jbRmvMember.setBounds(790, 10, 100, 30);
		jspMember.setBounds(10, 50, 880, 550);
		
		jbClose.setBounds(810, 750, 100, 30);
		setBounds(50, 50, 940, 840);
		//��ġ
		add(jtpTab);
		add(jbClose);
		
		setVisible(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}//MgrPageForm
	
	public static void main(String[] args) {
		new MgrPageForm();
	}//main

}//class

