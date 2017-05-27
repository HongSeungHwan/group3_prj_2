package kr.co.sist.recipe.evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.recipe.dao.MemberDAO;
import kr.co.sist.recipe.dao.RecipeDAO;
import kr.co.sist.recipe.view.MgrPageForm;
import kr.co.sist.recipe.vo.MgrMemberVO;
import kr.co.sist.recipe.vo.MgrRcpInfoListVO;

/**
 * ������
 * @author JiYong
 *
 */
public class MgrPageEvt extends WindowAdapter implements ActionListener {

	private MgrPageForm mpf;
	private MemberDAO mem_dao;
	private RecipeDAO rcp_dao;
	
	public MgrPageEvt( MgrPageForm mpf ) {
		this.mpf=mpf;
		mem_dao=MemberDAO.getInstance();
		
		memberList();
	}//MgrPageEvt
	
	//--------------------------��ü�޴����� ��
	// ��ü �޴�����Ʈ ��ȸ
		public void allRecipeList(){
			
//			rcp_dao=RecipeDAO.getInstance();
//			MgrRcpInfoListVO mrl_vo=new MgrRcpInfoListVO();
			
			
		}//allRecipeList
		
	// ��û���� ����Ʈ��ȸ
		public void requestList(){
			
		}//requestList
	
	// ���������� ���� : ����remove��ư
		public void rmvRecipe(){
			
		}//rmvRecipe
		
	// ��û������ ���� : ����remove��ư
		public void rmvReqRecipe(){
			
		}//rmvReqRecipe
		
	// ��û������ ���� : submit��ư
		public void confirmReqRecipe(){
			
		}//confirmReqRecipe

	//--------------------------ȸ������ ��
	// ȸ������ ����Ʈ
		public void memberList(){
			
			try {
				List<MgrMemberVO> list=mem_dao.selectAllMember();
				String[] rowMem = new String[3];
				DefaultTableModel dtmMem = mpf.getDtmMember();
				
				MgrMemberVO mmv=null;
				for( int i=0; i < list.size(); i++ ){
					mmv=list.get(i);
					rowMem[0]=mmv.getId();
					rowMem[1]=mmv.getName();
					rowMem[2]=mmv.getMail();
					
					dtmMem.addRow(rowMem);
				}//end for
				
			} catch (SQLException se) {
				JOptionPane.showMessageDialog(mpf, "�˼��մϴ�. �޴��� �ҷ��� �� �����ϴ�.");
				se.printStackTrace();
			}//end catch
			
		}//memberList
		
	// ȸ��Ż�� ��Ű�� : remove��ư
		public void rmvMember(){
			
		}//rmvMember
		
	// �ݱ��ư
		public void checkCancel(){
			
		}//checkCancel
	

	@Override
	public void actionPerformed(ActionEvent ae) {
		// ������ - �޴������� - �޴�����Ʈ ������ư
		if( ae.getSource() == mpf.getJbRmvMenu() ){
			rmvRecipe();
		}//end if
		// ������ - �޴������� - �޴���û����Ʈ ��û������ư
		if( ae.getSource() == mpf.getJbRmvRqust() ){
			rmvReqRecipe();
		}//end if
		// ������ - �޴������� - �޴���û����Ʈ ��û���ι�ư
		if( ae.getSource() == mpf.getJbSmitRqust() ){
			confirmReqRecipe();
		}//end if
		// ������ - ȸ�������� - ��ü ȸ������Ʈ ������ư
		if( ae.getSource() == mpf.getJbRmvMember() ){
			rmvMember();
		}//end if
		// ������ �޴� ��ҹ�ư
		if( ae.getSource() == mpf.getJbClose() ){
			checkCancel();
		}//end if
	}//actionPerformed

}//class
