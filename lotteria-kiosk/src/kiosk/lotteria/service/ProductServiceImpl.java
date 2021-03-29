package kiosk.lotteria.service;

import java.util.List;
import java.util.Scanner;

import kiosk.lotteria.entity.ProductDto;
import kiosk.lotteria.repository.ProductDao;
import kiosk.lotteria.repository.ProductDaoImpl;

public class ProductServiceImpl implements ProductService {
	
	Scanner scanner = new Scanner(System.in);
	
	@Override
	public void welcomeMassage() {
		System.out.println("롯데리아에 오신걸 환영합니다.");
	}
	
	public ProductDto productSelectedType() {
		final ProductDao productDao = ProductDaoImpl.getInstance();
		final List<ProductDto> list = productDao.productTypeList();
		
		for(ProductDto product : list) {
			System.out.printf("%d. %s%n",product.getProductId(),product.getProductType());
		}
		System.out.print("선택(숫자입력)>>");
		int selection = scanner.nextInt();
		return list.get(selection-1);
	}
	
	@Override
	public ProductDto productListByType(ProductDto productDto) {
		final ProductDao productDao = ProductDaoImpl.getInstance();
		final List<ProductDto> list = productDao.productListByType(productDto.getProductType());
		
		System.out.println("-------------------");
		System.out.println("-------------------");
		for(ProductDto product : list) {
			System.out.printf("%d. %s : %d원%n",product.getProductId(),product.getProductName(),product.getProductPrice());
		}
		System.out.print("선택(숫자입력)>>");
		int selection = scanner.nextInt();
		
		return list.get(selection-1);
		
	}
	
	@Override
	public ProductDto productQuantity(ProductDto productDto) {
		System.out.println("-------------------");
		System.out.println("-------------------");
		System.out.print("수량을 선택 해주세요(숫자만)>>");
		
		productDto.setQuantity(scanner.nextLong());
		
		return productDto;
	}
	
	@Override
	public void calculationByQuantity(ProductDto productDto) {
		productDto.setProductPrice(productDto.getProductPrice()*productDto.getQuantity());
		System.out.printf("선택한 상품 : %s %n선택한 수량 : %d %n총 가격 : %d",productDto.getProductName(),productDto.getQuantity(),productDto.getProductPrice());
		
	}
}
