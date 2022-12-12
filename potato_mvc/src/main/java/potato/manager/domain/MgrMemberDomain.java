package potato.manager.domain;

import java.sql.Date;

public class MgrMemberDomain {
	private String id,nick,birth,phone,email,reason;
	private Date join_date,quit_date;
	
	public MgrMemberDomain() {

	}

	public MgrMemberDomain(String id, String nick, String birth, String phone, String email, String reason,
			Date join_date, Date quit_date) {
		this.id = id;
		this.nick = nick;
		this.birth = birth;
		this.phone = phone;
		this.email = email;
		this.reason = reason;
		this.join_date = join_date;
		this.quit_date = quit_date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getJoin_date() {
		return join_date;
	}

	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}

	public Date getQuit_date() {
		return quit_date;
	}

	public void setQuit_date(Date quit_date) {
		this.quit_date = quit_date;
	}

	@Override
	public String toString() {
		return "MgrMemberDomain [id=" + id + ", nick=" + nick + ", birth=" + birth + ", phone=" + phone + ", email="
				+ email + ", reason=" + reason + ", join_date=" + join_date + ", quit_date=" + quit_date + "]";
	}

}
