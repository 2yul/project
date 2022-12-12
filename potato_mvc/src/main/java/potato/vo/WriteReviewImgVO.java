package potato.vo;

public class WriteReviewImgVO {

	private String id, img;
	private int review_idx, restarea_idx, img_idx;
	
	public WriteReviewImgVO() {
		super();
	}

	public WriteReviewImgVO(String id, String img, int review_idx, int restarea_idx, int img_idx) {
		super();
		this.id = id;
		this.img = img;
		this.review_idx = review_idx;
		this.restarea_idx = restarea_idx;
		this.img_idx = img_idx;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
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

	public int getImg_idx() {
		return img_idx;
	}

	public void setImg_idx(int img_idx) {
		this.img_idx = img_idx;
	}

	@Override
	public String toString() {
		return "WriteReviewImgVO [id=" + id + ", img=" + img + ", review_idx=" + review_idx + ", restarea_idx="
				+ restarea_idx + ", img_idx=" + img_idx + "]";
	}
	
}
