package kr.co.sist.recipe.view;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.recipe.evt.MyPageEvt;

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
        jpMyMenu.add(jbRmvFavorMenu);

        //�̺�Ʈ
        MyPageEvt mpe = new MyPageEvt(this);
        jbRmvFavorMenu.addActionListener(mpe);
        jbEditMyInfo.addActionListener(mpe);
        jbClose.addActionListener(mpe);

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



    ///////////////////////////////////////////////���� �������////////////////////////////////////
    public static void main(String[] args) {
        new MyPageForm();
    }//main

}//class

