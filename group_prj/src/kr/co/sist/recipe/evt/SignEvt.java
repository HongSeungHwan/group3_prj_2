 package kr.co.sist.recipe.evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import kr.co.sist.recipe.view.LogInForm;
import kr.co.sist.recipe.view.SignInForm;
import kr.co.sist.recipe.vo.MemberVO;

/**
 * �ӽ÷� �־����
 * ���� ������ �� ������
 * @author JiYong
 *
 */
public class SignEvt extends WindowAdapter implements ActionListener {
	
	private SignInForm sf;
	private int flag;
	
<<<<<<< HEAD
	public SignEvt(SignInForm sf){
		this.sf=sf;
	}
	
=======
	
	public SignEvt(SignInForm sf) {
		this.sf = sf;
	}

>>>>>>> branch 'master' of https://github.com/jyungcel89/group3_prj_2.git
	// ȸ�������� ��� �ֱ�
	public void addMember(/*MemberVO*/){
		System.out.println("�ߺ�Ȯ��"+flag);
		if(flag==0){
			JOptionPane.showMessageDialog(sf, "���̵� �ߺ�Ȯ���� ���ּ���.");
		}else if(sf.getJpfPw()!=sf.getJpfChkPw()){
			JOptionPane.showMessageDialog(sf, "��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			sf.getJpfPw().setText("");
			sf.getJpfChkPw().setText("");
		}else{
			JOptionPane.showMessageDialog(new LogInForm(), "���Կ� �����ϼ̽��ϴ�. �α��� ���ּ���.");
		}//end if
	}//addMember
	
	// �ڽ��� ���� ����
	public void editMember(/*MemberVO*/){
	}//editMember
	
	// ���̵� �ߺ�Ȯ��
	public void checkId(/*String id*/){
		String id="admin";
		if(sf.getJtfId().equals(id)){
			JOptionPane.showMessageDialog(sf, 
					"������� ���̵��Դϴ�. �ٸ� ���̵� �Է����ּ���.");
			sf.getJtfId().setText("");
		}else{
			flag=JOptionPane.showConfirmDialog(sf, 
					"��밡���� ���̵��Դϴ�. �� ���̵� ����Ͻðڽ��ϱ�?");
			switch ( flag ) {
			case JOptionPane.OK_OPTION:
				sf.getJtfId().setEditable(false);
			case JOptionPane.CANCEL_OPTION:
				sf.getJtfId().setText("");
			}//end switch
			System.err.println("�ߺ�Ȯ��1"+flag);
		}//end if
	}// checkId
	
	//Ŭ���� ���̾�׷��� ���� method - ��ҹ�ư �̺�Ʈ
	public void checkCancel(){
		int flag=JOptionPane.showConfirmDialog(sf, "������ ����Ͻðڽ��ϱ�?");
		switch (flag) {
		case JOptionPane.OK_OPTION:
			sf.dispose();
		}//end switch
	}//checkCancel
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==sf.getJbtChkId()){
			checkId();
		}//end if
		if(ae.getSource()==sf.getJbtSubmit()){
			addMember();
		}//end if
		if(ae.getSource()==sf.getJbtCancel()){
			checkCancel();
		}//end if
	}//actionPerformed

}//class
