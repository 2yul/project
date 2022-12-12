package potato.manager.vo;

public class MgrPassChangeVO {
	private String pass,new_pw;

	public MgrPassChangeVO() {
	
	}

	public MgrPassChangeVO(String pass, String new_pw) {
		this.pass = pass;
		this.new_pw = new_pw;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getNew_pw() {
		return new_pw;
	}

	public void setNew_pw(String new_pw) {
		this.new_pw = new_pw;
	}

	@Override
	public String toString() {
		return "MgrPassChangeVO [pass=" + pass + ", new_pw=" + new_pw + "]";
	}
	
}
