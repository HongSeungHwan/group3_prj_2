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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.recipe.dao.RecipeDAO;
import kr.co.sist.recipe.view.ItemPreviewForm;
import kr.co.sist.recipe.view.MainForm;
import kr.co.sist.recipe.vo.MainRecipeVO;
import kr.co.sist.recipe.vo.MenuTypeVO;

public class MainFormEvt implements MouseListener, ItemListener, ActionListener {
   private MainForm mainFrm;
   private RecipeDAO rcp_dao;
   private MenuTypeVO mtv;

   public MainFormEvt() {
   }

   public MainFormEvt(MainForm mainFrm) {
      this.mainFrm = mainFrm;
      rcp_dao = RecipeDAO.getInstance();
      
      newRecipe();
      
      mtv = new MenuTypeVO();
      
      mtv.setAnju("");
      mtv.setMeal("");
      mtv.setDessert("");
      mtv.setBunsik("");
      mainFrm.getJtfSearch().setText("");
      searchList();
   }// MainFormEvt

   // �ֱ� ��ϵ� ������ �̹��� ����
   public void newRecipe() {
      try {
         List<MainRecipeVO> imgList = rcp_dao.showNewRecipe();
         String path = "C:/dev/group_prj_git/group3_prj_2/group_prj/src/kr/co/sist/recipe/img/";

         // ����� ��¥���� 3������ �̹��� ���
         mainFrm.setImgPath1(path + imgList.get(0).getMenuImg());
         mainFrm.setImgPath2(path + imgList.get(1).getMenuImg());
         mainFrm.setImgPath3(path + imgList.get(2).getMenuImg());

      } catch (SQLException e) {
         e.printStackTrace();
      } // end catch

   }// newRecipe

   // ���õ� ������ �˻����� ��������
   public void searchCondition() {
      mtv = new MenuTypeVO();
       
      mtv.setAnju("");
      mtv.setMeal("");
      mtv.setDessert("");
      mtv.setBunsik("");

      // üũ�ڽ� �ɼ��� ���õɶ� vo�� �ش簪����
      if (mainFrm.getChkOne().isSelected()) {
         mtv.setAnju("���ַ�");
      } // end if
      if (mainFrm.getChkTwo().isSelected()) {
         mtv.setMeal("�Ļ��");
      } // end if
      if (mainFrm.getChkThree().isSelected()) {
         mtv.setDessert("����Ʈ");
      } // end if
      if (mainFrm.getChkFour().isSelected()) {
         mtv.setBunsik("�нķ�");
      } // end if

   }// searchCondition

   // �˻��������� ����Ʈ ��ȸ
   public void searchList() {

	   String searchText = mainFrm.getJtfSearch().getText();
	   String path = "C:/dev/group_prj_git/group3_prj_2/group_prj/src/kr/co/sist/recipe/img/";
      try {
         // �˻����� �޼ҵ� �����Ͽ� ������ �ɷ���
         searchCondition();
         List<MainRecipeVO> list = rcp_dao.selectAllRecipe(mtv, searchText);
         Object[] rowMenu = new Object[5];
         DefaultTableModel dtmMenu = mainFrm.getDtmRecipe();

         // �޴������� ����� VO��
         MainRecipeVO mrv = null;
         dtmMenu.setRowCount(0);

         for (int i = 0; i < list.size(); i++) {
            mrv = list.get(i);
            rowMenu[0] = mrv.getMenuName();
            rowMenu[1] = new ImageIcon(path+mrv.getMenuImg());
            rowMenu[2] = mrv.getMenuType();
            rowMenu[3] = mrv.getMenuSimpeInfo();
            rowMenu[4] = mrv.getMenuPrice();

            dtmMenu.addRow(rowMenu);
         } // end for

      } catch (SQLException e) {
         JOptionPane.showMessageDialog(mainFrm, "�˼��մϴ�. �޴��� �ҷ��� �� �����ϴ�.");
         e.printStackTrace();
      } // end catch

   }// searchList

   // ����������(������ ������)�� �̵� ��ư
   public void addRecipe() {
	   
   }// addRecipe

   // �ݱ�
   public void close() {

   }// close

   @Override
   public void actionPerformed(ActionEvent ae) {
      if (ae.getSource() == mainFrm.getJbSearch()) {
         searchList();
      }//end if //�˻���ư
      
      if(ae.getSource()== mainFrm.getJbFstImg() || 
    		  ae.getSource()==mainFrm.getJbSecImg() || 
    		  ae.getSource()==mainFrm.getJbTrdImg()){
    	  
    	  MainRecipeVO mrv = new MainRecipeVO();
    	  new ItemPreviewForm(mainFrm, mrv);
    	  
      }//end if
      
      if(ae.getSource() == mainFrm.getJbClose()){
    	  int selectNum = JOptionPane.showConfirmDialog(mainFrm, "â�� �����ðڽ��ϱ�?");
    	  switch (selectNum) {
		case JOptionPane.OK_OPTION:
			mainFrm.dispose();
		}//end switch
      }//end if //�ݱ��ư
      
      
      
   }// actionPerformed

   @Override
   public void mouseClicked(MouseEvent me) {
      if (me.getClickCount() == 2) {
    	  JTable jtTmp = mainFrm.getJtRecipe();
    	  int selecedRow = jtTmp.getSelectedRow();
    	  MainRecipeVO mrv = new MainRecipeVO();
    	  
    	  // Ŭ���� ���
    	  mrv.setMenuName((String)jtTmp.getValueAt(selecedRow, 0));
    	  mrv.setMenuImg(((ImageIcon)jtTmp.getValueAt(selecedRow, 1)).toString());
    	  mrv.setMenuType((String)jtTmp.getValueAt(selecedRow, 2));
    	  mrv.setMenuSimpeInfo((String)jtTmp.getValueAt(selecedRow, 3));
    	  mrv.setMenuPrice((String)jtTmp.getValueAt(selecedRow, 4));
//    	  sriv.setRecipeInfo(recipeInfo);
    	  /// �ڼ��� ������ ���� �����;���
    	  new ItemPreviewForm(mainFrm, mrv);
      }//end if
   }//

   @Override
   public void itemStateChanged(ItemEvent ie) {
      if (ie.getStateChange() == ItemEvent.SELECTED) {
         searchCondition();
      } // end if
   }// itemStateChanged

   @Override
   public void mousePressed(MouseEvent e) {
      // TODO Autogenerated method stub

   }

   @Override
   public void mouseReleased(MouseEvent e) {
      // TODO Autogenerated method stub

   }

   @Override
   public void mouseEntered(MouseEvent e) {
      // TODO Autogenerated method stub

   }

   @Override
   public void mouseExited(MouseEvent e) {
      // TODO Autogenerated method stub

   }

}// class