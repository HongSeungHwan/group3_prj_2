 package kr.co.sist.recipe.evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import kr.co.sist.recipe.view.SignInForm;
import kr.co.sist.recipe.vo.MemberVO;

public class SignEvt extends WindowAdapter implements ActionListener {
	
	private SignInForm sif;
	// ȸ�������� ��� �ֱ�
	public void addMember(/*MemberVO*/){
	}//addMember
	
	// �ڽ��� ���� ����
	public void editMember(/*MemberVO*/){
	}//editMember
	
	// ���̵� �ߺ�Ȯ��
	public void checkId(String id){
	}// checkId
	
	@Override
	public void actionPerformed(ActionEvent e) {
	}//

}//class
