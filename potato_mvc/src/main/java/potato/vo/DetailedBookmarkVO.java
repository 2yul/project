package potato.vo;

public class DetailedBookmarkVO {
	
	private String id;
	private int restarea_idx;
	
	public DetailedBookmarkVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DetailedBookmarkVO(String id, int restarea_idx) {
		super();
		this.id = id;
		this.restarea_idx = restarea_idx;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getRestarea_idx() {
		return restarea_idx;
	}

	public void setRestarea_idx(int restarea_idx) {
		this.restarea_idx = restarea_idx;
	}

	@Override
	public String toString() {
		return "DetailedBookmarkVO [id=" + id + ", restarea_idx=" + restarea_idx + "]";
	}
	
}
