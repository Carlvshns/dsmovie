package com.devsuperior.dsmovie.dto;

import io.swagger.annotations.ApiModelProperty;

public class ScoreDTO {

	@ApiModelProperty(notes = "ID of Movie Object", example = "1")
	private Long movieId;
	@ApiModelProperty(notes = "Email of User Object", example = "maria@gmail.com")
	private String email;
	@ApiModelProperty(notes = "Score of Movie that is Associated", example = "4.5")
	private Double score;
	
	public ScoreDTO() {
	}

    public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}
}
