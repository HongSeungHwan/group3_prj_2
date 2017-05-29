package kr.co.sist.recipe.evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import kr.co.sist.recipe.view.ItemPreviewForm;
import kr.co.sist.recipe.view.MainForm;

public class ItemPreviewEvt extends WindowAdapter implements ActionListener, ItemListener {

	private ItemPreviewForm ipf;
	
	public ItemPreviewEvt(ItemPreviewForm ipf) {
		this.ipf=ipf;
	}//ItemPreviewEvt

	// �޴����� �����ͼ� ������
	public void showRcpInfo(){
		
	}//showRcpInfo
	
	// ���� ( ���ǹ� : ������ ������ )
	public void chkScore(){
		
	}//chkScore
	
	// �ϸ�ũ ( ���ǹ� : üũ ������ ������ )
	public void chkBookmark(){
		
	}//chkBookmark

	// �ݱ�
	public void checkCancel(){
		ipf.dispose();
	}//checkCancel
	@Override
	public void itemStateChanged(ItemEvent ie) {
		
	}//itemStateChanged

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==ipf.getJbSubmit()){
			
		}//end if
		if(ae.getSource()==ipf.getJbClose()){
			checkCancel();
		}//end if
		
	}//actionPerformed


}//class
