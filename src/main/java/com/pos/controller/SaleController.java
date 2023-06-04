package com.pos.controller;

import com.pos.entity.Sale;
import com.pos.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping(path = "/sale")
public class SaleController {
    private final SaleService saleService;
    @GetMapping
    public List<Sale> findAll(){
        return saleService.findAll();
    }
    @GetMapping(path = "/order/{orderId}")
    public List<Sale> findByOrderId(@PathVariable int orderId){
        return saleService.findByOrderId(orderId);
    }
}
