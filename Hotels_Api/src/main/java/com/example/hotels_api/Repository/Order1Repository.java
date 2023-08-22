package com.example.hotels_api.Repository;

import com.example.hotels_api.Model.Order1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Order1Repository extends JpaRepository<Order1,Integer> {

    Order1 findOrder1ById(Integer id);
}
