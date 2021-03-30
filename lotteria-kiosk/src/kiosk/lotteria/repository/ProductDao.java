package kiosk.lotteria.repository;

import java.util.List;

import kiosk.lotteria.entity.ProductDto;

public interface ProductDao {
	// 상품의 타입을 가져온다
	public List<ProductDto> productTypeList();
	
	// 선택한 타입의 상품을 가져온다
	public List<ProductDto> productListByType(String type);
	
	//---------------------------Admin----------------------
	
	// productTableList
	public List<ProductDto> productTableList();
	
	// porudctInfoTableList
	public List<ProductDto> productInfoTableList();
	
	// insertProduct
	public void insertProduct(ProductDto product);
	
	// deleteProduct
	public void deleteProductByType(String type);
	
	// insertProductInfo
	public void insertProductInfo(ProductDto product);
	
	// deleteProductInfo
	public void deleteProductInfoByName(String name);
	
	// modifyProductInfo
	public void modifyProductInfoByName(ProductDto product, String name);
	

}
