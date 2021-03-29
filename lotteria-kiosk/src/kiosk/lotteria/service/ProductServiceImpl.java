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
		System.out.println("-------------------");
		System.out.println("-------------------");
		System.out.println("롯데리아에 오신걸 환영합니다.");
		System.out.println("1. 쇼핑하기");
		System.out.println("2. 장바구니 확인");
		System.out.print("선택>>");
	}
	
	@Override
	public List<ProductDto> productSelectedType() {
		final ProductDao productDao = ProductDaoImpl.getInstance();
		final List<ProductDto> list = productDao.productTypeList();
		System.out.println("-------------------");
		System.out.println("-------------------");
		for(ProductDto product : list) {
			System.out.printf("%d. %s%n",product.getProductId(),product.getProductType());
		}
		System.out.println("0. 뒤로가기");
		System.out.print("선택>>");
		
		return list;
	}
	
	@Override
	public List<ProductDto> productListByType(ProductDto productDto) {
		final ProductDao productDao = ProductDaoImpl.getInstance();
		final List<ProductDto> list = productDao.productListByType(productDto.getProductType());
		
		System.out.println("-------------------");
		System.out.println("-------------------");
		for(ProductDto product : list) {
			System.out.printf("%d. %s : %d원%n",product.getProductId(),product.getProductName(),product.getProductPrice());
		}
		System.out.println("0. 뒤로가기");
		System.out.print("선택>>");
		
		return list;
	}
	
	@Override
	public ProductDto productQuantity(ProductDto productDto) {
		System.out.print("수량 선택>>");
		
		return productDto;
	}
	
	@Override
	public void calculation(List<ProductDto> list) {
		long total = 0;
		System.out.println("-------------------");
		for(ProductDto product : list) {
			product.setProductPrice(product.getProductPrice()*product.getQuantity());
			total += product.getProductPrice();
			System.out.printf("%s %d개 : %d원%n",product.getProductName(),product.getQuantity(),product.getProductPrice());
		}
		System.out.println("-------------------");
		System.out.println("총 결제 금액 : " + total + "원");	
	}
	
	@Override
	public void emptyShoppingBasket() {
		System.out.println("-------------------");
		System.out.println("-------------------");
		System.out.println("장바구니가 비어있습니다.");
		System.out.println("0. 뒤로가기");
		System.out.print("선택>>");
	}
	
	@Override
	public void productAddMassage(ProductDto productDto) {
		System.out.println("-------------------");
		System.out.println("-------------------");
		System.out.printf("%s를 %d개 담았습니다.%n",productDto.getProductName(),productDto.getQuantity());
	}
	
	@Override
	public void paymentOrShoppingBasketMassage() {
		System.out.println("1. 결제 / 2. 장바구니 담기");
		System.out.print("선택>>");
	}
	
	@Override
	public void shoppingBasketList(List<ProductDto> list) {
		System.out.println("-------------------");
		System.out.println("-------------------");
		for(ProductDto product : list) {
			System.out.printf("%s : %d개%n",product.getProductName(),product.getQuantity());
		}
		System.out.println("1. 결제 / 0. 뒤로가기 / 9. 비우기");
		System.out.print("선택>>");
	}
}
