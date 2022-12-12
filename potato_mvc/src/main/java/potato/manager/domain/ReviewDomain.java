package potato.manager.domain;

import java.sql.Date;

public class ReviewDomain {
	private String nick, contents, id, reviewImg, profilImg, name;
	private int restarea_idx,review_idx,rating,report_cnt,like_cnt;
	private Date post_date;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getReviewImg() {
		return reviewImg;
	}
	public void setReviewImg(String reviewImg) {
		this.reviewImg = reviewImg;
	}
	public String getProfilImg() {
		return profilImg;
	}
	public void setProfilImg(String profilImg) {
		this.profilImg = profilImg;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public int getReport_cnt() {
		return report_cnt;
	}
	public void setReport_cnt(int report_cnt) {
		this.report_cnt = report_cnt;
	}
	public int getLike_cnt() {
		return like_cnt;
	}
	public void setLike_cnt(int like_cnt) {
		this.like_cnt = like_cnt;
	}
	public Date getPost_date() {
		return post_date;
	}
	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}
	
	@Override
	public String toString() {
		return "ReviewDomain [nick=" + nick + ", contents=" + contents + ", id=" + id + ", reviewImg=" + reviewImg
				+ ", profilImg=" + profilImg + ", name=" + name + ", restarea_idx=" + restarea_idx + ", review_idx="
				+ review_idx + ", rating=" + rating + ", report_cnt=" + report_cnt + ", like_cnt=" + like_cnt
				+ ", post_date=" + post_date + "]";
	}
	
}
