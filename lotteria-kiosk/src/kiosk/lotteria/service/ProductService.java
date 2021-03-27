package kiosk.lotteria.service;

import java.util.List;

import kiosk.lotteria.entity.ProductDto;

public interface ProductService {
	// 상품 타입 리스트
	public List<ProductDto> productTypeList();
	
	// 타입에 의한 상품 리스트
	public List<ProductDto> productListByType(String type);
}
