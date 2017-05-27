package kr.co.sist.recipe.vo;

/**
 * MemberDAO - selectAllMember method���� ���<br/>
 * �����ڰ� ��ü ȸ�� ����� ��ȸ�� �ʿ�<br/>
 * ��ȸ����( id, name, mail )<br/>
 * @author JiYong
 *
 */
public class MgrMemberVO {

	private String id,name,mail;
	
	public MgrMemberVO(){
	}//MgrMemberVO

	public MgrMemberVO(String id, String name, String mail) {
		super();
		this.id = id;
		this.name = name;
		this.mail = mail;
	}//MgrMemberVO

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "MgrMemberVO [id=" + id + ", name=" + name + ", mail=" + mail + "]";
	}

	
	
	
}
