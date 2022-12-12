package projectfinal;

import java.awt.Color;

import java.awt.Font;
import java.awt.Image;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class ViewWindow extends JDialog{
	
	private HomeWindow hw;

	private JTextArea jtaNum1;
	private JTextArea jtaNum2;
	private JTextArea jtaNum3;
	private JTextArea jtaNum4;
	private JTextArea jtaNum5;
	private JTextArea jtaNum6;
	private JTextArea jtaNum7;
	private JLabel jlblStartMsg;
	private JLabel jlblEndMsg;
	private JTextField jtfLineStart;
	private JTextField jtfLineEnd;
	private JButton jbOkay;
	
	/**
	 * 부모 윈도우에 속한 자식윈도우로 만들기 위해 부모 윈도우( HomeWinodw )를 받는다.
	 * @param hw
	 * @param hwe
	 */
	public ViewWindow(HomeWindow hw, HomeWindowEvent hwe) {
		super(hw,"view",true);
		this.hw=hw;
		
		////////////////////////////////////////이미지등록과 크기 조절 시작///////////////////////////////////
		ImageIcon imgSubView=new ImageIcon("/Users/yulmac/eclipse-workspace/loganalysis_prj/src/projectfinal/img/view.png");
		Image iSubViewSize=imgSubView.getImage();
		Image iSubViewSet=iSubViewSize.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		ImageIcon ViewFinal=new ImageIcon(iSubViewSet);
		JLabel jlblSubView=new JLabel(ViewFinal);
	
		/////////////////////////////////////////이미지등록과 크기 조절 끝////////////////////////////////////
		
		///////////////////////////////////////////////JTextArea에 값 넣기////////////////////////////////////////////
		WorkList wl = new WorkList();
		try {
			jtaNum1=new JTextArea(wl.work1(hwe.getPath()));
			jtaNum2=new JTextArea(wl.work2(hwe.getPath()));
			jtaNum3=new JTextArea(wl.work3(hwe.getPath()));
			jtaNum4=new JTextArea(wl.work4(hwe.getPath()));
			jtaNum5=new JTextArea(wl.work5And6(hwe.getPath(), "403"));
			jtaNum6=new JTextArea(wl.work5And6(hwe.getPath(), "500"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		jtaNum7=new JTextArea();
		/////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
	   ///////////////////////////////////////////1번 JTextArea부터 7번 JTextArea 까지 세부 설정/////////////    
		//setOpaque(true) 배경색 적용 코드
		jtaNum1.setOpaque(true);
		jtaNum1.setEditable(false);
		
		jtaNum2.setOpaque(true);
		jtaNum2.setEditable(false);

		jtaNum3.setOpaque(true);
		jtaNum3.setEditable(false);

		jtaNum4.setOpaque(true);
		jtaNum4.setEditable(false);

		jtaNum5.setOpaque(true);
		jtaNum5.setEditable(false);

		jtaNum6.setOpaque(true);
		jtaNum6.setEditable(false);

		jtaNum7.setOpaque(true);
		jtaNum7.setEditable(false);
		
		jlblStartMsg=new JLabel("시작 줄 입력");
		jlblEndMsg=new JLabel("끝 줄 입력");
		
		Font font=new Font("맑은 고딕",Font.PLAIN,15);
		jlblStartMsg.setFont(font);
		jlblEndMsg.setFont(font);
		
		jtfLineStart=new JTextField();
		jtfLineEnd=new JTextField();
		
		jbOkay=new JButton("OK");
		
		
		//윈도우 컴포넌트 수동레이아웃 설정
		setLayout(null);
		
		//컴포넌트의 위치 및 크기 설정
		jlblSubView.setBounds(10, 10, 30, 30);
		jtaNum1.setBounds(30,60,300,35);
		jtaNum2.setBounds(30,110,300,90);
		jtaNum3.setBounds(30,215,300,35);
		jtaNum4.setBounds(30,265,300,35);
		jtaNum5.setBounds(30,315,300,35);
		jtaNum6.setBounds(30,365,300,35);
		jlblStartMsg.setBounds(85,410,90,35);
		jlblEndMsg.setBounds(100,440,70,35);
		jtfLineStart.setBounds(180,415,70,28);
		jtfLineEnd.setBounds(180,448,70,28);
		jbOkay.setBounds(260,415,70,60);
		jtaNum7.setBounds(30,490,300,50);
		
		//컴포넌트 배치
		add(jlblSubView);
		add(jtaNum1);
		add(jtaNum2);
		add(jtaNum3);
		add(jtaNum4);
		add(jtaNum5);
		add(jtaNum6);
		add(jlblStartMsg);
		add(jlblEndMsg);
		add(jtfLineStart);
		add(jtfLineEnd);
		add(jbOkay);
		add(jtaNum7);
		
		//////////////////////////////////////////////////이벤트 처리//////////////////////////////////////////////
		ViewWindowEvent vwe=new ViewWindowEvent(this,hwe);
		addWindowListener(vwe); //윈도우 이벤트
		//7번 범위 설정을 위한 이벤트
		jbOkay.addActionListener(vwe);
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		if(hw.getContentPane().getBackground()==Color.black) {
			jtaNum1.setBackground(Color.white);
			jtaNum2.setBackground(Color.white);
			jtaNum3.setBackground(Color.white);
			jtaNum4.setBackground(Color.white);
			jtaNum5.setBackground(Color.white);
			jtaNum6.setBackground(Color.white);
			jtaNum7.setBackground(Color.white);
		} else {
			jtaNum1.setBackground(new Color(228,228,228));
			jtaNum2.setBackground(new Color(228,228,228));
			jtaNum3.setBackground(new Color(228,228,228));
			jtaNum4.setBackground(new Color(228,228,228));
			jtaNum5.setBackground(new Color(228,228,228));
			jtaNum6.setBackground(new Color(228,228,228));
			jtaNum7.setBackground(new Color(228,228,228));
		}
		
		jlblStartMsg.setForeground(hw.getJlblReportMsg().getForeground());
		jlblEndMsg.setForeground(hw.getJlblReportMsg().getForeground());
		getContentPane().setBackground(hw.getContentPane().getBackground());
		//프레임 크기 및 시작 위치 설정
		setBounds(1100,300,376,634);
		//사용자에게 보여주기
		setVisible(true);
		
	}//ViewWindow
	
	public HomeWindow getHomeWindow() {
		return hw;
	}//getHomeWindow

	public JTextArea getJtaNum1() {
		return jtaNum1;
	}//getJtaNum1

	public JTextArea getJtaNum2() {
		return jtaNum2;
	}//getJtaNum2

	public JTextArea getJtaNum3() {
		return jtaNum3;
	}//getJtaNum3

	public JTextArea getJtaNum4() {
		return jtaNum4;
	}//getJtaNum4

	public JTextArea getJtaNum5() {
		return jtaNum5;
	}//getJtaNum5

	public JTextArea getJtaNum6() {
		return jtaNum6;
	}//getJtaNum6

	public JTextArea getJtaNum7() {
		return jtaNum7;
	}//getJtaNum7

	public JLabel getJlblStartMsg() {
		return jlblStartMsg;
	}//getJlblStartMsg

	public JLabel getJlblEndMsg() {
		return jlblEndMsg;
	}//getJlblEndMsg

	public JTextField getJtfLineStart() {
		return jtfLineStart;
	}//getJtfLineStart

	public JTextField getJtfLineEnd() {
		return jtfLineEnd;
	}//getJtfLineEnd

	public JButton getJbOkay() {
		return jbOkay;
	}//getJbOkay
	
}//class
