package projectfinal;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class LoginWindowEvent extends WindowAdapter implements ActionListener{
	
	private LoginWindow lw;
	
	/**
	 * LoginWindow를 has a 관계로 잡아준다.
	 * @param lw
	 */
	public LoginWindowEvent(LoginWindow lw) {
		this.lw = lw;
	}//LoginEvent
	
	/**
	 * 창 닫기를 눌렀을 때 실행 멈춤
	 */
	@Override
	public void windowClosing(WindowEvent e) {
		lw.dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// 다크모드 유무 선택 (배경색에 따라 이미지 변경 추가)
		if(e.getSource()==lw.getJbdark()) {
			if(lw.getContentPane().getBackground()==Color.black) {
				lw.getContentPane().setBackground(Color.white);
				ImageIcon sistMain=new ImageIcon("/Users/yulmac/eclipse-workspace/loganalysis_prj/src/projectfinal/img/쌍용 main로고 일반 버전.png");
				Image iSize=sistMain.getImage();
				Image iSet=iSize.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
				ImageIcon sistMainFinal=new ImageIcon(iSet);
				lw.getJlblSistMain().setIcon(sistMainFinal);
			} else {
				lw.getContentPane().setBackground(Color.black);
				ImageIcon sistMain=new ImageIcon("/Users/yulmac/eclipse-workspace/loganalysis_prj/src/projectfinal/img/쌍용 main로고 다크모드 버전.png");
				Image iSize=sistMain.getImage();
				Image iSet=iSize.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
				ImageIcon sistMainFinal=new ImageIcon(iSet);
				lw.getJlblSistMain().setIcon(sistMainFinal);
			}
		}//end if 
		
		//LoginWindow에서 입력한 id와 pw를 변수에 저장
		String id = lw.getJtfID().getText();
		String pw = String.valueOf(lw.getJpfPassword().getPassword());
		
		//로그인 id와 pw 설정
		if (e.getSource() == lw.getJbLoginOk()) {
			if (id.equals("admin") && pw.equals("1234")) {
				lw.setVisible(false);
				new HomeWindow(lw);
			} else if (id.equals("root") && pw.equals("1111")) {
				lw.setVisible(false);
				new HomeWindow(lw);
			} else if (id.equals("administrator") && pw.equals("12345")) {
				lw.setVisible(false);
				new HomeWindow(lw);
			} else {//로그인 id와 pw 설정이 틀렸을 경우 실행
				JOptionPane.showMessageDialog(lw,"아이디 혹은 비밀번호를 확인하십시오.", "접속불가",JOptionPane.ERROR_MESSAGE);
			} // end else
		} // end if
	}//actionPerformed
	
}//class
