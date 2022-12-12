package potato.vo;

public class DetailedLikeVO {
	
	private int review_idx, restarea_idx; 
	private String id_writer, id_clicker;
	public DetailedLikeVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DetailedLikeVO(int review_idx, int restarea_idx, String id_writer, String id_clicker) {
		super();
		this.review_idx = review_idx;
		this.restarea_idx = restarea_idx;
		this.id_writer = id_writer;
		this.id_clicker = id_clicker;
	}
	public int getReview_idx() {
		return review_idx;
	}
	public void setReview_idx(int review_idx) {
		this.review_idx = review_idx;
	}
	public int getRestarea_idx() {
		return restarea_idx;
	}
	public void setRestarea_idx(int restarea_idx) {
		this.restarea_idx = restarea_idx;
	}
	public String getId_writer() {
		return id_writer;
	}
	public void setId_writer(String id_writer) {
		this.id_writer = id_writer;
	}
	public String getId_clicker() {
		return id_clicker;
	}
	public void setId_clicker(String id_clicker) {
		this.id_clicker = id_clicker;
	}
	@Override
	public String toString() {
		return "DetailedLikeVO [review_idx=" + review_idx + ", restarea_idx=" + restarea_idx + ", id_writer="
				+ id_writer + ", id_clicker=" + id_clicker + "]";
	}

}
