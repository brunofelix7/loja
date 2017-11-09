package br.com.casadocodigo.loja.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;
	private Integer pages;
	private String summaryPath;
	
	@DateTimeFormat
	private Calendar releaseDate;
	
	@ElementCollection
	private List<Price> prices = new ArrayList<Price>();
	
	public Product(){
		
	}

	public Product(Long id, String title, String description, Integer pages, String summaryPath, Calendar releaseDate, List<Price> prices) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.pages = pages;
		this.summaryPath = summaryPath;
		this.releaseDate = releaseDate;
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

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public String getSummaryPath() {
		return summaryPath;
	}

	public void setSummaryPath(String summaryPath) {
		this.summaryPath = summaryPath;
	}

	public Calendar getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Calendar releaseDate) {
		this.releaseDate = releaseDate;
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
				+ ", summaryPath=" + summaryPath + ", releaseDate=" + releaseDate + ", prices=" + prices + "]";
	}

}
