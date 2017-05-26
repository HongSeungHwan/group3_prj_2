package kr.co.sist.recipe.vo;
 
/**
 * RecipeDAO�� updateRecipe�޼ҵ忡�� �����ڰ� �޴������ÿ� ������ ������ �� ���
 * @author user
 * set img=?, food_type=?, info=?, recipe_info=? 
 */
public class RecipeInfoUpdateVO {
	String menuImg, menuType, menuSimpleInfo, menuDetailInfo;

	public RecipeInfoUpdateVO() {
	}

	public RecipeInfoUpdateVO(String menuImg, String menuType, String menuSimpleInfo, String menuDetailInfo) {
		super();
		this.menuImg = menuImg;
		this.menuType = menuType;
		this.menuSimpleInfo = menuSimpleInfo;
		this.menuDetailInfo = menuDetailInfo;
	}

	public String getMenuImg() {
		return menuImg;
	}

	public void setMenuImg(String menuImg) {
		this.menuImg = menuImg;
	}

	public String getMenuType() {
		return menuType;
	}

	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}

	public String getMenuSimpleInfo() {
		return menuSimpleInfo;
	}

	public void setMenuSimpleInfo(String menuSimpleInfo) {
		this.menuSimpleInfo = menuSimpleInfo;
	}

	public String getMenuDetailInfo() {
		return menuDetailInfo;
	}

	public void setMenuDetailInfo(String menuDetailInfo) {
		this.menuDetailInfo = menuDetailInfo;
	}
	
	
}
