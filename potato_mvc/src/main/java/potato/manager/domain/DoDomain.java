package potato.manager.domain;

public class DoDomain {
	private String kr_do;
	private int do_idx;
	
	

	public String getKr_do() {
		return kr_do;
	}

	public void setKr_do(String kr_do) {
		this.kr_do = kr_do;
	}

	public int getDo_idx() {
		return do_idx;
	}

	public void setDo_idx(int do_idx) {
		this.do_idx = do_idx;
	}

	@Override
	public String toString() {
		return "DoDomain [kr_do=" + kr_do + ", do_idx=" + do_idx + "]";
	}
	
}
