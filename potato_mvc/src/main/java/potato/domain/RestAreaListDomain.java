package potato.domain;

public class RestAreaListDomain {
	private int restarea_idx,do_idx;
	private String img,name,line,kr_do;
	private double rating;
	
	public RestAreaListDomain() {

	}

	public RestAreaListDomain(int restarea_idx, int do_idx, String img, String name, String line, String kr_do,
			double rating) {
		this.restarea_idx = restarea_idx;
		this.do_idx = do_idx;
		this.img = img;
		this.name = name;
		this.line = line;
		this.kr_do = kr_do;
		this.rating = rating;
	}

	public int getRestarea_idx() {
		return restarea_idx;
	}

	public void setRestarea_idx(int restarea_idx) {
		this.restarea_idx = restarea_idx;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getKr_do() {
		return kr_do;
	}

	public void setKr_do(String kr_do) {
		this.kr_do = kr_do;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	
	public int getDo_idx() {
		return do_idx;
	}

	public void setDo_idx(int do_idx) {
		this.do_idx = do_idx;
	}

	@Override
	public String toString() {
		return "RestAreaListDomain [restarea_idx=" + restarea_idx + ", do_idx=" + do_idx + ", img=" + img + ", name="
				+ name + ", line=" + line + ", kr_do=" + kr_do + ", rating=" + rating + "]";
	}

}
