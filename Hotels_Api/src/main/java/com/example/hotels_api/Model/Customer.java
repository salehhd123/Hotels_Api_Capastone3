package com.example.hotels_api.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "First Name should not be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String firstName;


    @NotEmpty(message = "Last Name should not be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String lastName;


    @NotEmpty(message = "Nationality Id should not be empty")
    @Size(min = 10, max = 10, message = "Nationality Id should have exactly 10 digits")
    @Column(columnDefinition = "varchar(10) not null",length = 10) // Set the length of the column
    private String idNationality;


    @NotEmpty(message = "Phone Number should not be empty")
    @Size(min = 10, max = 10, message = "Phone Number should have exactly 10 digits")
    @Column(columnDefinition = "varchar(10) not null",length = 10)
    private String phoneNumber;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Order1> orders;
}
