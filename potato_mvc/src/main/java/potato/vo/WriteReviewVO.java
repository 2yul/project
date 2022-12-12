package potato.vo;

import java.util.Arrays;

public class WriteReviewVO {
	
	private String id, contents;
	private int restarea_idx, review_idx, rating;
	
	public WriteReviewVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WriteReviewVO(String id, String contents, int restarea_idx, int review_idx, int rating) {
		super();
		this.id = id;
		this.contents = contents;
		this.restarea_idx = restarea_idx;
		this.review_idx = review_idx;
		this.rating = rating;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
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

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "WriteReviewVO [id=" + id + ", contents=" + contents + ", restarea_idx=" + restarea_idx + ", review_idx="
				+ review_idx + ", rating=" + rating + "]";
	}
	
}
