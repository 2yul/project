package potato.domain;

public class DetailedDomain {
	
	private String name, tel, carwash_chk, repair_chk, cargolounge_chk, line, kr_do;
	private Double lng, lat, rating;
	
	public DetailedDomain() {
		super();
	}

	public DetailedDomain(String name, String tel, String carwash_chk, String repair_chk, String cargolounge_chk,
			String line, String kr_do, Double lng, Double lat, Double rating) {
		super();
		this.name = name;
		this.tel = tel;
		this.carwash_chk = carwash_chk;
		this.repair_chk = repair_chk;
		this.cargolounge_chk = cargolounge_chk;
		this.line = line;
		this.kr_do = kr_do;
		this.lng = lng;
		this.lat = lat;
		this.rating = rating;
	}

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

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "DetailedDomain [name=" + name + ", tel=" + tel + ", carwash_chk=" + carwash_chk + ", repair_chk="
				+ repair_chk + ", cargolounge_chk=" + cargolounge_chk + ", line=" + line + ", kr_do=" + kr_do + ", lng="
				+ lng + ", lat=" + lat + ", rating=" + rating + "]";
	}
	
}
