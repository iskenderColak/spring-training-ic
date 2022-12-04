package com.icolak.dto;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.icolak.enums.UserRole;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private String email;
    private String password;
    private String username;
    private UserRole role = UserRole.USER;
    @JsonManagedReference
    private AccountDTO account;
    private boolean deleted;
}
