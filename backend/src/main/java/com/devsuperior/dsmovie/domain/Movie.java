package com.devsuperior.dsmovie.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "tb_movie")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Movie ID", example = "1", required = true)
	private Long id;
	@ApiModelProperty(notes = "Movie Title", example = "The Witcher", required = true)
	@NotNull(message = "The field 'title' is mandatory")
	private String title;
	@ApiModelProperty(notes = "Movie Score", example = "4.5", required = true)
	@NotNull(message = "The field 'score' is mandatory")
	private Double score;
	@ApiModelProperty(notes = "Quantity users rating The Movie", example = "2", required = true)
	@NotNull(message = "The field 'count' is mandatory")
	private Integer count;
	@ApiModelProperty(notes = "Image URL", example = "https://www.themoviedb.org/t/p/w533_and_h300_bestv2/jBJWaqoSCiARWtfV0GlqHrcdidd.jpg", required = true)
	@NotNull(message = "The field 'image' is mandatory")
	private String image;
	
	@OneToMany(mappedBy = "id.movie")
	@ApiModelProperty(notes = "List of Scores associated to Movie", example = "4.5", required = false)
	private Set<Score> scores = new HashSet<>();
	
	public Movie() {
	}

	public Movie(Long id, String title, Double score, Integer count, String image) {
		this.id = id;
		this.title = title;
		this.score = score;
		this.count = count;
		this.image = image;
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

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Set<Score> getScores() {
		return scores;
	}
}
