package com.pos.controller;

import com.pos.dto.ProductDto;
import com.pos.entity.Order;
import com.pos.service.OrderService;
import com.pos.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping(path = "/order")
public class OrderController {
    private final OrderService orderService;
    private final SaleService saleService;

    @PostMapping
    public Order insert(@RequestBody List<ProductDto> products) {
        return saleService.save(products);
    }
    @GetMapping
    public List<Order> findAll(){
        return orderService.findAll();
    }
}
