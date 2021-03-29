package kiosk.lotteria.entity;

public class ProductDto {
	private long productId;
	private String productType;
	private String productName;
	private long productPrice;
	private long quantity;
	
	public ProductDto() {};
	
	public ProductDto(long productId, String productType) {
		this.productId = productId;
		this.productType = productType;
	}
	
	public ProductDto(long productId, String productName, long productPrice) {
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
	}

	
	
	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public long getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(long productPrice) {
		this.productPrice = productPrice;
	}
	
	
		
}
