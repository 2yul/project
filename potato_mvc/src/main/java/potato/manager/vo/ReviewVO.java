package potato.manager.vo;

public class ReviewVO {
	private String id;
	private int restarea_idx ,review_idx;
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
	@Override
	public String toString() {
		return "ReviewVO [id=" + id + ", restarea_idx=" + restarea_idx + ", review_idx=" + review_idx + "]";
	}
	
	

	
	
	
	
}
