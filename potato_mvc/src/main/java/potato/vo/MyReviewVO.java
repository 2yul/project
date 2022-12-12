package potato.vo;

public class MyReviewVO {
	private String id;
	private int restarea_idx, review_idx, pageFlag=1;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public int getPageFlag() {
		return pageFlag;
	}
	public void setPageFlag(int pageFlag) {
		this.pageFlag = pageFlag;
	}
	
	@Override
	public String toString() {
		return "MyReviewVO [id=" + id + ", restarea_idx=" + restarea_idx + ", review_idx=" + review_idx + ", pageFlag="
				+ pageFlag + "]";
	}
	
}