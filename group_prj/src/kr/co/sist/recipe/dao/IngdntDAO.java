package kr.co.sist.recipe.dao;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.JOptionPane;

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
	
	//*********************getConnection()�߰�(���� ������)*********************************
	private Connection getConnection() throws SQLException {
		Connection con = null;

		Properties prop = new Properties();
		try {
			File file = new File("C:/dev/group3_prj_2/group3_prj_2/group_prj/src/kr/co/sist/recipe/dao/recipe_db.properties");
			
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

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} // end catch

		return con;
	}// getConnection
	//
	
	// ������ �� �����ȸ
	 /**
	*��������*
	-���� ��ȹ ����:selectIngdntOfRecp()�� �Ű������� ingredntOfRecipeVO���� ��ü�� �Ű������� �޾���.
	-���� ����:selectIngdntOfRecp(String recipeName)�� ���� String���� �����Ǹ��� �޵��� �ص�				
	�� �κ��� Ư�� �����ǿ� ���� ���� ������ ��ȸ�ϱ� ������ VO�� ���� �ʰ� ������ Name�� �޵��� �� ���� �ٽ�
	
	 */
	public List<ShowIngdntVO> selectIngdntOfRecp(String recipeName)throws SQLException{
		 
		 List<ShowIngdntVO> list = new ArrayList<ShowIngdntVO>();

			Connection con = null; 
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				con = getConnection();
				String selectIngrdnt ="select ri.INGREDIENT_NAME,i.PRICE "
						+ "from INGREDIENTS i,RECIPE_INGREDIENTS ri "
						+ "where(ri.INGREDIENT_NAME=i.INGREDIENT_NAME) "
						+ "and ri.MENU_NAME='"+recipeName+"'"; 
				pstmt = con.prepareStatement(selectIngrdnt);
				rs = pstmt.executeQuery();
				
				ShowIngdntVO siv= null;
				while (rs.next()) {
					siv =new ShowIngdntVO();
					siv.setIngrdntName(rs.getString("ingredient_name"));
					siv.setIngrdntPrice(rs.getString("price"));
					
					list.add(siv);
				} // end while

			} finally {
				// 5.
				if (rs != null) {
					rs.close();
				} // end if

				if (pstmt != null) {
					pstmt.close();
				} // end if

				if (con != null) {
					con.close();
				} // end if
			}

			return list;
		 
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
	 public static void main(String[] args){
		 try {
			 IngdntVO iv= new IngdntVO();
			 
			System.out.println(IngdntDAO.getInstance().selectIngdntOfRecp("����¦��").toString());
			JOptionPane.showMessageDialog(null, "��");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
	 }
}//class
