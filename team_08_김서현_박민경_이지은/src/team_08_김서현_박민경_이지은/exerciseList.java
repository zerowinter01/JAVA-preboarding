package team_08_김서현_박민경_이지은;

public class exerciseList {
	private int no;
	private String title;
	private String part;
	private String url;
	
	public exerciseList() {}
	
	public exerciseList(int no, String title, String genre, String url) {
		this.no = no;
		this.title = title;
		this.part = part;
		this.url = url;
	}
	
	public int getNo() {
		return no;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getPart() {
		return part;
	}
	
	public void setPart(String part) {
		this.part = part;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return no +" "+ part + "  " + title;
	}
}
