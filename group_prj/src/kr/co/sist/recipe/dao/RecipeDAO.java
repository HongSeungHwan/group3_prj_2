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
import kr.co.sist.recipe.vo.MainRecipeVO;
import kr.co.sist.recipe.vo.MenuTypeVO;
import kr.co.sist.recipe.vo.RecipeVO;
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
				
				// 드라이버 연동
				try {
					Class.forName(driver);
					con= DriverManager.getConnection(url,id,pass);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}//end catch
				
			}else{
				JOptionPane.showMessageDialog(null, "설정파일의 경로가 잘못되었습니다.");
			}//end else
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
		
		return con;
	}//getConnection
	
	/**
	 * 하나의 레시피 정보 조회
	 * @param menuCode
	 * @return
	 */
	public RecipeVO selectOneRecipe(String menuName) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt= null;
		
		try {
			con= getConnection();
		}finally {
			if(pstmt!= null){ pstmt.close(); }
			if(con!= null){ con.close(); }
		}//end finally
		
		String selectOneRecipe=
				"select reg.menu_name, reg.totalprice, reg.food_type, ing.ingredient_name ingrdnts, reg.recipe_flag from reciperegister reg, RECIPE_INGREDIENTS ing where ing.menu_name=reg.menu_name and reg.menu_name='공화뽕' ";
		// 쿼리 보류 - 북마크, 별점도 추가해야함
		
		return null;
	}//selectOneRecipe
	
	// 메인폼 - 전체레시피 조회
	/**
	 * 전체레시피 정보 조회
	 * 메소드명 showAllRecipe > selectAllRecipe로 변경
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
			
			// 검색조건(식사류, 안주류, 디저트, 분식)이 비어있지 않으면 검색조건으로 검색
			// 검색조건이 비어있으면 전체 검색
			StringBuilder sbSelectRecipe = new StringBuilder();
			sbSelectRecipe.append("select menu_name, img, food_type, info, totalprice from reciperegister");
//			if(mtv==null){
//				System.out.println("객체가 있음");
//				sbSelectRecipe.append(" where food_type in(?,?,?,?)");
//				pstmt= con.prepareStatement(sbSelectRecipe.toString());
//				
//				// 조건이 있을 때
//				pstmt.setString(1, mtv.getAnju());
//				pstmt.setString(2, mtv.getMeal());
//				pstmt.setString(3, mtv.getDessert());
//				pstmt.setString(4, mtv.getBunsik());
//				
//				rs=pstmt.executeQuery();
//			}else{
//				System.out.println("객체가 비어있음");
//				pstmt= con.prepareStatement(sbSelectRecipe.toString());
//				rs=pstmt.executeQuery();
//			}//end else
			
			if(mtv.getAnju().equals("") && mtv.getBunsik().equals("") && mtv.getDessert().equals("") && mtv.getMeal().equals("")){
				System.out.println("객체가 비어있음");
				pstmt= con.prepareStatement(sbSelectRecipe.toString());
				rs=pstmt.executeQuery();
			}else{
				System.out.println("객체가 있음");
				sbSelectRecipe.append(" where food_type in(?,?,?,?)");
				pstmt= con.prepareStatement(sbSelectRecipe.toString());
				
				// 조건이 있을 때
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
	
	// 메인폼 - 최신메뉴
	public List<ShowRecipeVO> showNewRecipe(){
		return null;
	}//showNewRecipe

	// 관리자폼 - 모든레시피, 요청레시피 조회
	public List<MainRecipeVO> recipeList(String flag){
		return null;
	}//recipeList
	
	// 관리자 - 기존메뉴 삭제
	public boolean deleteRecipe(String menuName){
		return false;
	}//deleteRecipe
	
	/**
	 * 회원 - 레시피 승인요청
	 * 메소드명 insertRecipe > requestRecipe으로 변경
	 * @param addVo(AddRecipeVO) : String menuName, menuImg, menuInfo, menuType, id
	 * 						  					 Date inputDate
	 * @return
	 */
	public boolean requestRecipe(AddRecipeVO addVo){
		return false;
	}//insertRecipe
	
	// 관리자 - 기존메뉴수정
	public boolean updateRecipe(AddRecipeVO addVo){
		return false;
	}//updateRecipe
	
	// 관리자 - 레시피요청 승인
	public boolean insertRecipe(String menuCode){
		return false;
	}//confirmRecipe
	
	public static void main(String[] args){
		
		//			System.out.println(RecipeDAO.getInstance().getConnection());
					RecipeDAO md= RecipeDAO.getInstance();
					try {
						List<MainRecipeVO> list;
						list = md.selectAllRecipe(new MenuTypeVO("","","",""));
						for(MainRecipeVO tmp : list){
							System.out.println(tmp.toString());
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		
	}

}//class
