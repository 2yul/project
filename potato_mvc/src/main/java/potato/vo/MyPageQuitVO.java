package potato.vo;

public class MyPageQuitVO {
	private String id,pass;
	
	public MyPageQuitVO() {
	}

	public MyPageQuitVO(String id, String pass) {
		super();
		this.id = id;
		this.pass = pass;
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

	@Override
	public String toString() {
		return "MyPageQuitVO [id=" + id + ", pass=" + pass + "]";
	}
	
	
}//class
