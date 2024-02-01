package com.example.productservice.service;

import com.example.productservice.entity.Product;
import com.example.productservice.model.ProductRequest;
import com.example.productservice.model.ProductResponse;

public interface ProductService {

	Long addproduct(ProductRequest productRequest);

	ProductResponse getproduct(Long id);

	void reduceQuantity(long productId, long quantity);

}
