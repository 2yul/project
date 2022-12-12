package potato.domain;

import java.sql.Date;

public class DetailedReviewDomain {

	private String id, contents, nick, img, name;
	private String foodimg, idclick;
	private int review_idx, rating, likeTotal, liked, lcnt;
	private Date post_date;
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
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
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
	public String getIdclick() {
		return idclick;
	}
	public void setIdclick(String idclick) {
		this.idclick = idclick;
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
	public int getLikeTotal() {
		return likeTotal;
	}
	public void setLikeTotal(int likeTotal) {
		this.likeTotal = likeTotal;
	}
	public int getLiked() {
		return liked;
	}
	public void setLiked(int liked) {
		this.liked = liked;
	}
	public int getLcnt() {
		return lcnt;
	}
	public void setLcnt(int lcnt) {
		this.lcnt = lcnt;
	}
	public Date getPost_date() {
		return post_date;
	}
	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}
	@Override
	public String toString() {
		return "DetailedReviewDomain [id=" + id + ", contents=" + contents + ", nick=" + nick + ", img=" + img
				+ ", name=" + name + ", foodimg=" + foodimg + ", idclick=" + idclick + ", review_idx=" + review_idx
				+ ", rating=" + rating + ", likeTotal=" + likeTotal + ", liked=" + liked + ", lcnt=" + lcnt
				+ ", post_date=" + post_date + "]";
	}

}
