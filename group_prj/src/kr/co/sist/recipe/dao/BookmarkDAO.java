package kr.co.sist.recipe.dao;

import java.util.List;

import org.w3c.dom.ls.LSInput;

import kr.co.sist.recipe.vo.BookmarkVO;
import kr.co.sist.recipe.vo.ShowRecipeVO;

public class BookmarkDAO {

	private static BookmarkDAO book_dao;
	
	static BookmarkDAO getInstance(){
		if(book_dao==null){
			book_dao = new BookmarkDAO();
		}
		return book_dao;
	}//getInstance
	
	
	// ���������� �ϸ�ũ����Ʈ ��ȸ
	public List<BookmarkVO> searchAll(String id){
		return null;
	}//searchAll
	
	// ���������� ��ǰ�����˾����� �ϸ�ũ üũ
	public boolean insertBookmark(BookmarkVO bookVo){
		return false;
		
	}//insertBookmark
	
	// ���������� ��ǰ�����˾����� �ϸ�ũ ����
	public boolean rmvBookmark(BookmarkVO bookVo){
		return false;
		
	}//rmvBookmark
	
	// ���������� �ϸ�ũ����Ʈ�� �޴� > �޴� ����â�� ������ �ֱ�
	public ShowRecipeVO showBookmarkMenu(String menuName){
		return null;
		
	}//showBookmarkMenu
	
	
	
	
}//class
