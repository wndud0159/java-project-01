package kiosk.lotteria.service;

import java.util.List;

import kiosk.lotteria.entity.ProductDto;

public interface AdminService {
	//안내사항 메세지
	public void informationMassage();
	
	//관리자의 아이디, 비번 체크하여 논리데이터 반환
	public boolean checkedUserAndPassword(String user, String password);
	
	// 상품리스트 반환
	public List<ProductDto> productTableList();
		
	// 상품정보리스트 반환
	public List<ProductDto> productInfoTableList();
	
	// 상품 추가
	public void insertProduct(ProductDto product);
	
	// 상품 삭제
	public void deleteProductByType(String type);
	
	// 상품 정보 추가
	public void insertProductInfo(ProductDto product);
	
	// 상품 정보 삭제
	public void deleteProductInfoByName(String name);
	
	// 상품 정보 수정
	public void modifyProductInfoByName(ProductDto product, String name);
	
}
