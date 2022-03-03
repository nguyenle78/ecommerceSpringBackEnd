package com.nguyenle.ecommerce.service;

import com.nguyenle.ecommerce.dao.ProductRepo;
import com.nguyenle.ecommerce.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService {
    private final ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }


    public Page<Product> findRandomWelcomePage() {
        //Set default page and page offset
        List<Product> randomOrderList = productRepo.findByRandomOrder();
        Pageable pageable = PageRequest.of(0, 15);

        int start = (int) pageable.getOffset();
        int end = (start + pageable.getPageSize()) > randomOrderList.size() ? randomOrderList.size() : (start + pageable.getPageSize());
        long totalRows = randomOrderList.size();
        // Use sublist to dived the whole list to smaller list, otherwise the page will contain all
        return new PageImpl<>(randomOrderList.subList(start, end), pageable, totalRows);
    }

    public Page<Product> findRandom(int page, int size) {
        //Set default page and page offset
        List<Product> randomOrderList = productRepo.findByRandomOrder();
        Pageable pageable = PageRequest.of(page, size);

        int start = (int) pageable.getOffset();
        int end = (start + pageable.getPageSize()) > randomOrderList.size() ? randomOrderList.size() : (start + pageable.getPageSize());
        long totalRows = randomOrderList.size();
        // Use sublist to dived the whole list to smaller list, otherwise the page will contain all
        return new PageImpl<>(randomOrderList.subList(start, end), pageable, totalRows);
    }
}
