package br.com.casadocodigo.loja.model;

public class Product {
	
	private Long id;
	private String title;
	private String description;
	private int pages;
		
	public Product(){
		
	}
	
	public Product(String title, String description, int pages) {
		super();
		this.title = title;
		this.description = description;
		this.pages = pages;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", description=" + description + ", pages=" + pages + "]";
	}

}
