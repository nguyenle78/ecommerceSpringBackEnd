package com.nguyenle.ecommerce.controller;

import com.nguyenle.ecommerce.entity.Product;
import com.nguyenle.ecommerce.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /*
        @GetMapping("/our-products")
        public ResponseEntity<List<Product>> getAllProduct() {
            List<Product> products = productService.findRandom();
            return new ResponseEntity<>(products, HttpStatus.OK);
        }

     */
    @GetMapping("/our-products")
    public ResponseEntity<Page<Product>> getProductWelcomePage() {
        return new ResponseEntity<>(productService.findRandomWelcomePage(), HttpStatus.OK);
    }

   
}
