package com.icolak.service;

import com.icolak.dto.GenreDTO;

public interface GenreService {

    GenreDTO save(GenreDTO genreDTO);
    void deleteById(Long id);

}
