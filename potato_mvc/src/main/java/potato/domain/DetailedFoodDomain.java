package potato.domain;

public class DetailedFoodDomain {

	private String main_chk, rec_chk, img, name, contents, ingredient;
	private int restarea_idx, food_idx, price;
	
	public DetailedFoodDomain() {
		super();
	}

	public DetailedFoodDomain(String main_chk, String rec_chk, String img, String name, String contents,
			String ingredient, int restarea_idx, int food_idx, int price) {
		super();
		this.main_chk = main_chk;
		this.rec_chk = rec_chk;
		this.img = img;
		this.name = name;
		this.contents = contents;
		this.ingredient = ingredient;
		this.restarea_idx = restarea_idx;
		this.food_idx = food_idx;
		this.price = price;
	}

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

	public int getRestarea_idx() {
		return restarea_idx;
	}

	public void setRestarea_idx(int restarea_idx) {
		this.restarea_idx = restarea_idx;
	}

	public int getFood_idx() {
		return food_idx;
	}

	public void setFood_idx(int food_idx) {
		this.food_idx = food_idx;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "DetailedFoodDomain [main_chk=" + main_chk + ", rec_chk=" + rec_chk + ", img=" + img + ", name=" + name
				+ ", contents=" + contents + ", ingredient=" + ingredient + ", restarea_idx=" + restarea_idx
				+ ", food_idx=" + food_idx + ", price=" + price + "]";
	}
	
}
