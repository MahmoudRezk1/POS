package com.pos.service;

import com.pos.entity.Product;
import com.pos.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo productRepo;


    public Product findById(int id){
        return productRepo.findById(id).orElseThrow();
    }
    public List<Product> findAll(){
        return productRepo.findAll();
    }
    public Product findByBarcode(String barcode){
        return productRepo.findByBarcode(barcode);
    }
    public Product insert(Product product){
        return productRepo.save(product);
    }
    public Product update(Product product){
        return productRepo.save(product);
    }

    public void delete(int id){
        productRepo.deleteById(id);
    }
}
