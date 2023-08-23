package com.example.hotels_api.Service;

import com.example.hotels_api.Api.ApiException;
import com.example.hotels_api.Model.Customer;
import com.example.hotels_api.Model.Order1;
import com.example.hotels_api.Model.OrderStatus;
import com.example.hotels_api.Repository.CustomerRepository;
import com.example.hotels_api.Repository.Order1Repository;
import lombok.RequiredArgsConstructor;
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
            throw new ApiException("ID Not Found");
        }
        return order1Repository.findOrder1ById(id);
    }

    public void addOrder(Order1 order) {
        LocalDate endDate = order.getCreatedAt().plusDays(order.getNumberOfDays());
        order.setEndDate(endDate);
        // Set the initial status to PENDING
        order.setStatus(OrderStatus.PENDING);
        order1Repository.save(order);
    }

    public void updateOrder(Integer id, Order1 order) {
        Order1 order1=order1Repository.findOrder1ById(id);
        if (order1==null) {
            throw new ApiException("Order with ID " + id + " not found");
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
            throw new ApiException("Can't assign orderId or customerId invalid");
        }
        order1.setCustomer(customer);
        order1Repository.save(order1);
    }

    public List<Order1> getOrdersByCustomerId(Integer customerId) {
        return order1Repository.findOrdersByCustomerId(customerId);
    }


    public void cancelOrder(Integer customerId, Integer orderId) {
        Order1 order = order1Repository.findOrder1ById(orderId);
        if (order == null) {
            throw new ApiException("Order with ID " + orderId + " not found");
        }
        if (order.getCustomer() == null) {
            throw new ApiException("Order with ID " + orderId + " does not have an associated customer");
        }
        if (order == null || !order.getCustomer().getId().equals(customerId)) {
            throw new ApiException("Order with ID " + orderId + " not found or not associated with the customer.");
        }

        // Implement logic to update order status to "Canceled" and perform any other necessary actions.
        order.setStatus(OrderStatus.CANCELED);
        order1Repository.save(order);
    }
}
