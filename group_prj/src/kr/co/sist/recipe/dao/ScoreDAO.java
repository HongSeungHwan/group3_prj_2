package kr.co.sist.recipe.dao;

import kr.co.sist.recipe.vo.ScoreVO;

public class ScoreDAO {

	private static ScoreDAO score_dao;
	
	static ScoreDAO getInstance(){
		if(score_dao==null){
			score_dao = new ScoreDAO();
		}
		return score_dao;
	}//getInstance
	
	// ��ǰ���� �˾� - �����ֱ�
	public boolean insertScore(ScoreVO scoreVo){
		return false;
	}//insertScore
	
	// ��ǰ���� �˾� - ���� ����
	public boolean updateScore(ScoreVO scoreVo){
		return false;
	}//updateScore
	
	// ������ - ��ü�������
	// ����� ���� ������ �������� ���̱� ���ؼ��� RecipeDAO��ü��ȸ �޼ҵ�
	// ���� ���������̺�� �������̺��� gourpby(avg)�������� �����ϴ� �����ʿ�
	// ���̺� ������X ���� �ٷ� �������� ����
	public double getAvg(String menuName){
		return 0;
	}//getAvg
	
}//class
