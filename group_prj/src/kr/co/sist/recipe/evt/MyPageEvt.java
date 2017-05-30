package kr.co.sist.recipe.evt;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import kr.co.sist.recipe.dao.BookmarkDAO;
import kr.co.sist.recipe.dao.RecipeDAO;
import kr.co.sist.recipe.view.AddRecipeForm;
import kr.co.sist.recipe.view.ItemPreviewForm;
import kr.co.sist.recipe.view.MainForm;
import kr.co.sist.recipe.view.MyPageForm;
import kr.co.sist.recipe.view.SignInForm;
import kr.co.sist.recipe.vo.BookmarkUpdateVO;
import kr.co.sist.recipe.vo.BookmarkVO;
import kr.co.sist.recipe.vo.MainRecipeVO;
import kr.co.sist.recipe.vo.MyRecipeVO;
public class MyPageEvt extends WindowAdapter implements ActionListener, MouseListener {
       private MyPageForm mpf;
       private BookmarkDAO bdao;
       private RecipeDAO rdao;
       private BookmarkVO bv;
       
       public MyPageEvt(MyPageForm mpf){
              this.mpf=mpf;
              bdao=BookmarkDAO.getInstance();
              rdao=RecipeDAO.getInstance();
              showMyRecipe("mgr");////////////////////////////////ȸ�� ���̵� ������
              showBookmark();//////////////////////////////ȸ�� ���̵� ������
       }
       
       // ���� ����� �޴� ����Ʈ
       public void showMyRecipe(String id){
              try {
                     List<MyRecipeVO> listMyRcp = rdao.myRecipe(id);
                     Object[] rowMenu = new Object[6];
                     DefaultTableModel dtmMenu = mpf.getDtmMyMenu();
                     
                     MyRecipeVO myrv=null;
                     dtmMenu.setRowCount(0);
                     // name,img,type,info,price
                     for( int i=0; i < listMyRcp.size(); i++ ){
                           myrv=listMyRcp.get(i);
                           rowMenu[0]=myrv.getMenuName();
                           rowMenu[1]=myrv.getMenuImg();
                           rowMenu[2]=myrv.getMenuType();
                           rowMenu[3]=myrv.getMenuInfo();
                           rowMenu[4]=myrv.getMenuPrice();
                           rowMenu[5]=myrv.getFlag();
                           
                           dtmMenu.addRow(rowMenu);
                     }//end for
                     
              } catch (SQLException se) {
                     JOptionPane.showMessageDialog(mpf,
                                  "�˼��մϴ�. �Ͻ����� ������ְ� �߻��Ͽ����ϴ�.\n����Ŀ� �ٽ� �õ����ּ���.");
                     se.printStackTrace();
              }//end catch
              
              
       }//showMyRecipe
       
       // �ϸ�ũ�� �޴� ����Ʈ
       public void showBookmark(){
              String id="duck";
              try {
                     List<BookmarkVO> bklist = bdao.searchAll(id);
                     Object[] rowMenu = new Object[5];
                     DefaultTableModel dtmMenu = mpf.getDtmFavorMenu();
                     
                     BookmarkVO bmvo=null;
                     dtmMenu.setRowCount(0);
                     // name,img,type,info,price
                     for( int i=0; i < bklist.size(); i++ ){
                           bmvo=bklist.get(i);
                           rowMenu[0]=bmvo.getMenuName();
                           rowMenu[1]=bmvo.getImg();
                           rowMenu[2]=bmvo.getMenuType();
                           rowMenu[3]=bmvo.getMenuInfo();
                           rowMenu[4]=bmvo.getMenuPrice();
                           
                           dtmMenu.addRow(rowMenu);
                     }//end for
                     
              } catch (SQLException se) {
                     JOptionPane.showMessageDialog(mpf,
                                  "�˼��մϴ�. �Ͻ����� ������ְ� �߻��Ͽ����ϴ�.\n����Ŀ� �ٽ� �õ����ּ���.");
                     se.printStackTrace();
              }//end catch
              
       }//showBookmark
       
