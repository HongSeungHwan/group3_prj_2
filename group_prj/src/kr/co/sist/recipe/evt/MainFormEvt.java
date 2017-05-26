package kr.co.sist.recipe.evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.recipe.dao.RecipeDAO;
import kr.co.sist.recipe.view.MainForm;
import kr.co.sist.recipe.vo.MainRecipeVO;
import kr.co.sist.recipe.vo.MenuTypeVO;
import kr.co.sist.recipe.vo.ShowRecipeVO;

public class MainFormEvt implements MouseListener, ItemListener,ActionListener {
	private MainForm mainFrm;
	private RecipeDAO rcp_dao;
	private MenuTypeVO mtv;
	
	public MainFormEvt(MainForm mainFrm) {
		this.mainFrm=mainFrm;
		rcp_dao= RecipeDAO.getInstance();
		
		newRecipe();
	}//MainFormEvt

	// �ֱ� ��ϵ� ������ �̹��� ����
	public void newRecipe(){
		try {
			List<ShowRecipeVO> imgList = rcp_dao.showNewRecipe();
			String path = "C:/dev/group_prj_git/group3_prj_2/group_prj/src/kr/co/sist/recipe/img/";
			
			// ����� ��¥���� 3������ �̹��� ���
				mainFrm.setImgPath1(path+imgList.get(0).getMenuImg());
				mainFrm.setImgPath2(path+imgList.get(1).getMenuImg());
				mainFrm.setImgPath3(path+imgList.get(2).getMenuImg());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//end catch
	}//newRecipe

	// ���õ� ������ �˻����� �������� 
	public void searchCondition(){
		mtv = new MenuTypeVO();
		mtv.setAnju("");
		mtv.setMeal("");
		mtv.setDessert("");
		mtv.setBunsik("");
		
		//üũ�ڽ� �ɼ��� ���õɶ� vo�� �ش簪����
		if(mainFrm.getChkOne().isSelected()){
			mtv.setAnju("���ַ�");
		}//end if
		if(mainFrm.getChkTwo().isSelected()){
			mtv.setMeal("�Ļ��");
		}//end if
		if(mainFrm.getChkThree().isSelected()){
			mtv.setDessert("����Ʈ");
		}//end if
		if(mainFrm.getChkFour().isSelected()){
			mtv.setBunsik("�нķ�");
		}//end if
		
	}//searchCondition

	// �˻��������� ����Ʈ ��ȸ
	public void searchList(){
		
		try {
			// �˻����� �޼ҵ� �����Ͽ� ������ �ɷ���
			searchCondition();
			List<MainRecipeVO> list = rcp_dao.selectAllRecipe(mtv,"����");
			Object[] rowMenu = new Object[5];
			DefaultTableModel dtmMenu = mainFrm.getDtmRecipe();
			
			// �޴������� ����� VO��
			MainRecipeVO mrv = null;
			dtmMenu.setRowCount(0);
			
			for(int i=0; i<list.size(); i++){
				mrv = list.get(i);
				rowMenu[0]=mrv.getMenuName();
				rowMenu[1]=mrv.getMenuImg();
				rowMenu[2]=mrv.getMenuType();
				rowMenu[3]=mrv.getMenuInfo();
				rowMenu[4]=mrv.getMenuPrice();
				
				dtmMenu.addRow(rowMenu);
			}//end for
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(mainFrm, "�˼��մϴ�. �޴��� �ҷ��� �� �����ϴ�.");
			e.printStackTrace();
		}//end catch
		
	}//searchList
	
	// ����������(������ ������)�� �̵� ��ư
	public void goMypage(){
		
	}//goMypage
	
	// ������ ������(����������)�� �̵� ��ư
	public void goMgrpage(){
		
	}//goMgrpage
	
	// �޴� �߰� ��ư
	public void addRecipe(){
		
	}//addRecipe
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==mainFrm.getJbSearch()){
			searchList();
		}
	}//actionPerformed

	@Override
	public void mouseClicked(MouseEvent me) {
		if(me.getClickCount()==2){
			
		}
	}

	@Override
	public void itemStateChanged(ItemEvent ie) {
		if(ie.getStateChange()==ItemEvent.SELECTED){
			searchCondition();
		}//end if
	}//itemStateChanged

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}//class
