package com.icolak.service;

import com.icolak.dto.MovieCinemaDTO;

import java.util.List;

public interface MovieCinemaService {

    List<MovieCinemaDTO> findAll();
    MovieCinemaDTO findById(Long id);

}
