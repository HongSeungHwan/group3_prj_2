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

import kr.co.sist.recipe.vo.AddRecipeVO;
import kr.co.sist.recipe.vo.IngredientOfRecipeVO;
import kr.co.sist.recipe.vo.MainRecipeVO;
import kr.co.sist.recipe.vo.MenuTypeVO;
import kr.co.sist.recipe.vo.MgrRcpInfoListVO;
import kr.co.sist.recipe.vo.SelectRecipeInfoVO;
import kr.co.sist.recipe.vo.ShowRecipeVO;

public class RecipeDAO {

	private static RecipeDAO rcp_dao;
	
	static RecipeDAO getInstance(){
		if(rcp_dao==null){
			rcp_dao = new RecipeDAO();
		}//end if
		return rcp_dao; 
	}//getInstance
	 
	private Connection getConnection() throws SQLException{
		Connection con=null;
		
		Properties prop = new Properties();
		try {
			File file = new File("C:/dev/group_prj_git/group3_prj_2/group_prj/src/kr/co/sist/recipe/dao/recipe_db.properties");
			if(file.exists()){
				prop.load(new FileInputStream(file));
				String driver= prop.getProperty("driver");
				String url= prop.getProperty("url");
				String id= prop.getProperty("dboid");
				String pass= prop.getProperty("dbopwd");
				
				// ����̹� ����
				try {
					Class.forName(driver);
					con= DriverManager.getConnection(url,id,pass);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}//end catch
				
			}else{
				JOptionPane.showMessageDialog(null, "���������� ��ΰ� �߸��Ǿ����ϴ�.");
			}//end else
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
		
		return con;
	}//getConnection
	
	/**
	 * ������, ��������, ���������� �� -  �ϳ��� ������ ���� ��ȸ
	 * @param menuCode
	 * @return
	 */
	public SelectRecipeInfoVO selectOneRecipe(String menuName) throws SQLException{
		SelectRecipeInfoVO srv = new SelectRecipeInfoVO();
		Connection con = null;
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		
		try {
			con= getConnection();
			
			String SelectRecipeInfoVO=
					"select menu_name, img, totalprice, food_type, info, recipe_info from reciperegister reg where menu_name=?";
			
			pstmt = con.prepareStatement(SelectRecipeInfoVO);
			pstmt.setString(1, menuName);
			rs = pstmt.executeQuery();
			
			// ���õ� �Ѱ��� �޴������� ������ RecipeVO�� ����
			while(rs.next()){
				srv.setMenuName(menuName);
				srv.setMenuImg(rs.getString("img"));
				srv.setMenuPrice(rs.getString("totalprice"));
				srv.setMenuType(rs.getString("food_type"));
				srv.setMenuSimpleInfo(rs.getString("info"));
				srv.setRecipeInfo(rs.getString("recipe_info"));
			}//end while
			
		}finally {
			if(rs!= null){ rs.close(); }
			if(pstmt!= null){ pstmt.close(); }
			if(con!= null){ con.close(); }
		}//end finally
		
		return srv;
		
	}//selectOneRecipe
	
	// ������ - ��ü������ ��ȸ
	/**
	 * ������ - ��ü������ ���� ��ȸ
	 * �޼ҵ�� showAllRecipe > selectAllRecipe�� ����
	 * @return
	 * @throws SQLException 
	 */
	public List<MainRecipeVO> selectAllRecipe(MenuTypeVO mtv) throws SQLException{
		List<MainRecipeVO> recpList = new ArrayList<MainRecipeVO>();
		Connection con=null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		
		try{ 
			con= getConnection();
			
			// �˻�����(�Ļ��, ���ַ�, ����Ʈ, �н�)�� ������� ������ �˻��������� �˻�
			// �˻������� ��������� ��ü �˻�
			StringBuilder sbSelectRecipe = new StringBuilder();
			sbSelectRecipe.append("select menu_name, img, food_type, info, totalprice from reciperegister");
			
			if(mtv.getAnju().equals("") && mtv.getBunsik().equals("") && mtv.getDessert().equals("") && mtv.getMeal().equals("")){
				System.out.println("��ü�� �������");
				pstmt= con.prepareStatement(sbSelectRecipe.toString());
				rs=pstmt.executeQuery();
			}else{
				System.out.println("��ü�� ����");
				sbSelectRecipe.append(" where food_type in(?,?,?,?)");
				pstmt= con.prepareStatement(sbSelectRecipe.toString());
				
				// ������ ���� ��
				pstmt.setString(1, mtv.getAnju());
				pstmt.setString(2, mtv.getMeal());
				pstmt.setString(3, mtv.getDessert());
				pstmt.setString(4, mtv.getBunsik()); 
				
				rs=pstmt.executeQuery();
			}//end else
			
			
			MainRecipeVO mrv = null;
			while(rs.next()){
				mrv = new MainRecipeVO();
				mrv.setMenuName(rs.getString("menu_name"));
				mrv.setMenuImg(rs.getString("img"));
				mrv.setMenuType(rs.getString("food_type"));
				mrv.setMenuInfo(rs.getString("info"));
				mrv.setMenuPrice(rs.getString("totalprice"));
				
				recpList.add(mrv);
			}//end while
			
		}finally {
			if(rs!= null){ rs.close(); }
			if(pstmt!= null){ pstmt.close(); }
			if(con!= null){ con.close(); }
		}//end finally
		
		return recpList;
	}//ShowAllRecipe
	
	// ������ - �ֽŸ޴�
	public List<ShowRecipeVO> showNewRecipe(){
		return null;
	}//showNewRecipe

	// �������� - ��緹����, ��û������ ����Ʈ �Ѹ���
	public List<MainRecipeVO> recipeList(String flag) throws SQLException{
		List<MainRecipeVO> list = new ArrayList<MainRecipeVO>();
		Connection con=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			con = getConnection();
			
			
			pstmt = con.prepareStatement(null);
			
		}finally{
			if(rs!= null){ rs.close(); }
			if(pstmt!= null){ pstmt.close(); }
			if(con!= null){ con.close(); }
		}
		
		return list;
	}//recipeList
	
