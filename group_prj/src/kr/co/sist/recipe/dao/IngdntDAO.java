package kr.co.sist.recipe.dao;

import java.util.List;

import kr.co.sist.recipe.vo.IngdntSchVO;
import kr.co.sist.recipe.vo.IngdntVO;
import kr.co.sist.recipe.vo.ShowIngdntVO;

public class IngdntDAO {
	
	private static IngdntDAO ing_dao;
	
	static IngdntDAO getInstance(){
		if(ing_dao==null){
			ing_dao = new IngdntDAO();
		}
		return ing_dao;
	}//getInstance
	
	// ������ �� �����ȸ
	 public List<ShowIngdntVO> selectIngdntOfRecp(IngdntVO ingVo){
		return null;
	 }//selectIngdntOfRecp
	 
	 // �����, ������ : ������ �߰� â���� ��ἱ���� �޴��� ��� ���̺� �߰�
	 public boolean insertIngdntOfRecp(IngdntVO ingVo){
		return false;
	 }//insertIngdntOfRecp
	 
	 // ������ : ������ �߰� â���� ��� ����
	 public boolean updateIngdntOfRecp(IngdntVO ingVo){
		return false;
	 }//updateIngdntOfRecp
	 
	 // ������ : ������ �߰� â���� ��� ����
	 public boolean deleteIngdntOfRecp(int ingdntCode){
		 return false;
	 }//updateIngdntOfRecp
	 
	 // ������ �߰� â���� ī�װ��� ��� ��ȸ
	 public List<ShowIngdntVO> selectIngdnt(IngdntSchVO ingSchVo){
		return null;
	 }//selectIngdnt
	  
}//class
