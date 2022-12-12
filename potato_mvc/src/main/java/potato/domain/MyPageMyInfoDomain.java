package potato.domain;

import java.sql.Date;

public class MyPageMyInfoDomain {
	private String img,name,nick,id,phone,email;
	private Date birth;
	
	public MyPageMyInfoDomain() {
		// TODO Auto-generated constructor stub
	}

	public MyPageMyInfoDomain(String img, String name, String nick, String id, String phone, String email, Date birth) {
		super();
		this.img = img;
		this.name = name;
		this.nick = nick;
		this.id = id;
		this.phone = phone;
		this.email = email;
		this.birth = birth;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "MyPageMyInfoDomain [img=" + img + ", name=" + name + ", nick=" + nick + ", id=" + id + ", phone="
				+ phone + ", email=" + email + ", birth=" + birth + "]";
	}
	
	
	
	
}//class
