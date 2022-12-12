package potato.domain;

public class MyPageReportDomain {
	
	private String reason;
	private int report_idx;
	
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public int getReport_idx() {
		return report_idx;
	}
	public void setReport_idx(int report_idx) {
		this.report_idx = report_idx;
	}
	
	@Override
	public String toString() {
		return "MyPageReportDomain [reason=" + reason + ", report_idx=" + report_idx + "]";
	}
	
}
