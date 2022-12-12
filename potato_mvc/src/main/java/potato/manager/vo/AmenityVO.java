package potato.manager.vo;

import java.util.Arrays;

public class AmenityVO {
	private String amenity_type;
	private String[] restIcons, gasIcons; 
	private int restarea_idx;
	public String getAmenity_type() {
		return amenity_type;
	}
	public void setAmenity_type(String amenity_type) {
		this.amenity_type = amenity_type;
	}
	public String[] getRestIcons() {
		return restIcons;
	}
	public void setRestIcons(String[] restIcons) {
		this.restIcons = restIcons;
	}
	public String[] getGasIcons() {
		return gasIcons;
	}
	public void setGasIcons(String[] gasIcons) {
		this.gasIcons = gasIcons;
	}
	public int getRestarea_idx() {
		return restarea_idx;
	}
	public void setRestarea_idx(int restarea_idx) {
		this.restarea_idx = restarea_idx;
	}
	@Override
	public String toString() {
		return "AmenityVO [amenity_type=" + amenity_type + ", restIcons=" + Arrays.toString(restIcons) + ", gasIcons="
				+ Arrays.toString(gasIcons) + ", restarea_idx=" + restarea_idx + "]";
	}
	
}
