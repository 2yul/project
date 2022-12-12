package potato.domain;

public class OtherReviewUserDomain {
	private String img,nick;

	public OtherReviewUserDomain() {
		super();
	}

	public OtherReviewUserDomain(String img, String nick) {
		super();
		this.img = img;
		this.nick = nick;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	@Override
	public String toString() {
		return "OtherReviewUserDomain [img=" + img + ", nick=" + nick + "]";
	}
	
}
