package kiosk.lotteria.entity;

public class ProductDto {
	private int number;
	private String type;
	private String name;
	private long price;
	
	public ProductDto() {};
	
	public ProductDto(String type) {
		this.type = type;
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	
	
	
}
