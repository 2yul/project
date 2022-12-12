package potato.manager.domain;

public class MgrBlockReasonDomain {
	private int block_idx;
	private String reason;
	
	public MgrBlockReasonDomain() {
	
	}

	public MgrBlockReasonDomain(int block_idx, String reason) {
		this.block_idx = block_idx;
		this.reason = reason;
	}

	public int getBlock_idx() {
		return block_idx;
	}

	public void setBlock_idx(int block_idx) {
		this.block_idx = block_idx;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "BlockReasonDomain [block_idx=" + block_idx + ", reason=" + reason + "]";
	}
	
}
