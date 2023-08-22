package com.example.hotels_api.Controller;

import com.example.hotels_api.Model.Order1;
import com.example.hotels_api.Service.Order1Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class Order1Controller {

    private final Order1Service order1Service;

    @GetMapping("/get")
    public ResponseEntity getAllOrders() {
        return ResponseEntity.status(200).body(order1Service.getAllOrders());
    }

    @GetMapping("/getOrderById/{id}")
    public ResponseEntity getOrderById(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(order1Service.getOrderById(id));
    }

    @PostMapping("/add")
    public ResponseEntity addOrder(@RequestBody Order1 order) {
        order1Service.addOrder(order);
        return ResponseEntity.status(200).body("Order added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateOrder(@PathVariable Integer id, @RequestBody Order1 order) {
            order1Service.updateOrder(id, order);
            return ResponseEntity.status(200).body("Order updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Integer id) {
        order1Service.deleteOrder(id);
        return ResponseEntity.status(200).body("Order deleted successfully");
    }

    @PostMapping("/assign/{orderId}/To/{customerId}")
    public ResponseEntity assignTeacherToCouse(@PathVariable Integer orderId, @PathVariable Integer customerId ){
        order1Service.assignOrderToCustomer(orderId, customerId);
        return ResponseEntity.status(200).body("Assigned");
    }
}
