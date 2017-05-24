package kr.co.sist.recipe.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JOptionPane;

import kr.co.sist.recipe.vo.ScoreVO;

public class ScoreDAO {

	private static ScoreDAO score_dao;
	
	static ScoreDAO getInstance(){
		if(score_dao==null){
			score_dao = new ScoreDAO();
		}
		return score_dao;
	}//getInstance
	
	private Connection getConnection() throws SQLException {
	      Connection con = null;
	      //�������� ���� ���� �Ͽ���!!!!!!! merge �Ͽ���
	      Properties prop = new Properties();
	      try {
	         File file = new File("C:/dev/workspace/group_prj2/src/kr/co/sist/recipe/dao/recipe_db.properties");
	         
	         if (file.exists()) {
	            prop.load(new FileInputStream(file));
	            String driver = prop.getProperty("driver");
	            String url = prop.getProperty("url");
	            String id = prop.getProperty("dboid");
	            String pass = prop.getProperty("dbopwd");
	            System.out.println(driver);

	            try {
	               Class.forName(driver);
	               con = DriverManager.getConnection(url, id, pass);
	            } catch (ClassNotFoundException e) {
	               e.printStackTrace();
	            } // end catch

	         } else {
	            JOptionPane.showMessageDialog(null, "���������� ��θ� Ȯ�����ּ���");
	         } // end else

	      } catch (FileNotFoundException fe) {
	         fe.printStackTrace();
	      } catch (IOException ie) {
	         ie.printStackTrace();
	      } // end catch

	      return con;
	   }// getConnection
	
	
	///////////////////// ��ǰ���� �˾� - �����ֱ�/////////////////////
	public boolean insertScore(String id, String menu_name, int value) throws SQLException{
		boolean result=false;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			//1. ����̹��ε�
			//2. Ŀ�ؼ� ���
			con = getConnection();
			//3. ������ ������ü ���
			String insertPoint = "insert into score(id,menu_name,value) values(?,?,?)";
			pstmt = con.prepareStatement(insertPoint);
			//4. �������� �� ������
				// ���ε庯���� �� ����
			
			pstmt.setString(1, id);
			pstmt.setString(2, menu_name);
			pstmt.setInt(3, value);
			
			pstmt.executeUpdate();
			result=true;
			
		}finally {
			//5.
			if(pstmt!=null){ pstmt.close(); }
			if(con!=null){ con.close(); }
		}//end finally
		
		
		if(result){
			System.out.println("�߰��Ǿ���");
		}else{
			System.out.println("�߰� �ȵǾ���");
			
		}
		return result;
		
	}//insertScore
	
////////////////////�����׽�Ʈ///////////////////////////////////////////	
	public static void main(String[] args){
		String id="duck";
		String menu_name="���� ġ�� �Ķ���";
		int value=3;
		
		ScoreDAO sd = new ScoreDAO();
		
		try {
			sd.insertScore(id, menu_name, value);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
////////////////////�����׽�Ʈ///////////////////////////////////////////	
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
