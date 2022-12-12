package potato.manager.domain;

public class FoodDomain {
	private String main_chk, rec_chk,img,name,contents,ingredient;
	private int price, food_idx;
	public String getMain_chk() {
		return main_chk;
	}
	public void setMain_chk(String main_chk) {
		this.main_chk = main_chk;
	}
	public String getRec_chk() {
		return rec_chk;
	}
	public void setRec_chk(String rec_chk) {
		this.rec_chk = rec_chk;
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
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getIngredient() {
		return ingredient;
	}
	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getFood_idx() {
		return food_idx;
	}
	public void setFood_idx(int food_idx) {
		this.food_idx = food_idx;
	}
	
	@Override
	public String toString() {
		return "FoodDomain [main_chk=" + main_chk + ", rec_chk=" + rec_chk + ", img=" + img + ", name=" + name
				+ ", contents=" + contents + ", ingredient=" + ingredient + ", price=" + price + ", food_idx="
				+ food_idx + "]";
	}
	
}
