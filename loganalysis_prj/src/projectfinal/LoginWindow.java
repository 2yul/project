package projectfinal;

import java.awt.Color;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


/**
 * 부모창 => Frame
 * @author user
 */
@SuppressWarnings("serial")
public class LoginWindow extends JFrame {
	
	private JTextField jtfID; //아이디를 입력하기 위한 Field
	private JPasswordField jpfPassword; //비밀번호를 입력하기 위한 Field
	private JButton jbLoginOk; //로그인을 위한 버튼
	private JButton jbdark; //로그인을 위한 버튼
	private JLabel jlblSistMain;
	

	public LoginWindow() {
		super("로그인 화면"); //타이틀바 제목
		
		//일반 컴포넌트 생성
		jtfID=new JTextField();
		jpfPassword=new JPasswordField();
		jbLoginOk=new JButton("로그인");
		jbdark=new JButton("다크모드");
		
		/////////////////////////////////////////////////이미지등록과 크기 조절 시작/////////////////////////////////////////
		ImageIcon sistMain=new ImageIcon("/Users/yulmac/eclipse-workspace/loganalysis_prj/src/projectfinal/img/쌍용 main로고 일반 버전.png");
		Image iSize=sistMain.getImage();
		Image iSet=iSize.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon sistMainFinal=new ImageIcon(iSet);
		jlblSistMain=new JLabel(sistMainFinal);
		////////////////////////////////////////////////이미지등록과 크기 조절 끝///////////////////////////////////////////
		//윈도우 컴포넌트 수동레이아웃 설정
		setLayout(null);
		//컴포넌트의 위치 및 크기 설정
		jlblSistMain.setBounds(80, 80, 200, 200);
		jtfID.setBounds(80, 300, 200, 25);
		jpfPassword.setBounds(80, 325, 200, 25);
		jbLoginOk.setBounds(80, 360, 200, 25);
		jbdark.setBounds(240, 550, 100, 25);
		
		//컴포넌트 배치
		add(jlblSistMain);
		add(jtfID);
		add(jpfPassword);
		add(jbLoginOk);
		add(jbdark);
		
		//////////////////////////////////////////////////이벤트 처리//////////////////////////////////////////////
		LoginWindowEvent lwe=new LoginWindowEvent(this);
		addWindowListener(lwe);//윈도우 이벤트
		//로그인을 위한 이벤트
		jbLoginOk.addActionListener(lwe);
		jbdark.addActionListener(lwe);
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		getContentPane().setBackground(Color.white);
		//프레임 크기 및 시작 위치 설정
		setBounds(735,300,376,634);
		//사용자에게 보여주기
		setVisible(true);
	}//LoginWindow
	
	/**
	 * Getter 메소드 LoginWindowEvent에서 접근하게 끔 하기 위해 생성
	 * @return
	 */
	public JButton getJbdark() {
		return jbdark;
	}//getJbdark

	/**
	 * Getter 메소드 LoginWindowEvent에서 접근하게 끔 하기 위해 생성
	 * @return
	 */
	public JLabel getJlblSistMain() {
		return jlblSistMain;
	}//getJlblSistMain
	
	/**
	 * Getter 메소드 LoginWindowEvent에서 접근하게 끔 하기 위해 생성
	 * @return
	 */
	public JButton getJbLoginOk() {
		return jbLoginOk;
	}//getJbLoginOk

	/**
	 * Getter 메소드 LoginWindowEvent에서 접근하게 끔 하기 위해 생성
	 * @return
	 */
	public JTextField getJtfID() {
		return jtfID;
	}//getJtfID

	/**
	 * Getter 메소드 LoginWindowEvent에서 접근하게 끔 하기 위해 생성
	 * @return
	 */
	public JPasswordField getJpfPassword() {
		return jpfPassword;
	}//getJpfPassword
	
	public static void main(String[] args) {
		new LoginWindow();
	}//main
}//class
