package potato.domain;

public class ListMapPinDomain {
	private int line_idx,restarea_idx;
	private double lng,lat;
	private String name;
	
	public ListMapPinDomain() {

	}

	public ListMapPinDomain(int line_idx, int restarea_idx, double lng, double lat, String name) {
		this.line_idx = line_idx;
		this.restarea_idx = restarea_idx;
		this.lng = lng;
		this.lat = lat;
		this.name = name;
	}

	public int getLine_idx() {
		return line_idx;
	}

	public void setLine_idx(int line_idx) {
		this.line_idx = line_idx;
	}

	public int getRestarea_idx() {
		return restarea_idx;
	}

	public void setRestarea_idx(int restarea_idx) {
		this.restarea_idx = restarea_idx;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ListMapPinDomain [line_idx=" + line_idx + ", restarea_idx=" + restarea_idx + ", lng=" + lng + ", lat="
				+ lat + ", name=" + name + "]";
	}
}
