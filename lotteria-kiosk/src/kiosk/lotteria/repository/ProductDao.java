package kiosk.lotteria.repository;

import java.util.List;

import kiosk.lotteria.entity.ProductDto;

public interface ProductDao {
	// 상품의 타입을 가져온다
	public List<ProductDto> productTypeList();
	
	// 선택한 타입의 상품을 가져온다
	public List<ProductDto> productListByType(String type);
	

}
