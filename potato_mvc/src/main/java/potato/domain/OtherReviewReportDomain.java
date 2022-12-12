package potato.domain;

public class OtherReviewReportDomain {
	private String reason;
	private int report_idx;
	
	public OtherReviewReportDomain() {
		super();
	}

	public OtherReviewReportDomain(String reason, int report_idx) {
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
		return "OtherReviewReportDomain [reason=" + reason + ", report_idx=" + report_idx + "]";
	}
	
}
