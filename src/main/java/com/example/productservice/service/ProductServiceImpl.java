package com.example.productservice.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productservice.entity.Product;
import com.example.productservice.model.ProductRequest;
import com.example.productservice.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Long addproduct(ProductRequest productRequest) {
		// TODO Auto-generated method stub
		log.info("Product started");
		Product product= new Product();
		product.setProductname(productRequest.getName());
		product.setPrice(productRequest.getPrice());
		product.setQuantity(productRequest.getQuantity());
		productRepository.save(product);
		log.info("product created");
		return product.getProductId();
	}

}