	// ������ - �����޴� ����
	public boolean deleteRecipe(String menuName){
		return false;
	}//deleteRecipe
	
	/**
	 * ȸ�� - ������ ���ο�û
	 * �޼ҵ�� insertRecipe > requestRecipe���� ����
	 * @param addVo(AddRecipeVO) : String menuName, menuImg, menuInfo, menuType, id
	 * 						  					 Date inputDate
	 * @return
	 */
	public boolean requestRecipe(AddRecipeVO addVo){
		return false;
	}//insertRecipe
	
	// ������ - �����޴�����
	public boolean updateRecipe(AddRecipeVO addVo){
		return false;
	}//updateRecipe
	
	// ������ - �����ǿ�û ����
	public boolean insertRecipe(String menuCode){
		return false;
	}//confirmRecipe
	
	public static void main(String[] args){
		RecipeDAO md= RecipeDAO.getInstance();
		
		try {
//				List<MainRecipeVO> list;
//				list = md.selectAllRecipe(new MenuTypeVO("","","",""));
//				for(MainRecipeVO tmp : list){
//					System.out.println(tmp.toString());
//				}//end for
//============================================================
			SelectRecipeInfoVO srv = new SelectRecipeInfoVO();
			srv=md.selectOneRecipe("��ȭ��");
			
			System.out.println(srv.getMenuName()+"\n"+srv.getMenuImg()+"\n"+
					srv.getMenuPrice()+"\n"+srv.getMenuType()+"\n"+srv.getMenuSimpleInfo()+"\n"+
					srv.getRecipeInfo());
//============================================================
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//main

}//class
