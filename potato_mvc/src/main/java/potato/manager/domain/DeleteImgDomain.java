package potato.manager.domain;

public class DeleteImgDomain {
	private String img, foodImg;

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getFoodImg() {
		return foodImg;
	}

	public void setFoodImg(String foodImg) {
		this.foodImg = foodImg;
	}

	@Override
	public String toString() {
		return "DeleteImgDomain [img=" + img + ", foodImg=" + foodImg + "]";
	}
	
}
