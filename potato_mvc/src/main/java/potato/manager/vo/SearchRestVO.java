package potato.manager.vo;

public class SearchRestVO {
	private String keyword, carwash_chk, repair_chk, cargolounge_chk;
	private int lineFlag, pageFlag = 1;
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getCarwash_chk() {
		return carwash_chk;
	}
	public void setCarwash_chk(String carwash_chk) {
		this.carwash_chk = carwash_chk;
	}
	public String getRepair_chk() {
		return repair_chk;
	}
	public void setRepair_chk(String repair_chk) {
		this.repair_chk = repair_chk;
	}
	public String getCargolounge_chk() {
		return cargolounge_chk;
	}
	public void setCargolounge_chk(String cargolounge_chk) {
		this.cargolounge_chk = cargolounge_chk;
	}
	public int getLineFlag() {
		return lineFlag;
	}
	public void setLineFlag(int lineFlag) {
		this.lineFlag = lineFlag;
	}
	public int getPageFlag() {
		return pageFlag;
	}
	public void setPageFlag(int pageFlag) {
		this.pageFlag = pageFlag;
	}
	@Override
	public String toString() {
		return "SearchRestVO [keyword=" + keyword + ", carwash_chk=" + carwash_chk + ", repair_chk=" + repair_chk
				+ ", cargolounge_chk=" + cargolounge_chk + ", lineFlag=" + lineFlag + ", pageFlag=" + pageFlag + "]";
	}
	
	
	
	
}
