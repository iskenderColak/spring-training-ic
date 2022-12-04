package com.icolak.dto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieCinemaDTO {

    private Long id;
    private String name;
    private boolean deleted;
}
