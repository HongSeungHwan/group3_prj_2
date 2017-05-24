package kr.co.sist.recipe.vo;

/**
 * MemberDAO - updateMember method���� ���<br/>
 * ȸ������ ���� �� �ʿ��� VO<br/>
 * ���� ���� ( ��й�ȣpw, �̸���mail )<br/>
 * @author JiYong
 *
 */
public class MemberVO {

	private String pw, mail;
	
	public MemberVO() {
	}//MemberVO

	public MemberVO(String pw, String mail) {
		super();
		this.pw = pw;
		this.mail = mail;
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
