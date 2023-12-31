package com.example.hotels_api.Model;




import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Branch {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;


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

    @ManyToOne
    @JoinColumn(name = "hotels_id",referencedColumnName = "id")
    @JsonIgnore
    private Hotels hotels;
  
  

}

