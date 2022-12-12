package projectfinal;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JOptionPane;

public class ViewWindowEvent extends WindowAdapter implements ActionListener {
	private ViewWindow vw;
	private HomeWindowEvent hwe;
	static int startLine;
	static int endLine;

	public ViewWindowEvent(ViewWindow vw, HomeWindowEvent hwe) { // ViewWindow와 HomeWindowEvent를 has a관계로 얻는다.
		this.vw = vw;
		this.hwe = hwe;
	}// ViewWindowEvent

	/**
	 * 창 닫기를 눌렀을 때 실행 멈춤.
	 * 
	 * @param we
	 */
	@Override
	public void windowClosing(WindowEvent we) {
		if (vw.getJtaNum7().getText().isEmpty()) {
			JOptionPane.showMessageDialog(vw, "7번을 수행해주세요.");
		} else {
			vw.dispose();
		}
	}// windowClosing

	@Override
	public void actionPerformed(ActionEvent ae) {
		// 버튼이 눌러졌을 때 동작 실행
		if (ae.getSource() == vw.getJbOkay()) {
			WorkList wl = new WorkList();
			try {
				if (vw.getJtfLineStart().getText().isEmpty()) { // 시작줄이 공백일 때
					JOptionPane.showMessageDialog(vw, "시작 줄을 입력해주세요.");
				} else if (vw.getJtfLineEnd().getText().isEmpty()) { // 마지막줄이 공백일 때
					JOptionPane.showMessageDialog(vw, "마지막 줄을 입력해주세요.");
				} else {
					// viewWindow에서 입력한 숫자를 가져오기 위한 코드
					startLine = Integer.parseInt(vw.getJtfLineStart().getText());
					endLine = Integer.parseInt(vw.getJtfLineEnd().getText());
					if (startLine > endLine) { // 시작줄 입력 숫자가 마지막줄 입력 숫자보다 클 때
						JOptionPane.showMessageDialog(vw, "마지막 줄은 시작 줄보다 커야합니다.");
					} else {
						switch (hwe.getFileName()) { // 1번 파일과 2번 파일을 비교하여 최소 라인수와 최대 라인수의 입력을 제한한다.
						case "sist_input_1.log":
							if (startLine < 1 || (endLine < 1 || endLine > 1981)) {
								JOptionPane.showMessageDialog(vw, "범위를 벗어났습니다. 1~1987까지의 범위를 설정하세요", "오류!",
										JOptionPane.ERROR_MESSAGE);
								break;
							}
						case "sist_input_2.log":
							if (startLine < 1 || (endLine < 1 || endLine > 6081)) {
								JOptionPane.showMessageDialog(vw, "범위를 벗어났습니다. 1~6081까지의 범위를 설정하세요", "오류!",
										JOptionPane.ERROR_MESSAGE);
								break;
							}
						default:
							vw.getJtaNum7().setText(wl.work7(hwe.getPath(), startLine, endLine));
						}// end switch
					} // end else
				} // end else
			} catch (NumberFormatException nfe) { // 숫자가 아닌 문자를 입력했을 때 발생하는 예외처리
				JOptionPane.showMessageDialog(vw, "숫자를 입력해주세요.");
			} catch (IndexOutOfBoundsException iobe) {
				iobe.printStackTrace();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}

		} // actionPerformed
	}// actionPerformed

}
// class
