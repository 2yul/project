package potato.vo;

public class OtherReviewReportVO {
	
	private String id_reporter, id_writer;
	private int restarea_idx, review_idx, report_idx;
	
	public OtherReviewReportVO() {
		super();
	}
	
	public OtherReviewReportVO(String id_reporter, String id_writer, int restarea_idx, int review_idx, int report_idx) {
		super();
		this.id_reporter = id_reporter;
		this.id_writer = id_writer;
		this.restarea_idx = restarea_idx;
		this.review_idx = review_idx;
		this.report_idx = report_idx;
	}
	
	public String getId_reporter() {
		return id_reporter;
	}
	public void setId_reporter(String id_reporter) {
		this.id_reporter = id_reporter;
	}
	public String getId_writer() {
		return id_writer;
	}
	public void setId_writer(String id_writer) {
		this.id_writer = id_writer;
	}
	public int getRestarea_idx() {
		return restarea_idx;
	}
	public void setRestarea_idx(int restarea_idx) {
		this.restarea_idx = restarea_idx;
	}
	public int getReview_idx() {
		return review_idx;
	}
	public void setReview_idx(int review_idx) {
		this.review_idx = review_idx;
	}
	public int getReport_idx() {
		return report_idx;
	}
	public void setReport_idx(int report_idx) {
		this.report_idx = report_idx;
	}
	
	@Override
	public String toString() {
		return "OtherReviewReportVO [id_reporter=" + id_reporter + ", id_writer=" + id_writer + ", restarea_idx="
				+ restarea_idx + ", review_idx=" + review_idx + ", report_idx=" + report_idx + "]";
	}
	
}
