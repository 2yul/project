package potato.domain;

import java.sql.Date;
import java.util.Arrays;

public class MyPageReviewDomain {
	private String id,nick,contents;
	private String[] img;
	private int rating, review_idx;
	private Date post_date;
	
	public MyPageReviewDomain() {
		super();
	}

	public MyPageReviewDomain(String id, String nick, String contents, String[] img, int rating, int review_idx,
			Date post_date) {
		super();
		this.id = id;
		this.nick = nick;
		this.contents = contents;
		this.img = img;
		this.rating = rating;
		this.review_idx = review_idx;
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

	public String[] getImg() {
		return img;
	}

	public void setImg(String[] img) {
		this.img = img;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getReview_idx() {
		return review_idx;
	}

	public void setReview_idx(int review_idx) {
		this.review_idx = review_idx;
	}

	public Date getPost_date() {
		return post_date;
	}

	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}

	@Override
	public String toString() {
		return "MyPageReviewDomain [id=" + id + ", nick=" + nick + ", contents=" + contents + ", img="
				+ Arrays.toString(img) + ", rating=" + rating + ", review_idx=" + review_idx + ", post_date="
				+ post_date + "]";
	}
	
}
