package potato.vo;

import java.sql.Date;

public class MypageLikeReviewVO {
	private String id,nick,contents;
	private int review_idx,restarea_idx,rating;
	private Date post_date;
	
	public MypageLikeReviewVO() {
		super();
	}

	public MypageLikeReviewVO(String id, String nick, String contents, int review_idx, int restarea_idx, int rating,
			Date post_date) {
		super();
		this.id = id;
		this.nick = nick;
		this.contents = contents;
		this.review_idx = review_idx;
		this.restarea_idx = restarea_idx;
		this.rating = rating;
		this.post_date = post_date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
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

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Date getPost_date() {
		return post_date;
	}

	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}

	@Override
	public String toString() {
		return "MypageLikeReviewVO [id=" + id + ", nick=" + nick + ", contents=" + contents + ", review_idx="
				+ review_idx + ", restarea_idx=" + restarea_idx + ", rating=" + rating + ", post_date=" + post_date
				+ "]";
	}
	
}
