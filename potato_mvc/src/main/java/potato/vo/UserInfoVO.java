package potato.vo;

public class UserInfoVO {
	private String id, pass, img, name, nick, birth, email, phone;

	public UserInfoVO() {
		super();
	}

	public UserInfoVO(String id, String pass, String img, String name, String nick, String birth, String email,
			String phone) {
		super();
		this.id = id;
		this.pass = pass;
		this.img = img;
		this.name = name;
		this.nick = nick;
		this.birth = birth;
		this.email = email;
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
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

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "UserInfoVO [id=" + id + ", pass=" + pass + ", img=" + img + ", name=" + name + ", nick=" + nick
				+ ", birth=" + birth + ", email=" + email + ", phone=" + phone + "]";
	}
	
}
