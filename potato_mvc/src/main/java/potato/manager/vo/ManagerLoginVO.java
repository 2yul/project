package potato.manager.vo;

public class ManagerLoginVO {
	private String manager_id, pass;

	public ManagerLoginVO() {
		super();
	}

	public ManagerLoginVO(String manager_id, String pass) {
		super();
		this.manager_id = manager_id;
		this.pass = pass;
	}

	public String getManager_id() {
		return manager_id;
	}

	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "ManagerLoginVO [manager_id=" + manager_id + ", pass=" + pass + "]";
	}
	
}
