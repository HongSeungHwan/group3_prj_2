package kr.co.sist.recipe.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.recipe.evt.MyPageEvt;

/**
 * ������������
 * <��������>
 * 1. MyPageEvt ��ü�� ���� : mype > mype
 * @author JiYong
 *
 */
@SuppressWarnings("serial")
public class MyPageForm extends JDialog {

    private JLabel jlbMyMenu, jlbFavorMenu;
    private JTable jtMyMenu, jtFavorMenu;
    private DefaultTableModel dtmMyMenu, dtmFavorMenu;
    private JButton jbRmvMyMenu, jbRmvFavorMenu, jbEditMyInfo, jbClose;

    public MyPageForm(String logId) {
        setLayout(null);
        System.out.println("MyPage : "+logId);
        jlbMyMenu=new JLabel("���� ����� �޴�");
        jlbFavorMenu=new JLabel("�ϸ�ũ ����Ʈ");
        
		JLabel jlUserName=new JLabel(" [ "+logId+" ]�� ȯ���մϴ�.");
		jlUserName.setFont(new Font("", Font.BOLD, 15));
        
        jbEditMyInfo=new JButton("�� ���� ����");
        jbRmvMyMenu=new JButton("��û���� ����");
        jbRmvFavorMenu=new JButton("�ϸ�ũ ����");
        jbClose=new JButton("�ݱ�");
 
        //���̺�
        String[] menuColumnNames={"�̸�","�̹���","Ÿ��","���ܼҰ�","����","��ϻ���"};
        String[][] menuData={};
        // ���̺� ���� ����
        dtmMyMenu=new DefaultTableModel(menuData, menuColumnNames){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        //�ϸ�ũ ���̺�
        String[] bookmarkColumnNames={"�̸�","�̹���","Ÿ��","���ܼҰ�","����"};
        String[][] bkData={};
        // ���̺� ���� ����
        dtmFavorMenu=new DefaultTableModel(bkData, bookmarkColumnNames){
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
        jpMyMenu.add(jbRmvMyMenu);
        jpMyMenu.add(jbRmvFavorMenu);

        //�̺�Ʈ
        MyPageEvt mype = new MyPageEvt(this, logId);
        jtMyMenu.addMouseListener(mype);
        jbRmvMyMenu.addActionListener(mype);
        jbRmvFavorMenu.addActionListener(mype);
        jbEditMyInfo.addActionListener(mype);
        jbClose.addActionListener(mype);

        //�г� ��ġ
        jpMyMenu.setBounds(10, 100, 900, 640);
        //�г� ��ġ
        jlbMyMenu.setBounds(10, 30, 100, 30);
        jlbFavorMenu.setBounds(10, 330, 100, 30);
        jbRmvMyMenu.setBounds(780, 30, 110, 30);
        jbRmvFavorMenu.setBounds(780, 330, 110, 30);
        jspMenuList.setBounds(10, 70, 880, 250);
        jspRequest.setBounds(10, 370, 880, 250);

		// ����� ���̵� �� ��ġ
		jlUserName.setBounds(20, 10, 170, 30);
        
        jbEditMyInfo.setBounds(10, 750, 110, 30);
        jbClose.setBounds(810, 750, 100, 30);
        setBounds(50, 50, 940, 840);
        //��ġ
        add(jpMyMenu);
        add(jbEditMyInfo);
        add(jbClose);
		// ����� ���̵� �� ���̱�
		add(jlUserName);
        
        setVisible(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }//MgrPageForm



    public JButton getJbRmvFavorMenu() {
        return jbRmvFavorMenu;
    }



    public JButton getJbEditMyInfo() {
        return jbEditMyInfo;
    }



    public JButton getJbClose() {
        return jbClose;
    }




    public DefaultTableModel getDtmMyMenu() {
        return dtmMyMenu;
    }



    public void setDtmMyMenu(DefaultTableModel dtmMyMenu) {
        this.dtmMyMenu = dtmMyMenu;
    }



    public DefaultTableModel getDtmFavorMenu() {
        return dtmFavorMenu;
    }



    public void setDtmFavorMenu(DefaultTableModel dtmFavorMenu) {
        this.dtmFavorMenu = dtmFavorMenu;
    }



    public JTable getJtMyMenu() {
        return jtMyMenu;
    }



    public void setJtMyMenu(JTable jtMyMenu) {
        this.jtMyMenu = jtMyMenu;
    }



    public JTable getJtFavorMenu() {
        return jtFavorMenu;
    }



    public void setJtFavorMenu(JTable jtFavorMenu) {
        this.jtFavorMenu = jtFavorMenu;
    }



    public void setJbRmvFavorMenu(JButton jbRmvFavorMenu) {
        this.jbRmvFavorMenu = jbRmvFavorMenu;
    }



    public void setJbEditMyInfo(JButton jbEditMyInfo) {
        this.jbEditMyInfo = jbEditMyInfo;
    }



    public void setJbClose(JButton jbClose) {
        this.jbClose = jbClose;
    }

    


	public JButton getJbRmvMyMenu() {
		return jbRmvMyMenu;
	}



	public void setJbRmvMyMenu(JButton jbRmvMyMenu) {
		this.jbRmvMyMenu = jbRmvMyMenu;
	}



	///////////////////////////////////////////////���� �������////////////////////////////////////
//    public static void main(String[] args) {
//        new MyPageForm(String logId);
//    }//main

}//class

