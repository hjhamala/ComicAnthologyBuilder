package com.hjhamala.comicbuilder.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Story {
	
	
	private Long id;
	@NotNull
	private String name;
	@NotNull
	private String arc;
	@Min(1)
	private int part;
	@Min(1)
	private int startingPage;
	@Min(1)
	private int endingPage;
	@NotNull
	private String series;
	@NotNull
	private Comic comic;
	
	public Story(){
		
	}
	
	public Story(String name, String arc, int part, int startingPage, int endingPage, String series, Comic comic) {
		this.name = name;
		this.arc = arc;
		this.part = part;
		this.startingPage = startingPage;
		this.endingPage = endingPage;
		this.series = series;
		this.comic = comic;
	}
	
	/**
	 * For stories without arc
	 * @param name
	 * @param part
	 * @param startingPage
	 * @param endingPage
	 * @param series
	 * @param comic
	 */
	public Story(String name, int part, int startingPage, int endingPage, String series, Comic comic) {
		this.name = name;
		this.arc = "";
		this.part = part;
		this.startingPage = startingPage;
		this.endingPage = endingPage;
		this.series = series;
		this.comic = comic;
	}
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId(){
		return id;
	}
	
	public void setId(Long id) {
	        this.id = id;
	};
	
	public String getSeries() {
		return series;
	}
	public void setSeries(String series) {
		this.series = series;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getArc() {
		return arc;
	}
	public void setArc(String arc) {
		this.arc = arc;
	}
	public int getPart() {
		return part;
	}
	public void setPart(int part) {
		this.part = part;
	}
	public int getStartingPage() {
		return startingPage;
	}
	public void setStartingPage(int startingPage) {
		this.startingPage = startingPage;
	}
	public int getEndingPage() {
		return endingPage;
	}
	public void setEndingPage(int endingPage) {
		this.endingPage = endingPage;
	}
	
	@ManyToOne
	@JoinColumn(name = "comic_id")
	public Comic getComic() {
		return comic;
	}
	public void setComic(Comic comic) {
		this.comic = comic;
	}
	
	@Override
	public String toString(){
		return String.format("Story[id='%s', name='%s', arc='%s', part='%s', startingPage='%s', endingPage='%s', comic='%s']", 
				this.id, this.name, this.arc, this.part, this.startingPage, this.endingPage, this.comic.getId());
	}
}
