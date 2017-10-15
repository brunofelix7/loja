package br.com.casadocodigo.loja.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;
	private int pages;
	
	@ElementCollection
	private List<Price> prices = new ArrayList<Price>();
		
	public Product(){
		
	}
	
	public Product(Long id, String title, String description, int pages, List<Price> prices) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.pages = pages;
		this.prices = prices;
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
	
	public List<Price> getPrices() {
		return prices;
	}
	
	public void setPrices(List<Price> prices) {
		this.prices = prices;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", description=" + description + ", pages=" + pages
				+ ", prices=" + prices + "]";
	}

}
