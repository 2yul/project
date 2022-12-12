package potato.vo;

public class MyPagePwEditVO {
	
	private  String id,pass,new_pw;
	
	public MyPagePwEditVO() {
		// TODO Auto-generated constructor stub
	}

	public MyPagePwEditVO(String id, String pass, String new_pw) {
		super();
		this.id = id;
		this.pass = pass;
		this.new_pw = new_pw;
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

	public String getNew_pw() {
		return new_pw;
	}

	public void setNew_pw(String new_pw) {
		this.new_pw = new_pw;
	}

	@Override
	public String toString() {
		return "MyPagePwEditVO [id=" + id + ", pass=" + pass + ", new_pw=" + new_pw + "]";
	}
	
	
	
	
}//class
