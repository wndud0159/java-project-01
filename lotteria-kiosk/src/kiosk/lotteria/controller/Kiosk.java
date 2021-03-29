package kiosk.lotteria.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import kiosk.lotteria.entity.ProductDto;
import kiosk.lotteria.service.ProductService;
import kiosk.lotteria.service.ProductServiceImpl;

public class Kiosk {

	private final ProductService productService = new ProductServiceImpl();
	
	public void run() {
		productService.welcomeMassage();
		ProductDto productDto = productService.productListByType(productService.productSelectedType());
		productService.calculationByQuantity(productService.productQuantity(productDto));
	}
}
