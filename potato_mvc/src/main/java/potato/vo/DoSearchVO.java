package potato.vo;

public class DoSearchVO {
	private int pageFlag=1,do_idx,filterFlag=1;

	public DoSearchVO() {
	}

	public DoSearchVO(int pageFlag, int do_idx, int filterFlag) {
		this.pageFlag = pageFlag;
		this.do_idx = do_idx;
		this.filterFlag = filterFlag;
	}

	public int getPageFlag() {
		return pageFlag;
	}

	public void setPageFlag(int pageFlag) {
		this.pageFlag = pageFlag;
	}

	public int getDo_idx() {
		return do_idx;
	}

	public void setDo_idx(int do_idx) {
		this.do_idx = do_idx;
	}

	public int getFilterFlag() {
		return filterFlag;
	}

	public void setFilterFlag(int filterFlag) {
		this.filterFlag = filterFlag;
	}

	@Override
	public String toString() {
		return "DoSearchVO [pageFlag=" + pageFlag + ", do_idx=" + do_idx + ", filterFlag=" + filterFlag + "]";
	}

}
