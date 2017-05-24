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

import kr.co.sist.recipe.vo.InsertMemberVO;
import kr.co.sist.recipe.vo.LoginVO;
import kr.co.sist.recipe.vo.MemberVO;
import kr.co.sist.recipe.vo.MgrMemberVO;

public class MemberDAO {

	private static MemberDAO mem_dao;
	
	static MemberDAO getInstance(){
		if(mem_dao==null){
			mem_dao = new MemberDAO();
		}
		return mem_dao;
	}//getInstance
	
	//////////////////////////05-22-2017 �ۼ�////////////////////////
	private Connection getConnection()throws SQLException{
		Connection con=null;
		
		Properties prop=new Properties();
		try{
			//���� ��� Ȯ���ϰ� ������ ��!
			File file=new File("C:/dev/workspace/group_prj/src/kr/co/sist/recipe/dao/member_db.properties");
			
			if( file.exists() ){
				prop.load(new FileInputStream(file));
				String driver=prop.getProperty("driver");
				String url=prop.getProperty("url");
				String id=prop.getProperty("dboid");
				String pass=prop.getProperty("dbopwd");
				
				//����̹� ����
				try{
					//������ �� �Ǿ��ٸ� ����
					Class.forName(driver);
					con=DriverManager.getConnection(url, id, pass);
				} catch (ClassNotFoundException cnfe) {
					cnfe.printStackTrace();
				}//end catch
			}else{
				JOptionPane.showMessageDialog(null, "���������� ��θ� Ȯ���ϼ���.");
			}//end else if
			
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		}//end catch
		return con;
	}//getConnection
	
	// ���������� ����
	public MemberVO selectOneMember(String id){
		return null;
	}//selectOneMember
	
	/**
	 * ������ - ��ü ȸ�� ��� ��ȸ<br>
	 * id,name,email�� ��ȸ�Ͽ�
	 * MgrMemberVO�� �����ϰ� List�� �߰��Ͽ� ��ȯ�ϴ� ��
	 * @return
	 * @throws SQLException
	 */
	public List<MgrMemberVO> selectAllMember() throws SQLException{
		List<MgrMemberVO>mgrMemberList=new ArrayList<MgrMemberVO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
		//1.����̹� �ε�
		//2.Connection ���
			con=getConnection();
		//3.������ ������ü ���
			String selectAllMember=
					"select id,name,email from members";
			pstmt=con.prepareStatement(selectAllMember);
		//4.�������� �� ��� ���
			rs=pstmt.executeQuery();
			MgrMemberVO mmv=null;
			while( rs.next() ){
				mmv=new MgrMemberVO();
				mmv.setId(rs.getString("id"));
				mmv.setName(rs.getString("name"));
				mmv.setEmail(rs.getString("email"));
				
				mgrMemberList.add(mmv);
			}//end while
		} finally {
		//5.�������
			if( rs != null ){ rs.close(); };//end if
			if( pstmt !=null ){ pstmt.close(); };//end if
			if( con != null ){ con.close(); };//end if
		}//end finally
		
		return mgrMemberList;
	}//selectAllMember
	
	/**
	 * ȸ������<br>
	 * �Էµ� ȸ������(id,pw,name,email)�� �޾Ƽ� 
	 * db�� members ���̺� �߰��ϴ� ��<br>
	 * <��������><br>
	 * 1.boolean > void<br>
	 * 2.InsertMemberVO �߰� > id,pw,name,email �ִ� VO<br>
	 * @param imemVo
	 * @throws SQLException
	 */
	public void insertMember(InsertMemberVO imemVo) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		try{
		//1.����̹� �ε�
		//2.Connection ���
			con=getConnection();
		//3.������ ������ü ���
			//ȸ�����Խ� ������ members ���̺� �߰��ϴ� ������  
			String insertMember=
					"insert into members (id,pw,name,email) values (?,?,?,?)";
			pstmt=con.prepareStatement(insertMember);
		//4.������ ���� �� ��� ���
			//���ε�.set�ڷ���(�÷�, �� ������)
			pstmt.setString(1, imemVo.getId());
			pstmt.setString(2, imemVo.getPw());
			pstmt.setString(3, imemVo.getName());
			pstmt.setString(4, imemVo.getEmail());
			
			pstmt.executeUpdate();
		}finally{
		//5.�������
			if( pstmt != null ){ pstmt.close(); };//end if
			if( con != null ){ con.close(); };//end if
		}//end finally
	}//insertMember
	
	// ������ ȸ��Ż��
	public boolean deleteMember(String id){
		return false;
	}//deleteMember
	
	// ȸ������ ����
	/**
	 * ȸ������ ����<br>
	 * �ش� ȸ������(pw, email)�� ���� �޾� 
	 * db�� members ���̺��� ���� ����<br>
	 * <��������><br>
	 * 1.boolean > void<br>
	 * 2.MemberVO �׸� ���� > pw, email �ִ� VO<br>
	 * @param memVo
	 * @throws SQLException
	 */
	public void updateMember(MemberVO memVo) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		try{
		//1.����̹� �ε�
		//2.Connection ���
			con=getConnection();
		//3.������ ������ü ���
			//�α��ε� ȸ�������� �����ϴ� ������
			//�ش� ���̵� �������� �� �����ϱ�
			String updateMember="update members set pw=?, mail=? where id=?";
			pstmt=con.prepareStatement(updateMember);
		//4.������ ���� �� ��� ���
			pstmt.setString(1, memVo.getPw());
			pstmt.setString(2, memVo.getMail());
//			pstmt.setString(3, );
			
			pstmt.executeUpdate(); 
		}finally{
		//5.�������
			if( pstmt != null ){ pstmt.close(); };//end if
			if( con != null ){ con.close(); };//end if
		}//end finally
	}//updateMember
	
	// ���̵� �ߺ�Ȯ��
	public boolean checkId(String id){
		return false;
	}//checkId
	
	// �α���
	public boolean loginCheck(LoginVO logVo){
		return false;
	}//loginCheck
	
	
}//class
