package com.icolak.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties(value = {"address", "country"}, ignoreUnknown = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountDTO {

    @JsonIgnore
    private String name;
    private String address;
    private String country;
    private String state;
    private String city;
    private Integer age;
    private String postalCode;
    @JsonBackReference (value = "user-account-reference")
    // If we use @JsonIgnore instead of @JsonBackReference, we can not send and get user(completely ignored)
    // however now we can send user but not get user. This is difference between these two.
    // This field is not going to be serialized
    private UserDTO user;
}