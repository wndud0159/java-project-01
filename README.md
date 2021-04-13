# lotteria-kiosk
java, jdbc를 이용한 롯데리아 키오스크를 만들어 보쟈....

- UserService
```java
public interface ProductService {
	
	//환영메세지
	public void welcomeMassage();
	
	// 상품의 타입 리스트 반환
	public List<ProductDto> productSelectedType();
	
	// 타입에 의한 상품 리스트 반환
	public List<ProductDto> productListByType(ProductDto productDto);
	
	// 선택한 상품의 수량을 반환
	public ProductDto productQuantity(ProductDto productDto);
	
	// 선택한 상품을 결제or장바구니담기 여부
	public void paymentOrShoppingBasketMassage();
	
	// 계산
	public void calculation(List<ProductDto> list);
	
	// 비어있는 장바구니
	public void emptyShoppingBasket();
	
	// 장바구니 리스트
	public void shoppingBasketList(List<ProductDto> list);
	
	// 장바구니 담기
	public void productAddMassage(ProductDto productDto);
}
```
- AdminService
```java
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
```
