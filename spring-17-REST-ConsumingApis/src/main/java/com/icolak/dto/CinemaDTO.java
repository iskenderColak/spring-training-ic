package com.icolak.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CinemaDTO {

    private Long id;
    private String name;
    private String sponsoredName;
    private LocationDTO location;
    private boolean deleted;
}
