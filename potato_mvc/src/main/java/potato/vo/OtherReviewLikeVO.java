package potato.vo;

public class OtherReviewLikeVO {
	private String id_clicker, id_writer;
	private int restarea_idx, review_idx;
	
	public OtherReviewLikeVO() {
		super();
	}
	
	public OtherReviewLikeVO(String id_clicker, String id_writer, int restarea_idx, int review_idx) {
		super();
		this.id_clicker = id_clicker;
		this.id_writer = id_writer;
		this.restarea_idx = restarea_idx;
		this.review_idx = review_idx;
	}
	
	public String getId_clicker() {
		return id_clicker;
	}
	public void setId_clicker(String id_clicker) {
		this.id_clicker = id_clicker;
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
	
	@Override
	public String toString() {
		return "OtherReviewLikeVO [id_clicker=" + id_clicker + ", id_writer=" + id_writer + ", restarea_idx="
				+ restarea_idx + ", review_idx=" + review_idx + "]";
	}

}
