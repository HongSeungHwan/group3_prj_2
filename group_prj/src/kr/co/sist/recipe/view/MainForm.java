package kr.co.sist.recipe.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class MainForm extends JFrame{

	JButton jbSearch, jbFstImg, jbSecImg, jbTrdImg, jbMypage, jbClose, jbAddRecipe;
	JTable jtRecipe;
	DefaultTableModel dtmRecipe;
	JCheckBox chkOne, chkTwo, chkThree, chkFour;
	JTextField jtfSearch;	
	
	public MainForm() {
		super("ȫȫȫ�� ������ ������");
		setLayout(null);
		
		JLabel jlImg = new JLabel(new ImageIcon("C:/dev/workspace/group_prj/src/kr/co/sist/recipe/img/background_image.png"));
		setContentPane(jlImg);
		// ��ϵ� ������ �̹���
		JLabel jlRecent = new JLabel("�ֱ� ������");
		jlRecent.setFont(new Font("", Font.BOLD, 15));
		
		JPanel jpRcntRecipe = new JPanel();
		jpRcntRecipe.setBackground(new Color(255, 255, 255, 130));
		jbFstImg = new JButton("�޴��̸�",new ImageIcon("C:/dev/workspace/group_prj/src/kr/co/sist/recipe/img/m1_l4.gif"));
		jbSecImg = new JButton("�޴��̸�");
		jbTrdImg = new JButton("�޴��̸�");
		
		// �˻�����
		JLabel jlSearch = new JLabel("�˻� ����");
		jlSearch.setFont(new Font("�������", Font.BOLD, 15));
		
		JPanel jpSrchOption = new JPanel(){
		    protected void paintComponent(Graphics g)
		    {
		        g.setColor( getBackground() );
		        g.fillRect(0, 0, getWidth(), getHeight());
		        super.paintComponent(g);
		    }
		};
		jpSrchOption.setOpaque(false);
		jpSrchOption.setBackground(new Color(255, 255, 255, 130));
		chkOne = new JCheckBox("ù��°");
		chkTwo = new JCheckBox("�ι�°");
		chkThree = new JCheckBox("����°");
		chkFour = new JCheckBox("�׹�°");
		jtfSearch = new JTextField();
		jbSearch = new JButton("�� ��");
		chkOne.setOpaque(false);
		chkTwo.setOpaque(false);
		chkThree.setOpaque(false);
		chkFour.setOpaque(false);
		
		// �Ʒ� ������ �߰���ư, ������������ư, �ݱ� ��ư
		JPanel jpFootBtns = new JPanel();
		jbAddRecipe = new JButton("�޴� ��û");
		jbMypage = new JButton("����������");
		jbClose = new JButton("�ݱ�");
		
		// �̹��� ��ư ��ġ
		jpRcntRecipe.setLayout(null);
		jlRecent.setBounds(10, 10, 200, 30);
		jbFstImg.setBounds(10, 50, 260, 200);
		jbSecImg.setBounds(285, 50, 260, 200);
		jbTrdImg.setBounds(560, 50, 260, 200);
		
		
		// �˻� ����(üũ�ڽ�) , �˻� ��ư ��ġ
		jpSrchOption.setLayout(null);
//		jpSrchOption.setOpaque(false);
		jlSearch.setBounds(10, 10, 100, 30);
		chkOne.setBounds(110, 10, 70, 30);
		chkOne.setBackground(new Color(255, 0, 0, 0));
		chkTwo.setBounds(180, 10, 70, 30);
		chkThree.setBounds(260, 10, 70, 30);
		chkFour.setBounds(340, 10, 70, 30);
		jtfSearch.setBounds(420, 13, 280, 25);
		jbSearch.setBounds(720, 11, 100, 28);
		
		// �ϴܹ�ư > ������ �߰���ư, ������������ư, �ݱ� ��ư ��ġ
		jpFootBtns.setLayout(null);
		jpFootBtns.setOpaque(false);
		jbAddRecipe.setBounds(0, 10, 100, 30);
		jbMypage.setBounds(620, 10, 100, 30);
		jbClose.setBounds(730, 10, 100, 30);
		
		// ���̺�
		String[] columnName = {"�̹���", "�޴��̸�", "�Ѱ���", "�Ұ�"};
		String[][] rowData = {{"jpg","�򳪸��ָ�","4000","���־�"}};
		// ���̺� ���� ����
		dtmRecipe = new DefaultTableModel(rowData, columnName){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		jtRecipe = new JTable(dtmRecipe);
		jtRecipe.getTableHeader().setReorderingAllowed(false);
		JScrollPane jspTab = new JScrollPane(jtRecipe);
		
		// �ֱ� �޴� �г� ��ġ
		jpRcntRecipe.setBounds(20, 130, 830, 260);
		// �˻����� �г� ��ġ
		jpSrchOption.setBounds(20, 400, 830, 50);
		// ���̺� ��ġ
		jspTab.setBounds(20, 450, 830, 200);
		// �ϴ� ��ư�г� ��ġ
		jpFootBtns.setBounds(20, 660, 830, 50);
		
		// �ֱٸ޴� �̹��� ��ư ���̱�
		jpRcntRecipe.add(jlRecent);
		jpRcntRecipe.add(jbFstImg);
		jpRcntRecipe.add(jbSecImg);
		jpRcntRecipe.add(jbTrdImg);
		
		// �˻�����, �˻���ư ���̱�
		jpSrchOption.add(jlSearch);
		jpSrchOption.add(chkOne);
		jpSrchOption.add(chkTwo);
		jpSrchOption.add(chkThree);
		jpSrchOption.add(chkFour);
		jpSrchOption.add(jtfSearch);
		jpSrchOption.add(jbSearch);
		
		// ��ư ���̱�
		jpFootBtns.add(jbAddRecipe);
		jpFootBtns.add(jbMypage);
		jpFootBtns.add(jbClose);
		
		// �г� ���̱�
		add(jpSrchOption);
		add(jpRcntRecipe);
		add(jspTab);
		add(jpFootBtns);
		
		
		setBounds(10, 10, 880, 770);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//MainForm
	
	public static void main(String[] args) {
		new MainForm();
	}//main

}//class
