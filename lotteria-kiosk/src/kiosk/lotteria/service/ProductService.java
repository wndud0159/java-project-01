package kiosk.lotteria.service;

import java.util.List;

import kiosk.lotteria.entity.ProductDto;

public interface ProductService {
	
	//환영메세지
	public void welcomeMassage();
	
	// 상품의 타입을 선택하여 반환
	public List<ProductDto> productSelectedType();
	
	// 타입에 의한 상품 리스트 반환
	public List<ProductDto> productListByType(ProductDto productDto);
	
	// 선택한 상품의 수량을 반환
	public ProductDto productQuantity(ProductDto productDto);
	
	// 선택한 상품을 결제or장바구니담기 여부
	public void paymentOrShoppingBasketMassage();
	
	// 계산
	public void calculation(List<ProductDto> list);
	
	// 비어있는 장바구니
	public void emptyShoppingBasket();
	
	// 장바구니 리스트
	public void shoppingBasketList(List<ProductDto> list);
	
	// 장바구니 담기
	public void productAddMassage(ProductDto productDto);
}
