package kr.co.sist.recipe.evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

import kr.co.sist.recipe.view.LogInForm;
import kr.co.sist.recipe.view.SignInForm;

/**
 * �ӽ÷� �־���� ��
 * ���� ������ ��!!
 * @author JiYong
 *
 */
public class LogInEvt extends WindowAdapter implements  ActionListener {

	private LogInForm lf;
	
	public LogInEvt(LogInForm lf) {
		this.lf=lf;
	}//LogInFormEvt
	// �α��� Ȯ��
	public void loginChk(){
		String strId=lf.getJtfId().getText();
		String strPw=new String(lf.getJpfPass().getPassword());
		if(strId.equals("mgr")&&strPw.equals("1234")){
			JOptionPane.showMessageDialog(lf, "������ ���� �α��� ����!");
		}else if(strId.equals("user")&&strPw.equals("1234")){
			JOptionPane.showMessageDialog(lf, "����� ���� �α��� ����!");
		}else{
			JOptionPane.showMessageDialog(lf, 
					"���̵�� ��й�ȣ�� �ٸ��� �Է����ּ���.");
		}//end else if
	}//loginChk

	public void moveSignin(){
		new SignInForm();
	}//moveSignin
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==lf.getJbtLogIn()){
			loginChk();
		}//end if
		if(ae.getSource()==lf.getJbtSignIn()){
			moveSignin();
		}//end if
	}//actionPerformed
	

}//class
