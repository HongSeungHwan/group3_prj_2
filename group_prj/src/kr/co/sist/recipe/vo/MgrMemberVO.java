package kr.co.sist.recipe.vo;

/**
 * MemberDAO - selectAllMember method���� ���<br/>
 * �����ڰ� ��ü ȸ�� ����� ��ȸ�� �ʿ�<br/>
 * ��ȸ����( id, name, mail )<br/>
 * @author JiYong
 *
 */
public class MgrMemberVO {

	private String id,name,email;
	
	public MgrMemberVO(){
	}//MgrMemberVO

	public MgrMemberVO(String id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
}
