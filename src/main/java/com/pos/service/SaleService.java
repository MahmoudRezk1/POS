package com.pos.service;

import com.pos.dto.ProductDto;
import com.pos.entity.Order;
import com.pos.entity.Product;
import com.pos.entity.Sale;
import com.pos.repository.SaleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleService {
    private final SaleRepo saleRepo;
    private final OrderService orderService;

    public Order save(List<ProductDto> products) {
        if (products.isEmpty())
            return null;
        Order order = orderService.save(products);
        products.forEach(product -> {
            Sale sale = new Sale();
            sale.setProductId(product.getProductId());
            sale.setOrderId(order.getOrderId());
            saleRepo.save(sale);
        });
        return order;
    }

    public List<Sale> findAll(){
        return saleRepo.findAll();
    }
    public List<Sale> findByOrderId(int orderId){
        return saleRepo.findByOrderId(orderId);
    }
}
