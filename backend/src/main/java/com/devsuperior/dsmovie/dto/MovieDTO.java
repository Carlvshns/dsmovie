package com.devsuperior.dsmovie.dto;

import com.devsuperior.dsmovie.domain.Movie;

import io.swagger.annotations.ApiModelProperty;

public class MovieDTO {

	@ApiModelProperty(notes = "Movie ID for MovieDTO Object ID", example = "1", required = true)
	private Long id;
	@ApiModelProperty(notes = "Movie Title for MovieDTO Object Title", example = "The Witcher", required = true)
	private String title;
	@ApiModelProperty(notes = "Movie Score for MovieDTO Object Score", example = "4.5", required = true)
	private Double score;
	@ApiModelProperty(notes = "Movie Count for MovieDTO Object Count", example = "2", required = true)
	private Integer count;
	@ApiModelProperty(notes = "Movie image URL for MovieDTO Object Image", example = "https://www.themoviedb.org/t/p/w533_and_h300_bestv2/jBJWaqoSCiARWtfV0GlqHrcdidd.jpg", required = true)
	private String image;
	
	public MovieDTO() {
	}

	public MovieDTO(Long id, String title, Double score, Integer count, String image) {
		this.id = id;
		this.title = title;
		this.score = score;
		this.count = count;
		this.image = image;
	}
	
	public MovieDTO(Movie movie) {
		id = movie.getId();
		title = movie.getTitle();
		score = movie.getScore();
		count = movie.getCount();
		image = movie.getImage();
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
}
