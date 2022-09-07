package com.devsuperior.dsmovie.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "tb_score")
public class Score {

	@EmbeddedId
	@ApiModelProperty(notes = "ScorePK Object for create a key between Movie Table and User Table", example = "Movie: movieProperties, User: userProperties ...", required = true)
	private ScorePK id = new ScorePK();
	
	@ApiModelProperty(notes = "Value where score is storaged", example = "4.5", required = true)
	private Double value;
	
	public Score() {
	}
	
	public void setMovie(Movie movie) {
		id.setMovie(movie);
	}

	public void setUser(User user) {
		id.setUser(user);
	}
	
	public ScorePK getId() {
		return id;
	}

	public void setId(ScorePK id) {
		this.id = id;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
}
