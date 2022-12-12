package potato.domain;

public class DetailedReportDomain {
	
	private String reason;
	private int report_idx;
	
	public DetailedReportDomain() {
		super();
	}

	public DetailedReportDomain(String reason, int report_idx) {
		super();
		this.reason = reason;
		this.report_idx = report_idx;
	}

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
		return "DetailedReportDomain [reason=" + reason + ", report_idx=" + report_idx + "]";
	}

}
