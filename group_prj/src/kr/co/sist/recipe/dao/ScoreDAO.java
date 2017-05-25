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
	
	
//////////////////////////////////////////////////// ��ǰ���� �˾� - �����ֱ�///////////////////////////////////////////////////////////////
	public boolean insertScore(ScoreVO sv) throws SQLException{
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
			
			pstmt.setString(1, sv.getId());
			pstmt.setString(2, sv.getMenuName());
			pstmt.setInt(3, sv.getValue());
			
			pstmt.executeUpdate();
			result=true;
			
		}finally {
			//5.
			if(pstmt!=null){ pstmt.close(); }
			if(con!=null){ con.close(); }
		}//end finally
		
		
		return result;
		
	}//insertScore
//////////////////////////////////////////////////// ��ǰ���� �˾� - �����ֱ�///////////////////////////////////////////////////////////////
	
	
//////////////////////////////////////////////////// ��ǰ���� �˾� - ���� ����///////////////////////////////////////////////////////////////
	public boolean updateScore(ScoreVO sv) throws SQLException{
		boolean result=false;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			//1. ����̹��ε�
			//2. Ŀ�ؼ� ���
			con = getConnection();
			//3. ������ ������ü ���
			String updatePoint = "update score set value = ? where id =? and menu_name = ?";
			pstmt = con.prepareStatement(updatePoint);
			//4. �������� �� ������
				// ���ε庯���� �� ����
			pstmt.setInt(1, sv.getValue());
			pstmt.setString(2, sv.getId());
			pstmt.setString(3, sv.getMenuName());
			
			pstmt.executeUpdate();
			result=true;
			
		}finally {
			//5.
			if(pstmt!=null){ pstmt.close(); }
			if(con!=null){ con.close(); }
		}//end finally
		System.out.println();
		
		return result;
		
	}//updateScore
//////////////////////////////////////////////////// ��ǰ���� �˾� - ���� ����///////////////////////////////////////////////////////////////
	
////////////////////�����׽�Ʈ///////////////////////////////////////////	
	public static void main(String[] args){
		String id="duck";
		String menu_name="���� ġ�� �Ķ���";
		int value=4;
		
		ScoreDAO sd = new ScoreDAO();
		ScoreVO sv = new ScoreVO();
		
		sv.setId(id);
		sv.setMenuName(menu_name);
		sv.setValue(value);
		
		try {
			System.out.println(sd.insertScore(sv));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
////////////////////�����׽�Ʈ///////////////////////////////////////////	
	
	
	
	
	// ������ - ��ü�������
	// ����� ���� ������ �������� ���̱� ���ؼ��� RecipeDAO��ü��ȸ �޼ҵ�
	// ���� ���������̺�� �������̺��� gourpby(avg)�������� �����ϴ� �����ʿ�
	// ���̺� ������X ���� �ٷ� �������� ����
	public double getAvg(String menuName){
		return 0;
	}//getAvg
	
}//class
