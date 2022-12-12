package potato.domain;

public class MyPageBookmarkDomain {
	
	private String id,name;
	private int restarea_idx;
	
	public MyPageBookmarkDomain() {
		// TODO Auto-generated constructor stub
	}

	public MyPageBookmarkDomain(String id, String name, int restarea_idx) {
		super();
		this.id = id;
		this.name = name;
		this.restarea_idx = restarea_idx;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRestarea_idx() {
		return restarea_idx;
	}

	public void setRestarea_idx(int restarea_idx) {
		this.restarea_idx = restarea_idx;
	}

	@Override
	public String toString() {
		return "MyPageBookmarkDomain [id=" + id + ", name=" + name + ", restarea_idx=" + restarea_idx + "]";
	}
	
}//class
