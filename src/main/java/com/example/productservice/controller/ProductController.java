package com.example.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.productservice.model.ProductRequest;
import com.example.productservice.service.ProductService;

@RestController
@RequestMapping(value = "/v1")
public class ProductController {
	@Autowired
 private ProductService productService;
	
	@PostMapping(value = "/product")
	public ResponseEntity<Long> addUser(@RequestBody ProductRequest productRequest)
{
	Long productId=	productService.addproduct(productRequest);	
	return new ResponseEntity<>(productId,HttpStatus.ACCEPTED);
		}
}
