package com.example.hotels_api.Model;


import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Positive(message = "Number of rooms should be numbers")
    @Column(columnDefinition = "int",nullable = false)
    private Integer numberOfRooms;

    @Column(columnDefinition = "bit not null")
    private Boolean hasKitchen=false;

    @NotNull
    @PositiveOrZero(message = "Number Of Bathroom should be number ")
    @Column(columnDefinition = "int not null")
    private Integer numberOfBathroom;


    @Column(columnDefinition = "bit not null")
    private Boolean available=false;


    @NotNull
    @Column(columnDefinition = "int not null")
    private Double price;







}
