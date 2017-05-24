package kr.co.sist.recipe.vo;

/**
 * ������������ ����Ʈ�� �ѷ��� ������ �������� VO
 * @author user
 *
 */
public class MgrRcpInfoListVO {
	String menuName, menuImg, menuPrice, menuSimpleInfo, menuType, flag;
	
	public MgrRcpInfoListVO() {
	}

	public MgrRcpInfoListVO(String menuName, String menuImg, String menuPrice, String menuSimpleInfo, String recipeInfo,
			String menuType, String flag) {
		super();
		this.menuName = menuName;
		this.menuImg = menuImg;
		this.menuPrice = menuPrice;
		this.menuSimpleInfo = menuSimpleInfo;
		this.menuType = menuType;
		this.flag = flag;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuImg() {
		return menuImg;
	}

	public void setMenuImg(String menuImg) {
		this.menuImg = menuImg;
	}

	public String getMenuPrice() {
		return menuPrice;
	}

	public void setMenuPrice(String menuPrice) {
		this.menuPrice = menuPrice;
	}

	public String getMenuSimpleInfo() {
		return menuSimpleInfo;
	}

	public void setMenuSimpleInfo(String menuSimpleInfo) {
		this.menuSimpleInfo = menuSimpleInfo;
	}

	public String getMenuType() {
		return menuType;
	}

	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	

	
	
}//class
