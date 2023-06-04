package com.pos.service;

import com.pos.dto.ProductDto;
import com.pos.entity.Order;
import com.pos.repository.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepo orderRepo;

    public Order save(List<ProductDto> products) {
        if (products.isEmpty()) {
            return null;
        } else {
            double total = 0;
            for (ProductDto product : products) {
                total += product.getProductPrice();
            }
            Order order = new Order();
            order.setTotal(total);
            return orderRepo.save(order);
        }
    }
    public List<Order> findAll(){
        return orderRepo.findAll();
    }
}
