package potato.vo;

public class SearchFlagVO {
	private String keyword;
	private int filterFlag=1, pageFlag=1;
	
	public SearchFlagVO() {
		
	}

	public SearchFlagVO(String keyword, int filterFlag, int pageFlag) {
		this.keyword = keyword;
		this.filterFlag = filterFlag;
		this.pageFlag = pageFlag;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getFilterFlag() {
		return filterFlag;
	}

	public void setFilterFlag(int filterFlag) {
		this.filterFlag = filterFlag;
	}

	public int getPageFlag() {
		return pageFlag;
	}

	public void setPageFlag(int pageFlag) {
		this.pageFlag = pageFlag;
	}

	@Override
	public String toString() {
		return "SearchFlagVO [keyword=" + keyword + ", filterFlag=" + filterFlag + ", pageFlag="
				+ pageFlag + "]";
	}
	
}
