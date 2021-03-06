package kr.co.sist.recipe.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class AddRecipeForm extends JDialog {

	private JComboBox<String> jcbStore,jcbCateg,jcbIngrdntSort;
	private JTable jtIngrednt,jtaddedIngrednt;
	private JTextArea jtaInfo,jtaWriteRecipe;
	private JButton jbAddImg,jbAddIngrednt,jbRmvIngrednt,jbRequest,jbClose,jbSearch,jbMgr;
	private JTextField jtfRecipeName;
	private JLabel lblImg,lblRecipeName,lblRecipeSort,lblRecipeInfo,
	lblIngredntChoice,lblConvenienceStore,lblIngredntSort,lblTotalPrice,lblTotalPriceView
	,lblWriteRecipe;
	private JScrollPane jspIngrednt,jspAddedIngrednt,jspTextArea;
	private DefaultTableModel dtmIngrednt,dtmAddedIngrednt;
	private ImageIcon imgIcon;
	public AddRecipeForm(){
		setLayout(null);
		
//		region 레시피 이미지 추가하는 라벨 및 이미지 아이콘
		imgIcon=new ImageIcon("C:/dev/workspace/group_prj/src/kr/co/sist/recipe/view/FI_0031.JPG");
		lblImg = new JLabel(imgIcon);
		lblImg.setBounds(50,30,300,220);
		
//		endregion 레시피 이미지 추가하는 라벨 및 이미지 아이콘끝
		
//		region 레시피이미지 추가버튼
		jbAddImg=new JButton("사진 올리기");
		jbAddImg.setBounds(220,260,130,30);
//		endregion 레시피이미지 추가버튼 끝
		
//		region 상품명,요리분류,간단소개 라벨 추가 영역
		lblRecipeName = new JLabel("상품명");
		lblRecipeName.setBounds(432,30,40,30);
		lblRecipeSort=new JLabel("요리분류");
		lblRecipeSort.setBounds(420,70,60,30);
		lblRecipeInfo=new JLabel("간단소개");
		lblRecipeInfo.setBounds(420,110,60,30);
//		endregion 상품명,요리분류,간단소개 라벨 추가 영역끝
		
//		region 레시피명 입력하는 JTextField
		jtfRecipeName=new JTextField();
		jtfRecipeName.setBounds(492,35,100,20);
//		endregion 레시피명 입력하는 JTextField끝
		
//		region 레시피 요리분류 콤보박스 영역
		jcbCateg=new JComboBox<String>();
		jcbCateg.setBounds(492,75,100,20);
//		endregion 레시피 요리분류 콤보박스 영역끝
		
//		region 레시피 간단설명 텍스트에어리어
		jtaInfo = new JTextArea();
		jtaInfo.setBounds(492,115,200,130);
		jtaInfo.setLineWrap(true);
//		endregion 레시피 간단설명 텍스트에어리어끝
		
//		region 재료선택,편의점,재료분류 라벨 추가 영역
		Font ingredntChoice=new Font("맑은 고딕",Font.BOLD,15);
		lblIngredntChoice=new JLabel("재료선택");
		lblIngredntChoice.setFont(ingredntChoice);
		lblIngredntChoice.setBounds(50,290,100,30);
		lblConvenienceStore=new JLabel("편의점");
		lblConvenienceStore.setBounds(55,330,120,40);
		lblIngredntSort=new JLabel("재료분류");
		lblIngredntSort.setBounds(402, 330,120,40);
//		endregion 재료선택,편의점,재료분류 라벨 추가 영역 끝
		
//		region 편의점,재료분류 콤보박스 영역
		jcbStore=new JComboBox<String>();
		jcbStore.setBounds(110,330,120,30);
		jcbIngrdntSort=new JComboBox<String>();
		jcbIngrdntSort.setBounds(470,330,120,30);
//		endregion 편의점,재료분류 콤보박스 영역 끝
		
//		region 검색버튼
		jbSearch=new JButton("검색");
		jbSearch.setBounds(620,330,100,30);
//		endregion 검색버튼 끝
		
//		region 재료추가,추가된 재료 테이블 영역
	
		//재료추가 테이블 부분
		String[] columnNames1={"재료명","가격"};
		String[][] data1={};
		dtmIngrednt=new DefaultTableModel(data1, columnNames1);
		jtIngrednt=new JTable(dtmIngrednt){
			private static final long serialVersionUID = 1L;
			//컬럼의 수정 막기 위한 method Override
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}//isCellEditable
		};
		//컬럼을 선택하여 움직이지 못하도록 설정
		jtIngrednt.getTableHeader().setReorderingAllowed(false);
		//컬럼의 높이 설정
		jtIngrednt.setRowHeight(100);
		//컬럼의 넒이 설정
		//"번호","이미지","메뉴코드","설명","가격"
		jtIngrednt.getColumnModel().getColumn(0).setPreferredWidth(140);
		jtIngrednt.getColumnModel().getColumn(1).setPreferredWidth(50);
		jspIngrednt=new JScrollPane(jtIngrednt);
		jspIngrednt.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jspIngrednt.setBounds(20,380,580,80);
		//재료추가 테이블부분 끝
		
		//추가된 재료테이블
		
				String[] columnNames2={"재료명","가격"};
				String[][] data2={};
				dtmAddedIngrednt=new DefaultTableModel(data2, columnNames2);
				jtaddedIngrednt=new JTable(dtmAddedIngrednt){
					private static final long serialVersionUID = 1L;
					//컬럼의 수정 막기 위한 method Override
					@Override
					public boolean isCellEditable(int row, int column) {
						return false;
					}//isCellEditable
				};
				//컬럼을 선택하여 움직이지 못하도록 설정
				jtaddedIngrednt.getTableHeader().setReorderingAllowed(false);
				//컬럼의 높이 설정
				jtaddedIngrednt.setRowHeight(100);
				//컬럼의 넒이 설정
				//"번호","이미지","메뉴코드","설명","가격"
				jtaddedIngrednt.getColumnModel().getColumn(0).setPreferredWidth(140);
				jtaddedIngrednt.getColumnModel().getColumn(1).setPreferredWidth(50);
				jspAddedIngrednt=new JScrollPane(jtaddedIngrednt);
				jspAddedIngrednt.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				jspAddedIngrednt.setBounds(20,480,580,80);
		
				
		//추가된 재료테이블 끝
		
//		endregion 재료추가,추가된 재료 테이블 영역 끝
		
//		region 재료의 삭제 및 추가 버튼
		jbAddIngrednt=new JButton("Add");
		jbAddIngrednt.setBounds(620, 390,100,55);
		jbRmvIngrednt=new JButton("Delete");
		jbRmvIngrednt.setBounds(620,490,100,55);
//		endregion 재료의 삭제 및 추가 버튼 끝
		
//		region 재료의 총가격 라벨과 실제로 값을 보여줄 라벨
		Font priceResult=new Font("맑은 고딕",Font.BOLD,15);
		
		lblTotalPrice=new JLabel("7000원");
		lblTotalPrice.setFont(priceResult);
		lblTotalPrice.setForeground(Color.red);
		lblTotalPrice.setBounds(540,555,100,50);
		lblTotalPriceView=new JLabel("총가격:");
		lblTotalPriceView.setFont(priceResult);
		lblTotalPriceView.setBounds(460,555,100,50);
//		endregion 재료의 총가격 라벨과 실제로 값을 보여줄 라벨 끝
		
//		region 레시피 작성 라벨
		Font design=new Font("맑은 고딕",Font.BOLD,15);
		lblWriteRecipe=new JLabel("레시피 작성");
		lblWriteRecipe.setBounds(310, 585,150,40);
		lblWriteRecipe.setFont(design);
//		endregion 레시피 작성 라벨 끝
		
//		region 레피시 작성 TextArea
		
		jtaWriteRecipe=new JTextArea(5,10);
		jtaWriteRecipe.setLineWrap(true);
		jtaWriteRecipe.setBackground(Color.WHITE);
		jspTextArea=new JScrollPane(jtaWriteRecipe);
		jspTextArea.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jspTextArea.setBounds(15, 630,700,100);
//		endregion 레피시 작성 TextArea 끝
		
//		region 요청,닫기,관리자 버튼 구역
		jbClose=new JButton("Close");
		jbClose.setBounds(615, 750,100,40);
		jbRequest=new JButton("Request");
		jbRequest.setBounds(495,750,100,40);
		jbMgr=new JButton("MGR Modify");
		jbMgr.setBounds(15,750,100,40);
//		endregion 요청,닫기,관리자 버튼 구역 끝
		
		Component[] com={jtaInfo,jcbCateg,jtfRecipeName,lblRecipeInfo,lblRecipeSort,lblRecipeName
				,lblImg,jbAddImg,lblTotalPriceView,lblTotalPrice,jbRmvIngrednt,jbAddIngrednt
				,jspAddedIngrednt,jspIngrednt,jbSearch,jcbStore,lblConvenienceStore,lblIngredntChoice
				,lblIngredntSort,jcbIngrdntSort,jbRequest,jbClose,jspTextArea,lblWriteRecipe,jbMgr};
		
		for(int i=0; i<com.length;i++){
			add(com[i]);
		}
		setBounds(0,0,750,850);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public static void main(String[] args){
		new AddRecipeForm();
	}
}
