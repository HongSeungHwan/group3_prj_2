package kr.co.sist.recipe.dao;

import java.util.List;

import kr.co.sist.recipe.vo.AddRecipeVO;
import kr.co.sist.recipe.vo.MainRecipeVO;
import kr.co.sist.recipe.vo.RecipeVO;
import kr.co.sist.recipe.vo.ShowRecipeVO;

public class RecipeDAO {

	private static MemberDAO mem_dao;
	
	static MemberDAO getInstance(){
		if(mem_dao==null){
			mem_dao = new MemberDAO();
		}//end if
		return mem_dao;
	}//getInstance
	
	// ������ ��ü ��ȸ + ������ȸ
	public RecipeVO selectOneRecipe(String menuCode){
		return null;
	}//selectOneRecipe
	
	// ������ - ��ü������ ��ȸ
	public List<MainRecipeVO> ShowAllRecipe(){
		return null;
	}//ShowAllRecipe
	
	// ������ - �ֽŸ޴�
	public List<ShowRecipeVO> showNewRecipe(){
		return null;
	}//showNewRecipe

	// �������� - ��緹����, ��û������ ��ȸ
	public List<MainRecipeVO> recipeList(String flag){
		return null;
	}//recipeList
	
	// ������ - �����޴� ����
	public boolean deleteRecipe(String menuName){
		return false;
	}//deleteRecipe
	
	// ȸ�� - ������ ���ο�û
	public boolean insertRecipe(AddRecipeVO addVo){
		return false;
	}//insertRecipe
	
	// ������ - �����޴�����
	public boolean updateRecipe(AddRecipeVO addVo){
		return false;
	}//updateRecipe
	
	// ������ - �����ǿ�û ����
	public boolean confirmRecipe(String menuCode){
		return false;
	}//confirmRecipe
	
	
}//class
