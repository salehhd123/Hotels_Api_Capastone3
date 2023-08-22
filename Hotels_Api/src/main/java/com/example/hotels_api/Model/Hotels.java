package com.example.hotels_api.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Hotels {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotEmpty(message = "can not be empty !")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;
}
