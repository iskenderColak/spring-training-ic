package com.icolak.dto;

import com.icolak.enums.AddressType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressDTO {

    @JsonIgnore
    private Long id;

    private String street;
    private String country;
    private String state;
    private String city;
    private String postalCode;

    private AddressType addressType;

    @JsonBackReference(value = "student-address-reference")          // Since we have more than one class which has
    private StudentDTO student;                             // address field, we should assign different values then
                                                           // spring is able to differ them
    @JsonBackReference(value = "parent-address-reference")          // defaultReference
    private ParentDTO parent;

    @JsonBackReference(value = "teacher-address-reference")          // defaultReference
    private TeacherDTO teacher;

    private Integer currentTemperature;     // Weather information, which we will later get it from 3rd party API
    // we don't put this field in entity class, so until we consume and get the info this field ganna be null,
    // if null by using @JsonInclude(JsonInclude.Include.NON_NULL) we don't display this field
}