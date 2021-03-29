package kiosk.lotteria.service;

import java.util.List;

import kiosk.lotteria.entity.ProductDto;

public interface ProductService {
	
	//환영메세지
	public void welcomeMassage();
	
	// 상품의 타입을 선택하여 반환
	public ProductDto productSelectedType();
	
	// 타입에 의한 상품 리스트 반환
	public ProductDto productListByType(ProductDto productDto);
	
	// 선택한 상품의 수량을 반환
	public ProductDto productQuantity(ProductDto productDto);
	
	// 수량을 매개변수로 받아 계산처리
	public void calculationByQuantity(ProductDto productDto);
}
