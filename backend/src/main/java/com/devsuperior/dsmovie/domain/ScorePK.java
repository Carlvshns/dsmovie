package com.devsuperior.dsmovie.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import io.swagger.annotations.ApiModelProperty;

@Embeddable
public class ScorePK implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "movie_id")
	@ApiModelProperty(notes = "Movie Object", example = "title: The Witcher, score: 4.5 ...", required = true)
	private Movie movie;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	@ApiModelProperty(notes = "User Object", example = "id: 1, email: maria@gmail.com", required = true)
	private User user;
	
	public ScorePK() {
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
