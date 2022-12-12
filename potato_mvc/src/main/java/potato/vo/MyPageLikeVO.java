package potato.vo;

public class MyPageLikeVO {
	private String idClicker,review_idx, id_writer;
	private int restarea_idx;
	
	public MyPageLikeVO() {
		super();
	}
	
	public MyPageLikeVO(String idClicker, String review_idx, String id_writer, int restarea_idx) {
		super();
		this.idClicker = idClicker;
		this.review_idx = review_idx;
		this.id_writer = id_writer;
		this.restarea_idx = restarea_idx;
	}
	
	public String getIdClicker() {
		return idClicker;
	}
	public void setIdClicker(String idClicker) {
		this.idClicker = idClicker;
	}
	public String getReview_idx() {
		return review_idx;
	}
	public void setReview_idx(String review_idx) {
		this.review_idx = review_idx;
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
	
	@Override
	public String toString() {
		return "MyPageLikeVO [idClicker=" + idClicker + ", review_idx=" + review_idx + ", id_writer=" + id_writer
				+ ", restarea_idx=" + restarea_idx + "]";
	}
	
}
