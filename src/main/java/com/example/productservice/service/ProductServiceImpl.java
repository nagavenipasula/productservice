package com.example.productservice.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.productservice.Exception.ProductServiceCustomException;
import com.example.productservice.entity.Product;
import com.example.productservice.model.ProductRequest;
import com.example.productservice.model.ProductResponse;
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

	@Override
	public ProductResponse getproduct(Long id) {
		// TODO Auto-generated method stub
//		Optional<Product> product= productRepository.findById(id);
//		Product product1=product.get();
//		log.info("product1=="+product1);
//		ProductResponse response=new ProductResponse();
//		BeanUtils.copyProperties(product1, response);
//		return response;
		
		Product product1=productRepository.findById(id).orElseThrow(()-> new ProductServiceCustomException("product not found with given id", "Product Not Found"));
		log.info("product1=="+product1);
		ProductResponse response=new ProductResponse();
		BeanUtils.copyProperties(product1, response);
		return response;
	}

	@Override
	public void reduceQuantity(long productId, long quantity) {
		log.info("productId=="+productId+"  quantity="+quantity);
		 Product product=productRepository.findById(productId).orElseThrow(()->
		 new ProductServiceCustomException("product id not present"," Product Id Not Found"));
		 if(product.getQuantity()<quantity) {
			 throw new ProductServiceCustomException("product doesn't have suffient quantity", " INSUFFISIENT QUANTITY");
		 }
		 product.setQuantity(product.getQuantity()-quantity);
		 productRepository.save(product);
		 log.info("Product quantity updated successfully");
		
		
	}

}
