package potato.manager.vo;

public class MgrMemberVO {
	private String id, searchWord;
	private int memberType,pageFlag=1;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSearchWord() {
		return searchWord;
	}
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
	public int getMemberType() {
		return memberType;
	}
	public void setMemberType(int memberType) {
		this.memberType = memberType;
	}
	public int getPageFlag() {
		return pageFlag;
	}
	public void setPageFlag(int pageFlag) {
		this.pageFlag = pageFlag;
	}
	

	
	
	
}
