package potato.domain;

public class UserHomeSliderDomain {
	
	private String img, name, foodName;
	private Double lng, lat;
	private int restarea_idx;
	
	public UserHomeSliderDomain() {
		super();
	}

	public UserHomeSliderDomain(String img, String name, String foodName, Double lng, Double lat, int restarea_idx) {
		super();
		this.img = img;
		this.name = name;
		this.foodName = foodName;
		this.lng = lng;
		this.lat = lat;
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

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
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
		return "UserHomeSliderDomain [img=" + img + ", name=" + name + ", foodName=" + foodName + ", lng=" + lng
				+ ", lat=" + lat + ", restarea_idx=" + restarea_idx + "]";
	}
	
}//class
