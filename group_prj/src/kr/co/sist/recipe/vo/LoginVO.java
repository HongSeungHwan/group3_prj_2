package kr.co.sist.recipe.vo;

/**
 * MemberDAO - loginCheck method���� ���<br/>
 * �α��ν� ȸ�����̵�,��й�ȣ ��ġ ���� Ȯ��<br/>
 * ��ȸ����( id, pw )<br/>
 * @author JiYong
 *
 */
public class LoginVO {

	private String id, pw;
	
	public LoginVO() {
	}//LoginVO

	public LoginVO(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
	
	
}
