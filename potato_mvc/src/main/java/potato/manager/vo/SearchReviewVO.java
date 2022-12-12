package potato.manager.vo;


public class SearchReviewVO {
	private String keyword,searchType;
	private int dateOrderFlag=1, pageFlag=1, reportOrderFlag;
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public int getDateOrderFlag() {
		return dateOrderFlag;
	}
	public void setDateOrderFlag(int dateOrderFlag) {
		this.dateOrderFlag = dateOrderFlag;
	}
	public int getPageFlag() {
		return pageFlag;
	}
	public void setPageFlag(int pageFlag) {
		this.pageFlag = pageFlag;
	}
	public int getReportOrderFlag() {
		return reportOrderFlag;
	}
	public void setReportOrderFlag(int reportOrderFlag) {
		this.reportOrderFlag = reportOrderFlag;
	} 
	
	
}
