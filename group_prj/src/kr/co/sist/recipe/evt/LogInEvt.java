package kr.co.sist.recipe.evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import kr.co.sist.recipe.dao.MemberDAO;
import kr.co.sist.recipe.view.LogInForm;
import kr.co.sist.recipe.view.MainForm;
import kr.co.sist.recipe.view.SignInForm;
import kr.co.sist.recipe.vo.LoginVO;
import kr.co.sist.recipe.vo.MemberVO;



/**
 * 로그인 창 이벤트
 * <수정사항>
 * 1. parameter 제거
 * @author JiYong
 *
 */
public class LogInEvt extends WindowAdapter implements  ActionListener {

	private LogInForm lf;
	private LoginVO log_vo;
	private MemberDAO mem_dao;
	
	public LogInEvt(LogInForm lf) {
		this.lf=lf;
	}//LogInFormEvt
	
	/**
	 * 로그인 확인
	 * 입력한 아이디와 비밀번호가 유효한지 판단하는 method
	 */
	public void loginChk(){
		String logId=lf.getJtfId().getText();
		String logPw=new String(lf.getJpfPass().getPassword());
		//LogInForm에서 id, pw가 비었을때
		if( logId.equals("") || logPw.equals("") ){
			JOptionPane.showMessageDialog(lf, 
					"아이디 또는 비밀번호가 일치하지 않습니다.");
			return;
		}//end if
		
		boolean flag=false;
		log_vo=new LoginVO();
		mem_dao=MemberDAO.getInstance();
		
		log_vo.setId(logId);
		log_vo.setPw(logPw);
		
		try {
			boolean logChk=mem_dao.loginCheck(log_vo);
			if( logChk ){
				// 로그인 성공 > MainForm으로 이동
				JOptionPane.showMessageDialog(lf, 
						logId+"님 환영합니다.");
				flag=true;
				// 메인창 띄우고 로그인 창 끄기
				new MainForm(logId);
				lf.dispose();
			} else {
				// 일치하는 회원정보가 없을때
				JOptionPane.showMessageDialog(lf, 
						"해당 회원정보가 없습니다.");
			}//end if
		} catch (SQLException se) {
			se.printStackTrace();
		}//end catch
	}//loginChk

	/**
	 * 회원가입 버튼
	 * 회원가입창으로 이동
	 */
	public void moveSignin(){
		new SignInForm();
		lf.dispose();
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
