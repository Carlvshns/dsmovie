package com.devsuperior.dsmovie.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.dto.ScoreDTO;
import com.devsuperior.dsmovie.services.ScoreService;

@RestController
@RequestMapping(value = "/scores")
@Api(value = "Endpoints to manage Scores")
public class ScoreController {
	
	@Autowired
	private ScoreService service;
	
	@ApiOperation(value = "Save score in DB associated to The Movie")
    @ApiResponse(code = 204, message = "CREATED", response = MovieDTO[].class)
	@PutMapping()
	public ResponseEntity<MovieDTO> saveScore(@RequestBody ScoreDTO dto) {
		MovieDTO movieDTO = service.saveScore(dto);
		return new ResponseEntity<>(movieDTO, HttpStatus.CREATED);
	}
}
