package potato.vo;

public class MypageReviewImgVO {
	private String id,img;
	private int restarea_idx, review_idx, img_idx;
	
	public MypageReviewImgVO() {
		super();
	}

	public MypageReviewImgVO(String id, String img, int restarea_idx, int review_idx, int img_idx) {
		super();
		this.id = id;
		this.img = img;
		this.restarea_idx = restarea_idx;
		this.review_idx = review_idx;
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

	public int getImg_idx() {
		return img_idx;
	}

	public void setImg_idx(int img_idx) {
		this.img_idx = img_idx;
	}

	@Override
	public String toString() {
		return "MypageReviewImgVO [id=" + id + ", img=" + img + ", restarea_idx=" + restarea_idx + ", review_idx="
				+ review_idx + ", img_idx=" + img_idx + "]";
	}
	
}
