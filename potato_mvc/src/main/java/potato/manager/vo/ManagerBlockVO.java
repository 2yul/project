package potato.manager.vo;

import java.sql.Date;

public class ManagerBlockVO {
	private String id;
	private int block_idx;
	private Date block_date;
	
	public ManagerBlockVO() {

	}

	public ManagerBlockVO(String id, int block_idx, Date block_date) {
		this.id = id;
		this.block_idx = block_idx;
		this.block_date = block_date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getBlock_idx() {
		return block_idx;
	}

	public void setBlock_idx(int block_idx) {
		this.block_idx = block_idx;
	}

	public Date getBlock_date() {
		return block_date;
	}

	public void setBlock_date(Date block_date) {
		this.block_date = block_date;
	}

	@Override
	public String toString() {
		return "ManagerBlockVO [id=" + id + ", block_idx=" + block_idx + ", block_date=" + block_date + "]";
	}
}
