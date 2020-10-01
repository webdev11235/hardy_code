package model;

public class BookTag {
	private String isbn13;
	private String tagName;
	
	public BookTag(String isbn13, String tagName) {
		super();
		this.isbn13 = isbn13;
		this.tagName = tagName;
	}

	public String getIsbn13() {
		return isbn13;
	}

	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	@Override
	public String toString() {
		return "BookTag [isbn13=" + isbn13 + ", tagName=" + tagName + "]";
	}
	
	
}
