package com.hjhamala.comicbuilder.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Constraint;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Comic {
    
	
	private Long id;
	@NotNull
	@Size(min=1)
	private String name;
	@NotNull
	@Size(min=1)
	private String issue;
	@NotNull
	private LocalDate releaseDate;
	@NotNull
	private Set<Story> stories;
	
	public Comic(){
		
	}
	
	public Comic(String name, String issue, LocalDate releaseDate) {
		this.name = name;
		this.issue = issue;
		this.releaseDate = releaseDate;
		
	}
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId(){
		return id;
	}
	
	public void setId(Long id) {
        this.id = id;
	};
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	
	public LocalDate getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	@OneToMany(mappedBy = "comic", cascade = CascadeType.ALL)
	public Set<Story> getStories() {
		return stories;
	}

	public void setStories(Set<Story> stories) {
		this.stories = stories;
	}

	
	@Override
    public String toString() {
        String result = String.format(
                "Comic[id=%s, name='%s', issue='%s', releaseDate='%s']",
                id, name, issue, releaseDate);
        
        if (stories != null) {
            for(Story story: getStories()) {
                result += story.toString();
            }
        }
        return result;
    }
	
	  	
}
