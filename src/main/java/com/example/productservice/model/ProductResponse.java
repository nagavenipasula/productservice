package com.example.productservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductResponse {
	private Long productId;
	private String productname;
	private Long price;
	private Long quantity;
}