       // �ϸ�ũ�� �޴� ����
       public void rmvBookmark() throws SQLException{
              String id="duck";
              BookmarkUpdateVO bmuvo= new BookmarkUpdateVO();
              try {
                     // ���̺��� Ŭ�� > menuName ��������
                     JTable jtRcp=mpf.getJtFavorMenu();
                     int row=jtRcp.getSelectedRow();
                     String value = (String) jtRcp.getValueAt(row, 0);
                     int flag=JOptionPane.showConfirmDialog(mpf,
                                  "[ "+value+" ] �����Ͻ� �޴��� ���� �����Ͻðڽ��ϱ�?");
                     switch (flag) {
                     case JOptionPane.OK_OPTION:
                           // ������ menuName �� > ����
                           bmuvo.setId(id);
                           bmuvo.setMenuName(value);
                           bdao.rmvBookmark(bmuvo);
                     }//end catch
                     // ���� �� ����
                     showBookmark();
              } catch (ArrayIndexOutOfBoundsException aioobe) {
                     JOptionPane.showMessageDialog(mpf,
                                  "�����Ǹ� �������ּ���.");
                     aioobe.printStackTrace();
              } catch (SQLException se) {
                     JOptionPane.showMessageDialog(mpf,
                                  "�˼��մϴ�. �Ͻ����� ������ְ� �߻��Ͽ����ϴ�.\n����Ŀ� �ٽ� �õ����ּ���.");
                     se.printStackTrace();
              }//end catch
       }//rmvBookmark
       
       // �� ����â���� �̵� > ������ �� �����ͼ� SignInForm�� setter���� ����
       public void goMyInfo(){
              SignInForm sif=new SignInForm();
              //////// �ʿ� ���� ��ư�� �Ⱥ��̰� //////
              sif.getJbtChkId().setVisible(false);
              sif.getJbtSubmit().setVisible(false);
              sif.setBackgroundPath("C:/dev/group_prj_git/group3_prj_2/group_prj/src/kr/co/sist/recipe/img/edit_signinBack.png");
              ////////////////////////////////////////////
              ///////////////////��� ��ư ���� ��ư���� ����////////////////
              //�����ҷ� �ƴϸ� ��ư�ϳ� �������ΰ� �״� ���� �ҷ� //
              ////////////////////////////////////////////////////////////////////
              ////////////////���̵� �̸� �κ� ���� �Է�/////
              ////////////////////////////////////////////////////
              
              //////////////���� �Ұ� �κ� ����///////////////
              sif.getJtfId().setEditable(false);
              sif.getJtfName().setEditable(false);
              ///////////////////////////////////////////////////
              
              /////////////////��ư �̸� ����/////////////////
              ///////////////////////////////////////////////////
              /////////��ư �̸� �����԰� ���ÿ� sigevt�κп� �޼ҵ� �߰��Ǿ���� (�̺�Ʈ)//
       }//goMyInfo
       
       
       
       
       @Override
       public void actionPerformed(ActionEvent ae) {
              if(ae.getSource()==mpf.getJbEditMyInfo()){
                     goMyInfo();
              }//end if
              if(ae.getSource()==mpf.getJbRmvFavorMenu()){
                     try {
                           rmvBookmark();
                     } catch (SQLException e) {
                           e.printStackTrace();
                     }
              }//end if
              
              if (ae.getSource() == mpf.getJbClose()) {
      			int selectNum = JOptionPane.showConfirmDialog(mpf, "â�� �����ðڽ��ϱ�?");
      			switch (selectNum) {
      			case JOptionPane.OK_OPTION:
      				mpf.dispose();
      			}// end switch
      		}//end if
              
       }//actionPerformed
       
       @Override
       public void mouseClicked(MouseEvent me) {
              if( me.getSource()==mpf.getJtFavorMenu() ){
                     if( me.getClickCount()==2 ){
//                         new ItemPreviewForm(MainForm mf, MainRecipeVO mrv);
                     }
              }
              
       }//mouseClicked
       @Override
       public void mousePressed(MouseEvent e) {
              // TODO Auto-generated method stub
              
       }
       @Override
       public void mouseReleased(MouseEvent e) {
              // TODO Auto-generated method stub
              
       }
       @Override
       public void mouseEntered(MouseEvent e) {
              // TODO Auto-generated method stub
              
       }
       @Override
       public void mouseExited(MouseEvent e) {
              // TODO Auto-generated method stub
              
       }
}
