package potato.domain;

public class UserHomeMapDomain {

	private String name; 
	private Double lng, lat;
	private int restarea_idx;
	
	public UserHomeMapDomain() {
		super();
	}

	public UserHomeMapDomain(String name, Double lng, Double lat, int restarea_idx) {
		super();
		this.name = name;
		this.lng = lng;
		this.lat = lat;
		this.restarea_idx = restarea_idx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getRestarea_idx() {
		return restarea_idx;
	}

	public void setRestarea_idx(int restarea_idx) {
		this.restarea_idx = restarea_idx;
	}

	@Override
	public String toString() {
		return "UserHomeMapDomain [name=" + name + ", lng=" + lng + ", lat=" + lat + ", restarea_idx=" + restarea_idx
				+ "]";
	}
	
}//class
