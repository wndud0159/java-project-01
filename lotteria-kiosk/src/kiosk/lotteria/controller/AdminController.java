package kiosk.lotteria.controller;

import java.util.List;
import java.util.Scanner;

import kiosk.lotteria.entity.ProductDto;
import kiosk.lotteria.service.AdminServiceImpl;

public class AdminController {
	final AdminServiceImpl adminService = new AdminServiceImpl();
	final Scanner scanner = new Scanner(System.in);
	
	
	
	public void adminAccess() {
		adminService.adminAccess();
		
		boolean checkedAdmin = true;
		int exitStack = 0;
		
		while(checkedAdmin) {
			System.out.print("user : ");
			String user = scanner.next();
			System.out.print("password : ");
			String password = scanner.next();	
			checkedAdmin = adminService.checkedUserAndPassword(user, password);
			exitStack++;
			if(exitStack == 3) {
				System.out.println("3회 입력 실패! 프로그램종료.");
				System.exit(0);
			}
		}
		welcomeAdmin();
	}
	
	
	
	private void welcomeAdmin() {
		adminService.informationMassage();
		int selected = scanner.nextInt();
		switch(selected) {
		case 1: 
			product();
			break;
		case 2:
			productInfo();
			break;
		default:
			System.out.println("프로그램 정상 종료.");
			System.exit(0);
		}
		
	}
	
	private void product() {
		final List<ProductDto> list = adminService.productTableList();
		int selected = scanner.nextInt();
		switch(selected) {
		case 1:
			productAdd();
		case 2:
			productDelete(list);
		default:
			welcomeAdmin();
		}
	}
	
	private void productAdd() {
		System.out.print("productId(숫자) : ");
		long productId = scanner.nextLong();
		System.out.print("productType : ");
		String productType = scanner.next();
		System.out.println("1. 추가 / 2. 목록");
		System.out.print("선택>>");
		int selected = scanner.nextInt();
		if(selected == 1) {
			adminService.insertProduct(new ProductDto(productId, productType));
			product();
		} else {
			welcomeAdmin();
		}
	}
	
	private void productDelete(List<ProductDto> list) {
		System.out.print("좌측 번호 선택 >>");
		int selected = scanner.nextInt();
		System.out.println("-----------------------------------");
		System.out.printf("선택 레코드 : | %d | %s |%n",list.get(selected-1).getProductId(),list.get(selected-1).getProductType());
		System.out.println("-----------------------------------");
		System.out.println("1. 삭제 / 2. 목록 ");
		System.out.print("선택>>");
		int selected2 = scanner.nextInt();
		if(selected2 == 1) {
			adminService.deleteProductByType(list.get(selected-1).getProductType());
			product();
		} else {
			welcomeAdmin();
		}
	}
	
	private void productInfo() {
		final List<ProductDto> list = adminService.productInfoTableList();
		int selected = scanner.nextInt(); 
		switch(selected) {
		case 1:
			productInfoAdd();
			break;
		case 2:
			productInfoDelete(list);
			break;
		case 3:
			productInfoModify(list);
			break;
		default:
			welcomeAdmin();
		}
	}
	
	private void productInfoAdd() {
		System.out.print("productId(숫자) : ");
		long productId = scanner.nextLong();
		System.out.print("productType : ");
		String productType = scanner.next();
		System.out.print("productName : ");
		String productName = scanner.next();
		System.out.print("productPrice(숫자) : ");
		long productPrice =scanner.nextLong();
		System.out.println("1. 추가 / 2. 목록 ");
		System.out.print("선택>>");
		int selected = scanner.nextInt();
		if(selected == 1) {
			adminService.insertProductInfo(new ProductDto(productId,productType,productName,productPrice));
			productInfo();
		} else {
			welcomeAdmin();
		}
		
	}
	
	private void productInfoDelete(List<ProductDto> list) {
		System.out.print("좌측 번호 선택 >>");
		int selected = scanner.nextInt();
		System.out.println("-----------------------------------");
		System.out.printf("선택 레코드 : | %d | %s | %s | %d |%n"
				,list.get(selected-1).getProductId()
				,list.get(selected-1).getProductType()
				,list.get(selected-1).getProductName()
				,list.get(selected-1).getProductPrice());
		System.out.println("-----------------------------------");
		System.out.println("1. 삭제 / 2. 목록 ");
		System.out.print("선택>>");
		int selected2 = scanner.nextInt();
		if(selected2 == 1) {
			adminService.deleteProductInfoByName(list.get(selected-1).getProductName());
			productInfo();
		} else {
			welcomeAdmin();
		}
	}
	
	private void productInfoModify(List<ProductDto> list) {
		System.out.print("좌측 번호 선택 >>");
		int selected = scanner.nextInt();
		System.out.println("-----------------------------------");
		System.out.printf("선택 레코드 : | %d | %s | %s | %d |%n"
				,list.get(selected-1).getProductId()
				,list.get(selected-1).getProductType()
				,list.get(selected-1).getProductName()
				,list.get(selected-1).getProductPrice());
		System.out.println("-----------------------------------");
		System.out.print("productId(숫자) : ");
		long productId = scanner.nextLong();
		System.out.print("productType : ");
		String productType = scanner.next();
		System.out.print("productName : ");
		String productName = scanner.next();
		System.out.print("productPrice(숫자) : ");
		long productPrice =scanner.nextLong();
		System.out.println("1. 수정 / 2. 목록 ");
		System.out.print("선택>>");
		int selected2 = scanner.nextInt();
		if(selected2 == 1) {
			adminService.modifyProductInfoByName(new ProductDto(productId,productType,productName,productPrice), list.get(selected-1).getProductName());
			productInfo();
		} else {
			welcomeAdmin();
		}
	}
	
		
} 
