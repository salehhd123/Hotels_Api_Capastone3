package com.example.hotels_api.Repository;

import com.example.hotels_api.Model.Order1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Order1Repository extends JpaRepository<Order1,Integer> {

    Order1 findOrder1ById(Integer id);

    List<Order1> findOrdersByCustomerId(Integer id);
}
