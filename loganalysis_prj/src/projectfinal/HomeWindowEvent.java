package projectfinal;

import java.awt.FileDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class HomeWindowEvent extends WindowAdapter implements ActionListener {

	private HomeWindow hw;
	private String path;
	private String fileName;
	private String work1;
	private String work2;
	private String work3;
	private String work4;
	private String work5;
	private String work6;
	private String work7;
	
	public HomeWindowEvent(HomeWindow hw) {//HomeWindow를 has a 관계로 받아준다.
		this.hw = hw;
	}//HomeWindowEvent
	
	/**
	 * 창 닫기를 눌렀을 때 실행 멈춤.
	 */
	@Override
	public void windowClosing(WindowEvent e) {
		hw.getLoginWindow().dispose();
		hw.dispose();
	}// windowClosing
	
	@Override
	public void actionPerformed(ActionEvent e) {
		hw.getJlblReportMsg().setText(""); // 메시지창 초기화
		
		//View 이미지 버튼에 따른 동작 실행
		if (e.getSource() == hw.getJbView()) {
			try {
				openFile();//파일을 얻기위한 method 실행
				hw.getJlblReportMsg().setText("View에 접속했습니다.");
				new ViewWindow(hw, this); //ViewWindow 실행
			}catch (NullPointerException npe) { //파일 미 선택후 취소 눌렀을 때 발생하는 예외처리
			}catch (ArrayIndexOutOfBoundsException aiobe) { // 읽어올 수 없는 파일을 선택하고 완료 눌렀을 때 발생하는 예외처리
				JOptionPane.showMessageDialog(hw, "읽어올 수 없는 파일입니다.");
			}
		} // end if

		//LoginWindow에서 입력한 id와 pw를 얻기 위한 변수
		String id = hw.getLoginWindow().getJtfID().getText();
		String pw = String.valueOf(hw.getLoginWindow().getJpfPassword().getPassword());
		
		//Report 이미지 버튼에 따른 동작 실행
		if (e.getSource() == hw.getJbReport()) {
			try {
				//id와 pw가 root가 아닐 때 일 때 동작 실행
				//즉, admin과 administrator 일 때 동작.
				if(!id.equals("root") && !pw.equals("1111")) {
				saveFileDialog();
				hw.getJlblReportMsg().setText("Report파일이 생성되었습니다.");
				JOptionPane.showMessageDialog(hw, "파일생성완료!", "완료", JOptionPane.PLAIN_MESSAGE);
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (NullPointerException ne) { // view를 먼저 작업하지 않고 report를 눌렀을 시 발생하는 예외처리 (view를 먼저 작업할 것을 유도하는 메시지창 띄움)
				JOptionPane.showMessageDialog(hw, "view를 먼저 눌러주세요!");
			} catch (IndexOutOfBoundsException ie) {
				JOptionPane.showMessageDialog(hw, "View로 돌아가서 7번을 수행해 주세요!");
			}
			//id와 pw가 root일 때 동작 실행
			if (id.equals("root") && pw.equals("1111")) {
				hw.getJlblReportMsg().setText("Report에 접근할 수 없는 계정입니다.");
				JOptionPane.showMessageDialog(hw, "문서를 생설할 수 있는 권한이 없음", "권한 없음", JOptionPane.CANCEL_OPTION);
			} // end if
		} // end if
	}//actionPerformed
	
	/**
	 * 파일 선택을 위한 method
	 */
	private void openFile() {
		FileDialog fdOpen = new FileDialog(hw, "파일열기", FileDialog.LOAD);
		fdOpen.setVisible(true);
		if(fdOpen.getDirectory()!=null&&fdOpen.getFile()!=null) { //파일이 null이 아닐때 수행
			String directory = fdOpen.getDirectory(); //파일 경로
			fileName = fdOpen.getFile(); //파일 이름
			//파일 경로와 이름을 path에 저장.
			path = directory + fileName;
		}
	}
	
	//파일 저장.
	public void saveFileDialog() throws IOException {
		FileDialog fdSave = new FileDialog(hw, "파일 저장", FileDialog.SAVE);
		fdSave.setVisible(false);
		//파일 저장 경로
		File file = new File("/Users/yulmac/eclipse-workspace/loganalysis_prj/"); // 파일객체 생성 - 경로만 설정
		if (!file.isDirectory()) { // 파일이 없다면
			file.mkdirs();		   // 파일을 생성
		}
		StringBuilder reportFile = new StringBuilder(file.getAbsolutePath());// report버튼을 눌렀을 시 생성되는 파일의 경로와 이름생성을 위한 변수
		reportFile.append("/report_.dat"); 
		SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMdd");// 년월일 형식의 이름으로 생성 ex)20220801
		String date = sdf.format(new Date()); // Date 객체생성
		reportFile.insert(reportFile.indexOf("."), date); 
		BufferedWriter bw = null;
		doWork();
		StringBuffer fileInfo = new StringBuffer("----------------------------------------------------"); // 파일 내부에 저장되는 파일 이름에 대한 변수
		SimpleDateFormat sdf2 = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss"); // 년월일 시분초 형식으로 생성 ex)2022-08-01 12:30:22
		String date2 = sdf2.format(new Date());
		fileInfo.append("\n").append("파일명(").append(fileName).append(")").append(" log (").append(date2).append(")").append("\n").append("----------------------------------------------------");
		
		try {
			bw = new BufferedWriter(new FileWriter(reportFile.toString())); //해당경로에 파일이 없다면 생성, 있다면 덮어쓰기
			bw.write(fileInfo.toString() + "\n1번.\n" + work1 + "\n\n2번.\n" + work2 + "\n3번.\n" + work3 + "\n\n4번.\n" + work4 + "\n\n5번.\n" + work5 + "\n\n6번.\n" + work6 + "\n\n7번.\n" + work7);
			bw.flush();
		} finally {
			if (bw != null) {
				bw.close();
			}
		} // end finally
	}// saveFileDialog
	
	//파일 저장할 때 파일 안에 값을 저장하기위한 method
	private void doWork() throws IOException {
		WorkList wl = new WorkList();
		work1 = wl.work1(path);
		work2 = wl.work2(path);
		work3 = wl.work3(path);
		work4 = wl.work4(path);
		work5 = wl.work5And6(path, "403");
		work6 = wl.work5And6(path, "500");
		work7 = wl.work7(path, ViewWindowEvent.startLine, ViewWindowEvent.endLine);
	}

	public String getPath() {
		return path;
	}

	public String getFileName() {
		return fileName;
	}
	
	
	
}//class
