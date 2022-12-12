package potato.vo;

import java.sql.Date;

public class UserHomeVisitorVO {

	private String ip;
	private Date access_date;
	
	public UserHomeVisitorVO() {
		super();
	}

	public UserHomeVisitorVO(String ip, Date access_date) {
		super();
		this.ip = ip;
		this.access_date = access_date;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getAccess_date() {
		return access_date;
	}

	public void setAccess_date(Date access_date) {
		this.access_date = access_date;
	}

	@Override
	public String toString() {
		return "VisitorVO [ip=" + ip + ", access_date=" + access_date + "]";
	}
	
}//class
