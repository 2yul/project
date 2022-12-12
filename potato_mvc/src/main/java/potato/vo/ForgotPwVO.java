package potato.vo;

public class ForgotPwVO {
	private String name, id, phone, temp;

	public ForgotPwVO() {
		super();
	}

	public ForgotPwVO(String name, String id, String phone, String temp) {
		super();
		this.name = name;
		this.id = id;
		this.phone = phone;
		this.temp = temp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	@Override
	public String toString() {
		return "ForgotPwVO [name=" + name + ", id=" + id + ", phone=" + phone + ", temp=" + temp + "]";
	}
	
}
