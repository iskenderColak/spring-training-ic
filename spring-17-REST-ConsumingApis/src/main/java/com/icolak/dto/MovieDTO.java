package com.icolak.dto;

import com.icolak.enums.MovieState;
import com.icolak.enums.MovieType;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {

    private Long id;
    private String name;
    private LocalDate releaseDate;
    private Integer duration;
    private String summary;
    private MovieType type;
    private MovieState state;
    private BigDecimal price;
    private List<GenreDTO> genreList;
    private boolean deleted;

}
