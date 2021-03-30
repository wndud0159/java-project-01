package kiosk.lotteria.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import kiosk.lotteria.entity.ProductDto;
import kiosk.lotteria.service.ProductService;
import kiosk.lotteria.service.ProductServiceImpl;

public class Kiosk {
	
	private final ProductService productService = new ProductServiceImpl();
	private final List<ProductDto> shoppingBasket = new ArrayList<>();
	final Scanner scanner = new Scanner(System.in);
	
	
	
	public void run() {
		productService.welcomeMassage();
		int selected = scanner.nextInt();
		if(selected == 1) {
			chooseType();
		} else if(selected == 2) {
			shoppingBasket();
		} else if(selected == 3) {
			final AdminController admin = new AdminController();
			admin.adminAccess();
		} else {
			System.out.println("프로그램 정상 종료.");
			System.exit(0);
		}
	}
	
	
	
	private void shoppingBasket() {
		if(shoppingBasket.size() == 0) {		
			productService.emptyShoppingBasket();
			int selected = scanner.nextInt();
			if(selected == 0) {
				run();
			}
		} else {
			productService.shoppingBasketList(shoppingBasket);
			int selected2 = scanner.nextInt();
			if(selected2 == 0) {
				run();
			} else if(selected2 == 9) {
				shoppingBasket.clear();
				run();
			} else {
				productService.calculation(shoppingBasket);
			}
		}
	}
	
	
	
	private void chooseType() {
		List<ProductDto> list = productService.productSelectedType();
		int selected = scanner.nextInt();
		
		if(selected == 0) {
			run();
		} else {
			chooseProduct(list.get(selected-1));
		}
	}
	
	
	private void chooseProduct(ProductDto productDto) {
		List<ProductDto> list = productService.productListByType(productDto);
		int selected = scanner.nextInt();
		
		if(selected == 0) {
			chooseType();
		} else {
			chooseQuantity(list.get(selected-1));
		}
	}
	
	
	
	private void chooseQuantity(ProductDto productDto) {
		ProductDto product = productService.productQuantity(productDto);
		product.setQuantity(scanner.nextLong());
		paymentOrShoppingBasket(product);
	}
	
	
	
	private void paymentOrShoppingBasket(ProductDto productDto) {
		productService.paymentOrShoppingBasketMassage();
		int selected = scanner.nextInt();
		
		if(selected == 1) {
			shoppingBasket.add(productDto);
			productService.calculation(shoppingBasket);
		} else {
			productService.productAddMassage(productDto);
			shoppingBasket.add(productDto);
			run();
		}
	}
}
