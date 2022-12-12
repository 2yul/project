package potato.manager.domain;

public class AmenityDomain {
	private String amenity_type, icon;
	private int restarea_idx;
	
	
	public String getAmenity_type() {
		return amenity_type;
	}

	public void setAmenity_type(String amenity_type) {
		this.amenity_type = amenity_type;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public int getRestarea_idx() {
		return restarea_idx;
	}

	public void setRestarea_idx(int restarea_idx) {
		this.restarea_idx = restarea_idx;
	}

	@Override
	public String toString() {
		return "AmenityDomain [amenity_type=" + amenity_type + ", icon=" + icon + ", restarea_idx=" + restarea_idx
				+ "]";
	}
	
}
