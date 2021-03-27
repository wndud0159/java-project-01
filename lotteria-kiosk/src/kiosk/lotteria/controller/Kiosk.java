package kiosk.lotteria.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import kiosk.lotteria.entity.ProductDto;
import kiosk.lotteria.service.ProductService;
import kiosk.lotteria.service.ProductServiceImpl;

public class Kiosk {
	private final Scanner scanner = new Scanner(System.in);
	private final ProductService productService = new ProductServiceImpl();
	private List<ProductDto> productList = new ArrayList<>();
	
	public void run() {
		productList = productService.productTypeList();
		for(int index = 0; index < productList.size(); index++) {
			System.out.println(productList.get(index).getType());
		}
	}
}
