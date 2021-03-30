package kiosk.lotteria.service;

import java.util.List;

import kiosk.lotteria.entity.AdminDto;
import kiosk.lotteria.entity.ProductDto;
import kiosk.lotteria.repository.ProductDao;
import kiosk.lotteria.repository.ProductDaoImpl;

public class AdminServiceImpl implements AdminService {
	
	ProductDao productDao = ProductDaoImpl.getInstance();
	
	public void adminAccess() {
		System.out.println("---------------");
		System.out.println("관리자 모드 진입");
		System.out.println("---------------");
	}
	
	@Override
	public void informationMassage() {
		System.out.println("-------------------------------안내사항---------------------------------");
		System.out.println("- 'product'테이블 삭제 시 참조하고있는 'productInfo'정보를 삭제해야 삭제 가능");
		System.out.println("- 'productInfo'테이블에 없는 타입 추가 시 'product'테이블 타입을 추가해야 추가 가능");
		System.out.println("- 'product'테이블 추가, 삭제 기능 구현");
		System.out.println("- 'productInfo'테이블 추가, 삭제, 수정 기능 구현");
		System.out.println("----------------------------------------------------------------------");
		System.out.println("1. 'Product'TableInformation");
		System.out.println("2. 'ProductInfo'TableInformation");
		System.out.println("3. 프로그램 종료.");
		System.out.print("선택>>");
	}
	
	@Override
	public boolean checkedUserAndPassword(String user, String password) {
		final AdminDto admin = new AdminDto();
		if(!admin.getUser().equals(user)) {
			System.out.println("아이디 불일치!");
		}
		if(!admin.getPassword().equals(password)) {
			System.out.println("비밀번호 불일치!");
		}
		if(admin.getUser().equals(user) && admin.getPassword().equals(password)) {
			System.out.println("정상적으로 로그인 되었습니다.");
			return false;
		}
		return true;
	}
	
	
	@Override
	public List<ProductDto> productTableList() {
		int count = 1;
		System.out.println("------------------------------------------");
		System.out.println("*. | productId | productType<primaryKey> |");
		final List<ProductDto> list = productDao.productTableList();
		for(ProductDto product : list) {
			System.out.printf("%d. | %d | %s |%n",count,product.getProductId(),product.getProductType());
			count++;
		}
		System.out.println("------------------------------------------");
		System.out.println("1. 추가 / 2. 삭제 / 3. 목록 ");
		System.out.print("선택>>");
		return list;
	}
	
	@Override
	public List<ProductDto> productInfoTableList() {
		int count = 1;
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("*. | productId | productType<reference product> | productName | prpductPrice |");
		final List<ProductDto> list = productDao.productInfoTableList();
		for(ProductDto product : list) {
			System.out.printf("%d. | %d | %s | %s | %d |%n",count,product.getProductId(),product.getProductType(),product.getProductName(),product.getProductPrice());
			count++;
		}
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("1. 추가 / 2. 삭제 / 3. 수정 / 4. 목록 ");
		System.out.print("선택>>");
		return list;
	}
	
	@Override
	public void insertProduct(ProductDto product) {
		productDao.insertProduct(product);
		System.out.println("정상적으로 추가되었습니다.");
	}
	
	@Override
	public void deleteProductByType(String type) {
		productDao.deleteProductByType(type);
		System.out.println("정상적으로 삭제되었습니다.");
	}
	
	@Override
	public void insertProductInfo(ProductDto product) {
		productDao.insertProductInfo(product);
		System.out.println("정상적으로 추가되었습니다.");
	}
	
	@Override
	public void deleteProductInfoByName(String name) {
		productDao.deleteProductInfoByName(name);
		System.out.println("정상적으로 삭제되었습니다.");
	}
	
	@Override
	public void modifyProductInfoByName(ProductDto product, String name) {
		productDao.modifyProductInfoByName(product, name);
		System.out.println("정상적으로 수정되었습니다.");
	}
}
