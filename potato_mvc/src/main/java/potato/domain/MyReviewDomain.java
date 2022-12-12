package potato.domain;

import java.sql.Date;
import java.util.Arrays;

public class MyReviewDomain {
	private String nick, contents, id, img, name, foodimg;
	private int restarea_idx, review_idx, rating, liked, clickount;
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
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFoodimg() {
		return foodimg;
	}
	public void setFoodimg(String foodimg) {
		this.foodimg = foodimg;
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
	public int getLiked() {
		return liked;
	}
	public void setLiked(int liked) {
		this.liked = liked;
	}
	public int getClickount() {
		return clickount;
	}
	public void setClickount(int clickount) {
		this.clickount = clickount;
	}
	public Date getPost_date() {
		return post_date;
	}
	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}
	@Override
	public String toString() {
		return "MyReviewDomain [nick=" + nick + ", contents=" + contents + ", id=" + id + ", img=" + img + ", name="
				+ name + ", foodimg=" + foodimg + ", restarea_idx=" + restarea_idx + ", review_idx=" + review_idx
				+ ", rating=" + rating + ", liked=" + liked + ", clickount=" + clickount + ", post_date=" + post_date
				+ "]";
	}
}
