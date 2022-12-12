package potato.vo;

public class MyPageLoginVO {
	private String id,pass;
	
	public MyPageLoginVO() {
	}

	public MyPageLoginVO(String id, String pass) {
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
		return "MyPageLoginVO [id=" + id + ", pass=" + pass + "]";
	}
	
	
}//class
