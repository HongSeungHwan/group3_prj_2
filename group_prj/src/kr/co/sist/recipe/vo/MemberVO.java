package kr.co.sist.recipe.vo;

/**
 * MemberDAO - updateMember method���� ���<br/>
 * ȸ������ ���� �� �ʿ��� VO<br/>
 * ���� ���� ( ��й�ȣpw, �̸���mail )<br/>
 * @author JiYong
 *
 */
public class MemberVO {

	private String id, pw, mail;
	
	public MemberVO() {
	}//MemberVO

	public MemberVO(String id, String pw, String mail) {
		super();
		this.id=id;
		this.pw = pw;
		this.mail = mail;
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	
}
