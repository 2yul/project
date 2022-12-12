package potato.manager.domain;

public class LineDomain {
	private String line;
	private int line_idx;
	
	

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public int getLine_idx() {
		return line_idx;
	}

	public void setLine_idx(int line_idx) {
		this.line_idx = line_idx;
	}

	@Override
	public String toString() {
		return "LineDomain [line=" + line + ", line_idx=" + line_idx + "]";
	}
	
}
