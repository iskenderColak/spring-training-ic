package com.icolak.dto;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TicketDTO {

    private Integer seatNumber;
    private Integer rowNumber;
    private LocalDateTime dateTime;
    private MovieCinemaDTO movieCinema;
    private UserDTO userAccount;
    private boolean deleted;

}
