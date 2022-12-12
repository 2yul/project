package projectfinal;

import java.awt.Color;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;


/**
 * 자식 윈도우(Dialog)
 * @author user
 */
@SuppressWarnings("serial")
public class HomeWindow extends JDialog {
	
	private LoginWindow lw;
	private JButton jbView;
	private JButton jbReport;
	private JLabel jlblReportMsg;
	
	/**
	 * 부모 윈도우에 속한 자식윈도우로 만들기 위해 부모 윈도우( LoginWinodw )를 받는다.
	 * @param lw
	 */
	public HomeWindow(LoginWindow lw) {
		//모달이면 자식 창이 뜨면 부모 클릭되지 않고 비모달이면 자식창이 떠도 부모창이 클릭이 된다.
		super(lw,"",true); // true 모달, false 비모달
		this.lw = lw;
		
		////일반 컴포넌트 생성
		jlblReportMsg=new JLabel();
		//수평 위치 변경
		jlblReportMsg.setHorizontalAlignment(JLabel.CENTER);
		
		/////////////////////////////////////////이미지등록과 크기 조절 시작///////////////////////////////////////////////
		//상단 로고 이미지 등록과 크기 조절
			if(lw.getContentPane().getBackground()==Color.black) {
				ImageIcon sistSub=new ImageIcon("/Users/yulmac/eclipse-workspace/loganalysis_prj/src/projectfinal/img/쌍용sub로고 다크모드 버전.png"); //이미지 절대경로
				Image iSistSize=sistSub.getImage();
				Image iSistSet=iSistSize.getScaledInstance(290, 120, Image.SCALE_DEFAULT); //default 이미지 크기 변경
				ImageIcon sistSubFinal=new ImageIcon(iSistSet);
				JLabel jlblSistSub=new JLabel(sistSubFinal);
				jlblSistSub.setBounds(40,30,290,120);
				add(jlblSistSub);
			} else {
				ImageIcon sistSub=new ImageIcon("/Users/yulmac/eclipse-workspace/loganalysis_prj/src/projectfinal/img/쌍용 sub로고 일반 버전.png"); //이미지 절대경로
				Image iSistSize=sistSub.getImage();
				Image iSistSet=iSistSize.getScaledInstance(290, 120, Image.SCALE_DEFAULT); //default 이미지 크기 변경
				ImageIcon sistSubFinal=new ImageIcon(iSistSet);
				JLabel jlblSistSub=new JLabel(sistSubFinal);
				jlblSistSub.setBounds(40,30,290,120);
				add(jlblSistSub);
			}
		///////////////////////////////////////View 이미지 등록과 버튼 생성//////////////////////////////////////
			
		ImageIcon imgView=new ImageIcon("/Users/yulmac/eclipse-workspace/loganalysis_prj/src/projectfinal/img/view.png"); //이미지 절대경로
		Image iViewSize=imgView.getImage();
		Image iViewSet=iViewSize.getScaledInstance(100, 100, Image.SCALE_DEFAULT); //default 이미지 크기 변경
		ImageIcon ViewFinal=new ImageIcon(iViewSet);
		jbView=new JButton("View",ViewFinal); //버튼 생성과 이미지 붙이기
		//버튼 글자의 수직 위치 변경하기
		jbView.setVerticalTextPosition(JButton.BOTTOM);
		//버튼 글자의 수평 위치 변경하기
		jbView.setHorizontalTextPosition(JButton.CENTER);
		
		//////////////////////////////////////////////////Report 이미지 등록과 버튼 생성/////////////////////////////////
		ImageIcon imgReport=new ImageIcon("/Users/yulmac/eclipse-workspace/loganalysis_prj/src/projectfinal/img/report.png"); //이미지절대경로
		Image iReportSize=imgReport.getImage();
		Image iReportSet=iReportSize.getScaledInstance(100, 100, Image.SCALE_DEFAULT); //default 이미지 크기 변경
		ImageIcon ReportFinal=new ImageIcon(iReportSet);
		jbReport=new JButton("Report", ReportFinal); //버튼 생성과 이미지 붙이기
		//버튼 글자의 수직 위치 변경하기
		jbReport.setVerticalTextPosition(JButton.BOTTOM);
		//버튼 글자의 수평 위치 변경하기
		jbReport.setHorizontalTextPosition(JButton.CENTER);
		/////////////////////////////////////////이미지등록과 크기 조절 끝///////////////////////////////////////////////////
		
		//윈도우 컴포넌트 수동레이아웃 설정
		setLayout(null);
		//컴포넌트의 위치 및 크기 설정
		jbView.setBounds(110,140,150,150);
		jbReport.setBounds(110,300,150,150);
		jlblReportMsg.setBounds(82,470,210,25);
		
		//컴포넌트 배치
		add(jlblReportMsg);
		add(jbView);
		add(jbReport);
		
//////////////////////////////////////////////////이벤트 처리//////////////////////////////////////////////
		HomeWindowEvent hwe=new HomeWindowEvent(this);
		addWindowListener(hwe); //윈도우 이벤트
		//View를 위한 이벤트
		jbView.addActionListener(hwe);
		//Report를 위한 이벤트
		jbReport.addActionListener(hwe);
		///////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		if(lw.getContentPane().getBackground()==Color.black) {
			jlblReportMsg.setForeground(Color.white);
		} else {
			jlblReportMsg.setForeground(Color.black);
		}//end if
		
		getContentPane().setBackground(lw.getContentPane().getBackground());
		//프레임 크기 및 시작 위치 설정
		setBounds(735,300,376,634);
		//사용자에게 보여주기
		setVisible(true);
		
	}//HomeWindow
	
	/**
	 * Getter 메소드 HomeWindowEvent에서 접근하게 끔 하기 위해 생성
	 * @return
	 */
	public LoginWindow getLoginWindow() {
		return lw;
	}//getLo

	/**
	 * Getter 메소드 HomeWindowEvent에서 접근하게 끔 하기 위해 생성
	 * @return
	 */
	public JButton getJbView() {
		return jbView;
	}//getJbView

	/**
	 * Getter 메소드 HomeWindowEvent에서 접근하게 끔 하기 위해 생성
	 * @return
	 */
	public JButton getJbReport() {
		return jbReport;
	}//getJbReport

	/**
	 * Getter 메소드 HomeWindowEvent에서 접근하게 끔 하기 위해 생성
	 * @return
	 */
	public JLabel getJlblReportMsg() {
		return jlblReportMsg;
	}//getJlblReportMsg
	
}//class
