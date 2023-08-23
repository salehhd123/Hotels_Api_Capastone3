package com.example.hotels_api.Dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BranchDto {

    private Integer hotels_id;

    @NotEmpty(message = "can not be empty !")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @NotEmpty(message = "can not be empty !")
    @Column(columnDefinition = "varchar(20) not null")
    private String neighborhood;

    @NotEmpty(message = "can not be empty !")
    @Column(columnDefinition = "varchar(20) not null")
    private String street;


    @NotEmpty(message = "can not be empty !")
    @Size(min = 9,max = 9,message = "must be 9 digits")
    @Column(columnDefinition = "varchar(9) not null")
    private String phone_number;
}