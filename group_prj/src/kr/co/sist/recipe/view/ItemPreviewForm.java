package kr.co.sist.recipe.view;

import java.awt.Component;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class ItemPreviewForm extends JDialog {
	
	private JTable jtIngrednt;
	private JTextArea jtaInfo;
	private JButton jbClose,jbSubmit;
	private JLabel jlRecipeName,jlIngrednt,jlScore,jlBookmark,jlMakeMethod,imgLabel;
	private ImageIcon imgIcon;
	private DefaultTableModel dtmIngrednt;
	private JScrollPane jspIngrednt;
	private JComboBox<Integer> jcScore;
	private JCheckBox jchBookmark;
	private JScrollPane jspTextArea;
	public ItemPreviewForm(){
	
		setLayout(null);
		
		//region ��ǰ��,���,����,�ϸ�ũ,����¹�,�̹��� �󺧹� �̹��� ������ ����
		Font defaultFont=new Font("����",Font.BOLD,15);
		jlRecipeName=new JLabel("��ǰ��");
		jlRecipeName.setBounds(170,50,100,40);
		
		jlIngrednt=new JLabel("���");
		jlIngrednt.setBounds(400,50,100,40);
		
		jlScore=new JLabel("����");
		jlScore.setBounds(400,300,100,40);
		
		jlBookmark=new JLabel("�ϸ�ũ��");
		jlBookmark.setBounds(640,300,100,40);
		
		jlMakeMethod=new JLabel("����¹�");
		jlMakeMethod.setBounds(370,400,100,40);
		
		imgIcon=new ImageIcon("C:/dev/workspace/group_prj/src/kr/co/sist/recipe/view/FI_0031.JPG");
		imgLabel=new JLabel(imgIcon);
		imgLabel.setBounds(30,100,330,270);
		//endregion //��ǰ��,���,����,�ϸ�ũ,����¹�,�̹��� �� ������
		
		//region ������̺� ����
		String[] columnNames={"����","����"};
		String[][] data={};
		dtmIngrednt=new DefaultTableModel(data, columnNames);
		jtIngrednt=new JTable(dtmIngrednt){
			private static final long serialVersionUID = 1L;
			//�÷��� ���� ���� ���� method Override
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}//isCellEditable
		};
		//�÷��� �����Ͽ� �������� ���ϵ��� ����
		jtIngrednt.getTableHeader().setReorderingAllowed(false);
		//�÷��� ���� ����
		jtIngrednt.setRowHeight(100);
		//�÷��� ���� ����
		//"��ȣ","�̹���","�޴��ڵ�","����","����"
		jtIngrednt.getColumnModel().getColumn(0).setPreferredWidth(140);
		jtIngrednt.getColumnModel().getColumn(1).setPreferredWidth(50);
		jspIngrednt=new JScrollPane(jtIngrednt);
		jspIngrednt.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jspIngrednt.setBounds(400,100,350,180);
		
		
		
		
		
		//endregion ������̺��� ��
		
		//region ���� �޺��ڽ� ����
		jcScore=new JComboBox<Integer>();
		jcScore.setBounds(440,310,100,30);
		//endregion ���� �޺��ڽ� ���� ��

		//region ���ƿ� üũ�ڽ� ����
		jchBookmark=new JCheckBox();
		jchBookmark.setBounds(705,300,300,40);
		//endregion ���ƿ� üũ�ڽ� ���� ��
		
		//region �ݱ�,���� ��ư ����
		jbSubmit=new JButton("����!");
		jbSubmit.setBounds(550,310,70,30);
		
		jbClose=new JButton("Ȯ��");
		jbClose.setBounds(650,610,100,40);
		//endregion �ݱ�,�����ư ���� ��
		
		//region ����¹� TextArea
		
		jtaInfo=new JTextArea();
		jtaInfo.setLineWrap(true);
		jspTextArea=new JScrollPane(jtaInfo);
		jspTextArea.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jspTextArea.setBounds(95,450,600,150);
		//endregion ����¹� TextArea��
		
		Component[] com={jlRecipeName,imgLabel,jlIngrednt,jspIngrednt,jlScore,jlBookmark,jcScore,jchBookmark
				,jbSubmit,jlMakeMethod,jspTextArea,jbClose};
		
		for(int i=0; i<com.length;i++){
			com[i].setFont(defaultFont);
			add(com[i]);
		}
		setVisible(true);
		setBounds(0,0,800,700);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ItemPreviewForm();
	}

}
