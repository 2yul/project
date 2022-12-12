package potato.manager.domain;

public class RestDomain {
	private String name, tel, img, line, carwash_chk,repair_chk,cargolounge_chk,retAmImgs,gasAmImgs;
	private int restarea_idx, bookmark_cnt,line_idx,do_idx;
	private double totalRating, lng, lat;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
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
	public String getRetAmImgs() {
		return retAmImgs;
	}
	public void setRetAmImgs(String retAmImgs) {
		this.retAmImgs = retAmImgs;
	}
	public String getGasAmImgs() {
		return gasAmImgs;
	}
	public void setGasAmImgs(String gasAmImgs) {
		this.gasAmImgs = gasAmImgs;
	}
	public int getRestarea_idx() {
		return restarea_idx;
	}
	public void setRestarea_idx(int restarea_idx) {
		this.restarea_idx = restarea_idx;
	}
	public int getBookmark_cnt() {
		return bookmark_cnt;
	}
	public void setBookmark_cnt(int bookmark_cnt) {
		this.bookmark_cnt = bookmark_cnt;
	}
	public int getLine_idx() {
		return line_idx;
	}
	public void setLine_idx(int line_idx) {
		this.line_idx = line_idx;
	}
	public int getDo_idx() {
		return do_idx;
	}
	public void setDo_idx(int do_idx) {
		this.do_idx = do_idx;
	}
	public double getTotalRating() {
		return totalRating;
	}
	public void setTotalRating(double totalRating) {
		this.totalRating = totalRating;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	@Override
	public String toString() {
		return "RestDomain [name=" + name + ", tel=" + tel + ", img=" + img + ", line=" + line + ", carwash_chk="
				+ carwash_chk + ", repair_chk=" + repair_chk + ", cargolounge_chk=" + cargolounge_chk + ", retAmImgs="
				+ retAmImgs + ", gasAmImgs=" + gasAmImgs + ", restarea_idx=" + restarea_idx + ", bookmark_cnt="
				+ bookmark_cnt + ", line_idx=" + line_idx + ", do_idx=" + do_idx + ", totalRating=" + totalRating
				+ ", lng=" + lng + ", lat=" + lat + "]";
	}
	
	
	
}
