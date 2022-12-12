package potato.vo;

public class DetailedReviewVO {

	private String img, id, id_clicker, id_writer;
	private int dateFlag, addFlag, review_idx, restarea_idx;
	public DetailedReviewVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DetailedReviewVO(String img, String id, String id_clicker, String id_writer, int dateFlag, int addFlag,
			int review_idx, int restarea_idx) {
		super();
		this.img = img;
		this.id = id;
		this.id_clicker = id_clicker;
		this.id_writer = id_writer;
		this.dateFlag = dateFlag;
		this.addFlag = addFlag;
		this.review_idx = review_idx;
		this.restarea_idx = restarea_idx;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public int getDateFlag() {
		return dateFlag;
	}
	public void setDateFlag(int dateFlag) {
		this.dateFlag = dateFlag;
	}
	public int getAddFlag() {
		return addFlag;
	}
	public void setAddFlag(int addFlag) {
		this.addFlag = addFlag;
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
	@Override
	public String toString() {
		return "DetailedReviewVO [img=" + img + ", id=" + id + ", id_clicker=" + id_clicker + ", id_writer=" + id_writer
				+ ", dateFlag=" + dateFlag + ", addFlag=" + addFlag + ", review_idx=" + review_idx + ", restarea_idx="
				+ restarea_idx + "]";
	}
	
	
}//class
