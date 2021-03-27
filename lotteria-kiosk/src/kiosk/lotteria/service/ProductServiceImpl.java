package kiosk.lotteria.service;

import java.util.List;

import kiosk.lotteria.entity.ProductDto;
import kiosk.lotteria.repository.ProductDao;
import kiosk.lotteria.repository.ProductDaoImpl;

public class ProductServiceImpl implements ProductService {
	public List<ProductDto> productTypeList() {
		final ProductDao productDao = ProductDaoImpl.getInstance();
		return productDao.productTypeList();
	}
	
	public List<ProductDto> productListByType(String type) {
		final ProductDao productDao = ProductDaoImpl.getInstance();
		return productDao.productListByType(type);
	}
}
