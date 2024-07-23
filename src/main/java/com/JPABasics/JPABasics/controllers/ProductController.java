package com.JPABasics.JPABasics.controllers;

import com.JPABasics.JPABasics.entities.ProductEntity;
import com.JPABasics.JPABasics.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/products")
@RequiredArgsConstructor
public class ProductController {

    private final int PAGE_SIZE =5;
    private final ProductRepository productRepository;
    @GetMapping
    public List<ProductEntity> getAllProducts(
            @RequestParam(defaultValue = "") String title,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "0") Integer pageNumber){
//        return productRepository.findByOrderByPrice();
//        return productRepository.findBy(Sort.by(Sort.Direction.DESC,sortBy,"price"));

//        return productRepository.findBy(Sort.by(
//                Sort.Order.desc(sortBy),
//                Sort.Order.desc("title")));



//        Pageable pageable= PageRequest.of(
//                pageNumber,
//                PAGE_SIZE,
//                Sort.by(sortBy));
//        return productRepository.findAll(pageable).getContent();

        return productRepository.findByTitleContainingIgnoreCase(
                title,
                PageRequest.of(pageNumber,PAGE_SIZE,Sort.by(sortBy))
        );
    }





}
