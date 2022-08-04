import java.util.ArrayList;

public class Category {
	private String catName;
	private boolean deleted;

	public Category(String catName) {
		this.catName = catName;
	}

	public String getCatName() {
		return catName;
	}

	public boolean isDeleted() {
		return deleted;
	}
	
	public void setIsDeleted(boolean deleted) {
		this.deleted = deleted ;
	}
	
}
