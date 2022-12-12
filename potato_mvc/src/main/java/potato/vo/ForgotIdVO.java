package potato.vo;

public class ForgotIdVO {
	private String name, birth, phone;

	public ForgotIdVO() {
		super();
	}

	public ForgotIdVO(String name, String birth, String phone) {
		super();
		this.name = name;
		this.birth = birth;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "ForgotIdVO [name=" + name + ", birth=" + birth + ", phone=" + phone + "]";
	}
	
}
