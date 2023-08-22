package com.example.hotels_api.Service;

import com.example.hotels_api.Api.ApiExeption;
import com.example.hotels_api.Model.Customer;
import com.example.hotels_api.Model.Order1;
import com.example.hotels_api.Repository.CustomerRepository;
import com.example.hotels_api.Repository.Order1Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Order1Service {

    private final Order1Repository order1Repository;
    private final CustomerRepository customerRepository;

    public List<Order1> getAllOrders() {
        return order1Repository.findAll();
    }

    public Order1 getOrderById(Integer id) {
        Order1 order1=order1Repository.findOrder1ById(id);
        if (order1 == null) {
            throw new ApiExeption("ID Not Found");
        }
        return order1Repository.findOrder1ById(id);
    }

    public void addOrder(Order1 order) {
        LocalDate endDate = order.getCreatedAt().plusDays(order.getNumberOfDays());
        order.setEndDate(endDate);
        order1Repository.save(order);
    }

    public void updateOrder(Integer id, Order1 order) {
        Order1 order1=order1Repository.findOrder1ById(id);
        if (order1==null) {
            throw new ApiExeption("Order with ID " + id + " not found");
        }
        order.setNumberOfDays(order1.getNumberOfDays());
        order1Repository.save(order);
    }

    public void deleteOrder(Integer id) {
        order1Repository.deleteById(id);
    }

    public void assignOrderToCustomer(Integer orderId, Integer customerId){
        Customer customer =customerRepository.findCustomerById(customerId);
        Order1 order1=order1Repository.findOrder1ById(orderId);

        if(customer ==null || order1==null){
            throw new ApiExeption("Can't assign orderId or customerId invalid");
        }
        order1.setCustomer(customer);
        order1Repository.save(order1);
    }
}
