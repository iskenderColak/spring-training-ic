package com.icolak.entity;

import com.icolak.enums.MovieState;
import com.icolak.enums.MovieType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Movie extends BaseEntity {

    private String name;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime releaseDate;

    private Integer duration;

    @Column(columnDefinition = "text")
    private String summary;

    @Enumerated(EnumType.STRING)
    private MovieState state;

    @Enumerated(EnumType.STRING)
    private MovieType type;

    private BigDecimal price;

    @ManyToMany
    @JoinTable(name = "movie_genre_rel", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genreList;
}
