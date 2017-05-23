package kr.co.sist.recipe.view;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class MyPageForm extends JDialog {

	private JLabel jlbMyMenu, jlbFavorMenu;
	private JTable jtMyMenu, jtFavorMenu;
	private DefaultTableModel dtmMyMenu, dtmFavorMenu;
	private JButton jbRmvFavorMenu, jbEditMyInfo, jbClose;
	
	public MyPageForm() {
		setLayout(null);
		
		jlbMyMenu=new JLabel("���� ����� �޴�");
		jlbFavorMenu=new JLabel("�ϸ�ũ ����Ʈ");
		
		jbEditMyInfo=new JButton("�� ���� ����");
		jbRmvFavorMenu=new JButton("�ϸ�ũ ����");
		jbClose=new JButton("�ݱ�");
		
		//���̺�
		String[] menuColumnNames={"�޴���","Ÿ��","����","���ܼ���"};
		String[][] menuData={{"������","���","9000","������ ��δ�"}};
		// ���̺� ���� ����
		dtmMyMenu=new DefaultTableModel(menuData, menuColumnNames){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		// ���̺� ���� ����
		dtmFavorMenu=new DefaultTableModel(menuData, menuColumnNames){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		jtMyMenu=new JTable(dtmMyMenu); 
		jtFavorMenu=new JTable(dtmFavorMenu);
		
		jtMyMenu.getTableHeader().setReorderingAllowed(false);
		jtFavorMenu.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane jspMenuList=new JScrollPane(jtMyMenu);
		JScrollPane jspRequest=new JScrollPane(jtFavorMenu);
		
		//�г�
		//���������� �г�
		JPanel jpMyMenu=new JPanel();
		jpMyMenu.setBorder(new TitledBorder("MyPage"));
		jpMyMenu.setLayout(null);
		jpMyMenu.add(jlbMyMenu);
		jpMyMenu.add(jlbFavorMenu);
		jpMyMenu.add(jspMenuList);
		jpMyMenu.add(jspRequest);
		jpMyMenu.add(jbRmvFavorMenu);
		
		//�̺�Ʈ
		
		
		//�г� ��ġ
		jpMyMenu.setBounds(10, 100, 900, 640);
		//�г� ��ġ
		jlbMyMenu.setBounds(10, 30, 100, 30);
		jlbFavorMenu.setBounds(10, 330, 100, 30);
		jbRmvFavorMenu.setBounds(780, 330, 110, 30);
		jspMenuList.setBounds(10, 70, 880, 250);
		jspRequest.setBounds(10, 370, 880, 250);
		
		jbEditMyInfo.setBounds(10, 750, 110, 30);
		jbClose.setBounds(810, 750, 100, 30);
		setBounds(50, 50, 940, 840);
		//��ġ
		add(jpMyMenu);
		add(jbEditMyInfo);
		add(jbClose);
		
		setVisible(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}//MgrPageForm
	public static void main(String[] args) {
		new MyPageForm();
	}//main

}//class

