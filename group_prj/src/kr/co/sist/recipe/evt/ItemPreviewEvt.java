package kr.co.sist.recipe.evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import kr.co.sist.recipe.dao.BookmarkDAO;
import kr.co.sist.recipe.dao.ScoreDAO;
import kr.co.sist.recipe.view.ItemPreviewForm;
import kr.co.sist.recipe.view.MainForm;
import kr.co.sist.recipe.vo.BookmarkUpdateVO;
import kr.co.sist.recipe.vo.ScoreVO;

public class ItemPreviewEvt extends WindowAdapter implements ActionListener, ItemListener {

	private ItemPreviewForm ipf;
	private BookmarkDAO bmdao;
	private ScoreDAO sdao;
	private int scoreFlag; 
	
	
	
	public ItemPreviewEvt(ItemPreviewForm ipf) {
		this.ipf=ipf;
		//////////////////복사 ///////////////////////
		bmdao=BookmarkDAO.getInstance();
		sdao=ScoreDAO.getInstance();
		chkScore();
		chkBookmark();
		
		
		//////////////////////////////////////////////
	}//ItemPreviewEvt

	// 메뉴정보 가져와서 보여줌
	public void showRcpInfo() {

	}// showRcpInfo

	// 평점 ( 조건문 : 없을때 있을때 )
	public void chkScore() {
		BookmarkUpdateVO bmuvo = new BookmarkUpdateVO();
		String id="duck";/////////////////////////////////////////////////////////////////////////////////////아이디 연결해야됨 
		String menuName=ipf.getJlRecipeName().getText().replaceAll(" ", "").replaceAll("▧","");
		int score =0;
		
		bmuvo.setId(id);
		bmuvo.setMenuName(menuName);
		
		try {
			score=sdao.popUpChkScore(bmuvo);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(ipf, "잠시후에 시도해 주세요 ");
			e.printStackTrace();
		}
		
		scoreFlag=score;
		ipf.getJcScore().setSelectedIndex(score);
	}// chkScore

	// 북마크 ( 조건문 : 체크 없을때 있을때 )
	public void chkBookmark() {
		BookmarkUpdateVO bmuvo = new BookmarkUpdateVO();
		String id="duck";/////////////////////////////////////////////////////////////////////////////////////아이디 연결해야됨 
		String menuName=ipf.getJlRecipeName().getText().replaceAll(" ", "").replaceAll("▧","");
		bmuvo.setId(id);
		bmuvo.setMenuName(menuName);
		
		try {
			if(bmdao.popUpChkBookmark(bmuvo)){
				ipf.getJchBookmark().setSelected(true);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(ipf, "잠시후에 시도해 주세요 ");
		}
		
		
		
	}// chkBookmark

	
	/////////////////////////////////////////////북마크 체크시
	public void insertBookmark(){
		BookmarkUpdateVO bmuvo = new BookmarkUpdateVO();
		
		String id="duck";/////////////////////////////////////////////////////////////////////////////////////아이디 연결해야됨 
		String menuName=ipf.getJlRecipeName().getText().replaceAll(" ", "").replaceAll("▧","");
		
		bmuvo.setId(id);
		bmuvo.setMenuName(menuName);
		try {
			bmdao.insertBookmark(bmuvo);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(ipf, "잠시후에 시도해 주세요 ");
			e.printStackTrace();
		}
	}
	/////////////////////////////////////////////북마크 해제시
	public void rmvBookmark(){
		BookmarkUpdateVO bmuvo = new BookmarkUpdateVO();
		
		String id="duck";/////////////////////////////////////////////////////////////////////////////////////아이디 연결해야됨 
		String menuName=ipf.getJlRecipeName().getText().replaceAll(" ", "").replaceAll("▧","");
		
		bmuvo.setId(id);
		bmuvo.setMenuName(menuName);
		try {
			bmdao.rmvBookmark(bmuvo);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(ipf, "잠시후에 시도해 주세요 ");
			e.printStackTrace();
		}
	}
	
	/////////////////////////////////////////////스코어 점수 주기
	public void insertScore(){
		ScoreVO svo = new ScoreVO();
		
		String id="duck";/////////////////////////////////////////////////////////////////////////////////////아이디 연결해야됨 
		String menuName=ipf.getJlRecipeName().getText().replaceAll(" ", "").replaceAll("▧","");
		int value=ipf.getJcScore().getSelectedIndex();
		if(value==0){
			JOptionPane.showMessageDialog(ipf, "점수는 0점을 주실수 없습니다.");
			return;
		}
		
		svo.setId(id);
		svo.setMenuName(menuName);
		svo.setValue(value);
		try {
			sdao.insertScore(svo);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(ipf, "잠시후에 시도해 주세요 ");
			e.printStackTrace();
		}
	}
	
	
	/////////////////////////////////////////////스코어 점수변경
	public void updateScroe(){
		ScoreVO svo = new ScoreVO();
		
		String id="duck";/////////////////////////////////////////////////////////////////////////////////////아이디 연결해야됨 
		String menuName=ipf.getJlRecipeName().getText().replaceAll(" ", "").replaceAll("▧","");
		int value=ipf.getJcScore().getSelectedIndex();
		if(value==0){
			JOptionPane.showMessageDialog(ipf, "점수는 0점을 주실수 없습니다.");
			return;
		}
		
		svo.setId(id);
		svo.setMenuName(menuName);
		svo.setValue(value);
		try {
			sdao.updateScore(svo);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(ipf, "잠시후에 시도해 주세요 ");
			e.printStackTrace();
		}
	}

	
	
	
	// 닫기
	public void checkCancel(){
		ipf.dispose();
	}//checkCancel
	
	@Override
	public void itemStateChanged(ItemEvent ie) {
		
	}//itemStateChanged

	@Override 
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == ipf.getJbClose()) {
			int selectNum = JOptionPane.showConfirmDialog(ipf, "창을 닫으시겠습니까?");
			switch (selectNum) {
			case JOptionPane.OK_OPTION:
				ipf.dispose();
			}// end switch
		}//end if
		if(ae.getSource()==ipf.getJchBookmark()){
			if(ipf.getJchBookmark().isSelected()){
				insertBookmark();
			}else{
				rmvBookmark();
			}
		}
		
		
		if(ae.getSource()==ipf.getJbSubmit()){
			if(scoreFlag==0){
				insertScore();
			}else{
				updateScroe();
			}
			
		}//end if
		if(ae.getSource()==ipf.getJbClose()){
			checkCancel();
		}//end if
		
	}//actionPerformed

}// class
