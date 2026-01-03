package com.pos.controller;

import com.pos.entity.Product;
import com.pos.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping(path = "/product")
public class    ProductController {
    private final ProductService productService;
    @GetMapping
    public List<Product> findAll(){
        return productService.findAll();
    }
    @GetMapping("/id/{id}")
    public Product findByBarcode(@PathVariable int id){
        return productService.findById(id);
    }
    @GetMapping("/barcode/{barcode}")
    public Product findByBarcode(@PathVariable String barcode){
        return productService.findByBarcode(barcode);
    }
    @PostMapping
    public Product insert(@RequestBody Product product){
        return productService.insert(product);
    }
    @PutMapping
    public Product update(@RequestBody Product product){
        return productService.update(product);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        productService.delete(id);
    }
}
