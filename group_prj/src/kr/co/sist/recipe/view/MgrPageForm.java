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
		String[] menuColumnNames={"�޴��̸�","�޴��̹���","�޴�Ÿ��","���ܼ���","����"};
		String[][] menuData={{"","","",""}};
		String[] memberColumnNames={"���̵�","�̸�","�̸���"};
		String[][] memberData={{"","",""}};
//		String[] menuColumnNames={"�޴���","Ÿ��","����","���ܼ���"};
//		String[][] menuData={{"������","���","9000","������ ��δ�"}};
//		String[] memberColumnNames={"���̵�","�̸�","�̸���"};
//		String[][] memberData={{"reallyreally","winner","winner@yge.com"}};
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

	public JLabel getJlbMenuList() {
		return jlbMenuList;
	}

	public void setJlbMenuList(JLabel jlbMenuList) {
		this.jlbMenuList = jlbMenuList;
	}

	public JLabel getJlbMenuRequest() {
		return jlbMenuRequest;
	}

	public void setJlbMenuRequest(JLabel jlbMenuRequest) {
		this.jlbMenuRequest = jlbMenuRequest;
	}

	public JLabel getJlbMember() {
		return jlbMember;
	}

	public void setJlbMember(JLabel jlbMember) {
		this.jlbMember = jlbMember;
	}

	public JTable getJtMenuList() {
		return jtMenuList;
	}

	public void setJtMenuList(JTable jtMenuList) {
		this.jtMenuList = jtMenuList;
	}

	public JTable getJtMenuRequest() {
		return jtMenuRequest;
	}

	public void setJtMenuRequest(JTable jtMenuRequest) {
		this.jtMenuRequest = jtMenuRequest;
	}

	public JTable getJtMember() {
		return jtMember;
	}

	public void setJtMember(JTable jtMember) {
		this.jtMember = jtMember;
	}

	public DefaultTableModel getDtmMenuList() {
		return dtmMenuList;
	}

	public void setDtmMenuList(DefaultTableModel dtmMenuList) {
		this.dtmMenuList = dtmMenuList;
	}

	public DefaultTableModel getDtmMenuRequest() {
		return dtmMenuRequest;
	}

	public void setDtmMenuRequest(DefaultTableModel dtmMenuRequest) {
		this.dtmMenuRequest = dtmMenuRequest;
	}

	public DefaultTableModel getDtmMember() {
		return dtmMember;
	}

	public void setDtmMember(DefaultTableModel dtmMember) {
		this.dtmMember = dtmMember;
	}

	public JTabbedPane getJtpTab() {
		return jtpTab;
	}

	public void setJtpTab(JTabbedPane jtpTab) {
		this.jtpTab = jtpTab;
	}

	public JButton getJbRmvMenu() {
		return jbRmvMenu;
	}

	public void setJbRmvMenu(JButton jbRmvMenu) {
		this.jbRmvMenu = jbRmvMenu;
	}

	public JButton getJbRmvRqust() {
		return jbRmvRqust;
	}

	public void setJbRmvRqust(JButton jbRmvRqust) {
		this.jbRmvRqust = jbRmvRqust;
	}

	public JButton getJbSmitRqust() {
		return jbSmitRqust;
	}

	public void setJbSmitRqust(JButton jbSmitRqust) {
		this.jbSmitRqust = jbSmitRqust;
	}

	public JButton getJbRmvMember() {
		return jbRmvMember;
	}

	public void setJbRmvMember(JButton jbRmvMember) {
		this.jbRmvMember = jbRmvMember;
	}

	public JButton getJbClose() {
		return jbClose;
	}

	public void setJbClose(JButton jbClose) {
		this.jbClose = jbClose;
	}

}//class

